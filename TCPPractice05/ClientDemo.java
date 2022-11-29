package TCPPractice05;

import java.io.*;
// import java.net.InetAddress;
import java.net.Socket;

//- 客户端：数据来自于文本文件，接收服务器反馈

public class ClientDemo {
    public static void main(String[] args) throws Exception {
        // 创建客户端Socket对象，准备发送
        Socket s = new Socket("192.168.31.81", 10010);

        // 创建输入流
        BufferedReader br = new BufferedReader(new FileReader("myInet\\java.txt"));
        // 创建输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // void shutdownOutput()禁用此套接字的输出流
        // 表示输出结束
        s.shutdownOutput();

        // 创建输入流接收服务器反馈
        InputStream inputStream = s.getInputStream();
        byte[] bys = new byte[1024];
        int len;
        while ((len = inputStream.read(bys)) != -1) {
            System.out.println(new String(bys, 0, len));
        }
        // 释放资源
        s.close();
        br.close();
    }
}
