package basic.io.bio.message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerSocketServerPool {
    // 1.创建1个线程池的变量用于存储线程池
    private ExecutorService executorService;

    // 2.创建对象时初始化线程池
    public HandlerSocketServerPool(int maxThreadNum, int queueSize) {
        executorService = new ThreadPoolExecutor(3, maxThreadNum,
                1000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));

    }

    // 3.提供1个方法来提交任务给线程池的任务队列来暂存，等着线程池来处理
    public void execute(Runnable target) {
        executorService.execute(target);
    }

}
