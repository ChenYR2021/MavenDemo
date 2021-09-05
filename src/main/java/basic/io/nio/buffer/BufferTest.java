package basic.io.nio.buffer;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 *
 *  目标：对缓冲区Buffer的常用API进行案例实现。
 *
 *  Buffer clear() 清空缓冲区并返回对缓冲区的引用
 *  Buffer flip() 为 将缓冲区的界限设置为当前位置，并将当前位置充值为 0
 *  int capacity() 返回 Buffer 的 capacity 大小
 *  boolean hasRemaining() 判断缓冲区中是否还有元素
 *  int limit() 返回 Buffer 的界限(limit) 的位置
 *  Buffer limit(int n) 将设置缓冲区界限为 n, 并返回一个具有新 limit 的缓冲区对象
 *  Buffer mark() 对缓冲区设置标记
 *  int position() 返回缓冲区的当前位置 position
 *  Buffer position(int n) 将设置缓冲区的当前位置为 n , 并返回修改后的 Buffer 对象
 *  int remaining() 返回 position 和 limit 之间的元素个数
 *  Buffer reset() 将位置 position 转到以前设置的 mark 所在的位置
 *  Buffer rewind() 将位置设为为 0， 取消设置的 mark
 *  ByteBuffer compact() :方法将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面
 *
 */
public class BufferTest {

    CharsetDecoder decoder = Charset.defaultCharset().newDecoder();

