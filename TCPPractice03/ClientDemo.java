package TCPPractice03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//客户端：数据来自于键盘录入，直到输入的数据是886，发送数据结束
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket s = new Socket(InetAddress.getByName("192.168.31.81"), 10010);

        // 数据来自键盘录入，输入886，发送结束
        BufferedReader be = new BufferedReader(new InputStreamReader(System.in));
        // 封装输出数据流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = be.readLine()) != null) {
            if ("886".equals(line)) {
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // 释放资源
        s.close();
    }
}
