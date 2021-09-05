package basic.io.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.channels.Channel;

/**
 * 测试Channel的各种API
 */
public class ChannelTest {

    public static void main(String[] args) {

    }

    /**
     * 1.测试从1个Channel直接将数据传递到另1个Channel
     *
     * API：
     *   1) transferTo (src -> des)
     *   2) transferFrom (des -> src)
     */
    public void DirectTransfer() {
        try {
            // 1.定义InputStream，从InputStream中拿到channel
            FileInputStream fiStream = new FileInputStream("D:\\workspace\\java\\TestFiles\\image1.jpg");
            Channel channel = fiStream.getChannel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
