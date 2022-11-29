package TCPPractice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//客户端：发送数据，接收服务器反馈
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket ss = new Socket("192.168.31.81", 10010);

        // 获取输出流，写数据
        OutputStream os = ss.getOutputStream();
        os.write("hello,java".getBytes());

        // 接收服务器反馈
        InputStream is = ss.getInputStream();
        byte[] bys = new byte[1024];
        int len;
        while ((len = is.read(bys)) != -1) {
            System.out.println("客户端：" + new String(bys, 0, len));
        }

        // 释放资源
        ss.close();
    }
}
