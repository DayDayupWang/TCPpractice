package TCPPractice06;

import java.net.ServerSocket;
import java.net.Socket;

//- 服务器：接收到的数据写入文本文件，给出反馈，代码用线程进行封装，为每一个客户端开启一个线程
public class ServerDemo {
    public static void main(String[] args) throws Exception {
        // 创建服务器Socket对象
        // 一般来说服务器不关闭
        ServerSocket ss = new ServerSocket(10010);

        while (true) {
            // 监听客户端连接，返回socket对象
            Socket s = ss.accept();
            // 为每一个客户端开启一个线程
            new Thread(new ServerThread(s)).start();
        }
    }
}
