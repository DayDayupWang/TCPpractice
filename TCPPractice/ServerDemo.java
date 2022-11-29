package TCPPractice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端：接收数据，给出反馈
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 创建服务器Socket对象（ServerSocket）
        ServerSocket ss = new ServerSocket(10010);

        // 监听客户端连接，返回Socket对象
        Socket s = ss.accept();

        // 获取输入流，读数据，并把数据显示在控制台
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("服务器" + data);

        /*
         * int len;
         * while ((len = is.read(bys)) != -1) {
         * String data = new String(bys,0,len);
         * System.out.println("服务器"+data);
         * }
         */

        // 给出反馈
        OutputStream os = s.getOutputStream();
        os.write("over".getBytes());

        // 释放资源
        ss.close();
    }
}