    /**
     * 1.new ByteBuffer
     * 2.ByteBuffer.capacity()
     * 3.ByteBuffer.limit()
     * 4.ByteBuffer.position()
     * 5.ByteBuffer.flip()  // 写转读，limit->position, position = 0
     * 6.ByteBuffer.rewind() // 写转读，position = 0
     * 7.ByteBuffer.clear() // 读转写，limit -> capacity, position = 0
     * 8.ByteBuffer.compact() // 读转写，将limit之后没有读的元素拷贝到位置0, position = limit - 已读元素大小
     */
    public void bufferApi() {
        try {
            /*
             * 1.通过allocate方法创建1个ByteBuffer
             *   1) new一个ByteBuffer->HeapByteBuffer，构造函数HeapByteBuffer(int cap, int lim)，lim = cap
             *   2) HeapByteBuffer调用父类ByteBuffer(int mark, int pos, int lim, int cap, byte[] hb, int offset)构造函数构造一个ByteBuffer
             *   3) 参数设置如下                          -1,       0,       lim,     cap, new byte[cap],    0
             */
            ByteBuffer buffer = ByteBuffer.allocate(10);
            System.out.println("------1.allocate 10 --------");
            System.out.println("  buffer.capacity() = " + buffer.capacity());  // 10
            System.out.println("  buffer.limit() = " + buffer.limit());        // 10
            System.out.println("  buffer.position() = " + buffer.position());  // 0

            String string = "itheima";
            buffer.put(string.getBytes());
            System.out.println("------2.put itheima --------");
            System.out.println("  buffer.capacity() = " + buffer.capacity());  // 10
            System.out.println("  buffer.limit() = " + buffer.limit());        // 10
            System.out.println("  buffer.position() = " + buffer.position());  // 7

            /**
             * 3.flip函数主要用于将Buffer由写模式切换到读模式，主要做以下几件事情
             * 1) limit = position  将limit设置到当前的位置，保证读的时候不会越界
             * 2) position = 0      设置当前位置为0，保证读的时候从0开始
             * 3) marks = -1        清除所有的标记
             *
             * 【疑问】flip能由读模式切换到写模式吗？
             * 【答】不可以，模式切换到写模式需要调用clear方法，原先的数据会依然保存，但是可能会被覆盖
             *      参考文档：https://bbs.huaweicloud.com/blogs/200771
             */
            buffer.flip();
            System.out.println("------3.buffer.flip() --------");
            System.out.println("  buffer.capacity() = " + buffer.capacity());  // 10
            System.out.println("  buffer.limit() = " + buffer.limit());        // 7，【重要】0变成7，保证读的时候不会越界
            System.out.println("  buffer.position() = " + buffer.position());  // 0
            System.out.println("  [After read] String = " + decoder.decode(buffer));        // itheima，decode会返回1个CharBuffer
            System.out.println("  [After read] buffer.position() = " + buffer.position());  // 7，读完之后由0变成7

            buffer.flip();
            byte[] bytes = new byte[3];
            System.out.println("------4.buffer.flip() 2times --------");
            System.out.println("  buffer.capacity() = " + buffer.capacity());  // 10
            System.out.println("  buffer.limit() = " + buffer.limit());        // 7,【重要】7变成7，保证读的时候不会越界
            System.out.println("  buffer.position() = " + buffer.position());  // 0
            buffer.get(bytes);
            System.out.println("  [After read] String = " + new String(bytes));             // decode会返回1个CharBuffer
            System.out.println("  [After read] buffer.position() = " + buffer.position());  // 3，读了3个byte，position变成3

            // 连续使用flip，这种方式应该不太对，limit会置为position，越来越小
            buffer.flip();
            System.out.println("------4.buffer.flip() 3times --------");
            System.out.println("  buffer.capacity() = " + buffer.capacity());  // 10
            System.out.println("  buffer.limit() = " + buffer.limit());        // 3,【非常重要】7变成3
            System.out.println("  buffer.position() = " + buffer.position());  // 0

            /**
             * rewind函数主要用于将Buffer由写模式切换到读模式，但是与flip有点不同，不处理limit
             * 1) position = 0      设置当前位置为0，保证读的时候从0开始
             * 2) marks = -1        清除所有的标记
             */
            buffer.limit(7); // 重新设置为7
            System.out.println("------5.buffer.rewind()--------");
            buffer.get(bytes);  //【注意】只有get(byte[])会重置position，如果是get(int index)不会重置
            System.out.println("  buffer.limit() = " + buffer.limit());        // 7
            System.out.println("  buffer.position() = " + buffer.position());  // 3
            buffer.rewind();
            System.out.println("  [After rewind] buffer.limit() = " + buffer.limit());        // 7，【非常重要】rewind与flip的差别就是limit不会重置
            System.out.println("  [After rewind] buffer.position() = " + buffer.position());  // 0

            /**
             * clear函数主要用于将Buffer由读模式切换到写模式，主要做以下几种事情
             * 1) limit = capacity  【与flip的差异】将limit设置最大容量出，保证写的时候不会越界
             * 2) position = 0      设置当前位置为0，保证读的时候从0开始
             * 3) marks = -1        清除所有的标记
             */
            System.out.println("------6.buffer.clear() --------");
            buffer.get(bytes);
            System.out.println("  buffer.limit() = " + buffer.limit());        // 7
            System.out.println("  buffer.position() = " + buffer.position());  // 3
            buffer.clear();
            System.out.println("  [After clear] buffer.limit() = " + buffer.limit());        // 10，【重要】limit置为capacity,10
            System.out.println("  [After clear] buffer.position() = " + buffer.position());  // 0, 【重要】position置为0

            /**
             * clear函数主要用于将Buffer由读模式切换到写模式，主要做以下几种事情
             * 1) limit = capacity  【与flip的差异】将limit设置最大容量出，保证写的时候不会越界
             * 2) position = 0      设置当前位置为0，保证读的时候从0开始
             * 3) marks = -1        清除所有的标记
             */
            System.out.println("------7.buffer.compact() --------");
            buffer.put(string.getBytes());
            System.out.println("  buffer.limit() = " + buffer.limit());        // 10
            System.out.println("  buffer.position() = " + buffer.position());  // 7
            buffer.flip(); // 写转读
            buffer.get(bytes);
            System.out.println("  [After get] String = " + new String(bytes));             // ith
            System.out.println("  [After get] buffer.limit() = " + buffer.limit());        // 7
            System.out.println("  [After get] buffer.position() = " + buffer.position());  // 3
            buffer.compact();
            System.out.println("  [After clear] buffer.limit() = " + buffer.limit());        // 10，【重要】limit置为capacity,10
            System.out.println("  [After clear] buffer.position() = " + buffer.position());  // 4,  【重要】因为将没有读的4个字节拷贝到位置0，position置为4
            buffer.put("baba".getBytes());
            buffer.flip();
            System.out.println("  [After compact and append] string = " + decoder.decode(buffer));   // eimababa，【重要】limit置为capacity,10

            /**
             * mark：标记位置，mark = position
             * reset：回到标记位置，position = mark
             * hasRemaining：当前位置是否小于limit
             * remaining:limit - position
             */
            System.out.println("------8.buffer.mark() & buffer.reset() --------");
            buffer.clear();
            buffer.put(string.getBytes());
            buffer.flip();
            buffer.get(bytes);
            System.out.println("  Time 1 String = " + new String(bytes));
            buffer.mark();
            buffer.get(bytes);
            System.out.println("  Time 2 String = " + new String(bytes));
            buffer.reset();
            System.out.println("  Time 3 [After reset] String = " + new String(bytes));
            if (buffer.hasRemaining()) {
                System.out.println("  Time 4 [HasRemaining] String = " + buffer.remaining());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.ByteBuffer.allocateDirect()
     */
    public void bufferApi2() {
        /**
         * 通过allocateDirect方法创建1个DirectByteBuffer
         *   1) new一个ByteBuffer->MappedByteBuffer->DirectByteBuffer，在OS的本地内存中栈上分配内存
         *   2) 【注意】因为是OS的本地内存，GC无法管理，所以释放的时候要主动释放，调用DirectByteBuffer.cleaner().clean()取手动释放，否则可能会造成内存泄漏
         *       参考文档：https://blog.csdn.net/weixin_33918262/article/details/114461415
         *       DirectByteBuffer的实现机制：https://blog.csdn.net/dnuvb68642/article/details/102248897/?utm_term=java.nio.bits&utm_medium=distribute.pc_aggpage_search_result.none-task-blog-2~all~sobaiduweb~default-1-102248897&spm=3001.4430
         *   3) HeapByteBuffer和DirectByteBuffer都是包内可见的权限，不能直接new，需要使用接口或者父类才能调用其中的方法
         */
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        System.out.println("buffer.isDirect() = " + buffer.isDirect());
        ((DirectBuffer)buffer).cleaner().clear();  // DirectBuffer是个接口，需要用接口来实现clean的工作
    }

    public static void main(String[] args) {
        BufferTest bt = new BufferTest();
        bt.bufferApi();
        System.out.println();
        bt.bufferApi2();
    }
}
