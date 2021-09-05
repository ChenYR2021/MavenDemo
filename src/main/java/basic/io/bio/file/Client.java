package basic.io.bio.file;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("D:\\workspace\\java\\TestFiles\\image1.jpg");) {
            // 1.创建1个客户端链接
            Socket socket = new Socket("127.0.0.1", 9999);

            // 2.创建一个数据输出流
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // 3.将文件前缀发给服务端
            dataOutputStream.writeUTF(".jpg");

            // 4.将数据发送给服务端
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                dataOutputStream.write(buffer, 0 , length);
            }
            dataOutputStream.flush();
            // 5.客户端通知服务端发送完毕
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
