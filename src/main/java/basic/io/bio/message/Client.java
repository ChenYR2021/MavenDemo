package basic.io.bio.message;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // 1.创建Socket对象，请求服务端链接
            Socket socket = new Socket("127.0.0.1", 9999);

            // 2.从Socket对象中获取1个字节输出流
            OutputStream os = socket.getOutputStream();

            // 3.把字节输出流包装成打印流
            PrintStream ps = new PrintStream(os);

            Scanner sc = new Scanner(System.in);
            String msg = "";
            while (true) {
                System.out.print("请输入：");
                msg = sc.nextLine();
                ps.println(msg);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
