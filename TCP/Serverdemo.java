package TCP;

/*
接收数据的步骤：
        创建服务器端的Socket对象(ServerSocket)
        监听客户端连接，返回一个Sockety对象
        获取输入流，读数据，并把数据显示在控制台
        释放资源
*/
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverdemo {
    public static void main(String[] args) throws IOException {
        // 创建服务器端的Socket对象（ServerScoket）
        // ServerSocket(int port)创建绑定到指定端口的服务器套接字
        ServerSocket ss = new ServerSocket(10010);

        // 监听客户端连接，返回一个Sockety对象
        Socket s = ss.accept();

        // 获取输入流，读数据，并把数据显示在控制台
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("数据是:" + data);

        // 释放资源
        ss.close();
        s.close();
    }
}
