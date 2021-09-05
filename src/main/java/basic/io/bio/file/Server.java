package basic.io.bio.file;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // 1.创建服务端Socket链接
            ServerSocket serverSocket = new ServerSocket(9999);

            while(true) {
                // 2.监听客户端消息
                Socket socket = serverSocket.accept();
                // 3.创建线程并且启动
                ServerReaderThread srt = new ServerReaderThread(socket);
                srt.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
