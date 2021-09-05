package basic.io.bio.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServiceThreadReader extends Thread{

    private Socket socket;

    public ServiceThreadReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 将字节输入流转成 “缓冲字符输入流”
            //   1) 转成字符输入流
            //   2) 转成缓冲字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = "";
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println(this + " get a message: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
