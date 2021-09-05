package basic.io.bio.file;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ServerReaderThread extends Thread{
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("服务端开始保存!");
            // 1.创建1个数据输出流
            DataInputStream dos = new DataInputStream(socket.getInputStream());

            // 2.接收文件后缀
            String fileSuffix = dos.readUTF();

            // 3.创建文件
            String fileName = "D:\\workspace\\java\\TestFiles\\output\\" + UUID.randomUUID() + fileSuffix;
            FileOutputStream fos = new FileOutputStream(fileName);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = dos.read(buffer)) > 0) {
                fos.write(buffer, 0 , len);
            }
            dos.close();
            System.out.println("服务端保存成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
