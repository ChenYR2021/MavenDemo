package basic.io.bio.message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("===服务端启动===");
            // 1.定义1个服务端ServerSocket对象进行服务端的端口注册
            ServerSocket serverSocket = new ServerSocket(9999);
            HandlerSocketServerPool pool = new HandlerSocketServerPool(3, 6);

            int index = 0;
            while(true) {
                System.out.println("线程" + index + "正在等待中...");
                // 2.监听客户端的Socket链接请求
                Socket socket = serverSocket.accept();
                System.out.println("线程" + index + "监听成功，正在启动中...");

                // 3.利用线程池来执行Runnable类
                pool.execute(new ServiceThreadReader(socket));
                System.out.println("线程" + index + "启动完成!!!");
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("===服务端关闭，读取结束===");
    }
}
