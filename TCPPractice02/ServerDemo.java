package TCPPractice02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//服务器：接收到的数据在控制台输出
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 创建服务器端Socket对象
        ServerSocket ss = new ServerSocket(10010);

        // 监听客户端连接，返回对应的Socket对象
        Socket s = ss.accept();

        // 获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            String data = new String(line);
            System.out.println("服务器：" + data);
        }
        // 释放资源
        ss.close();
    }
}
