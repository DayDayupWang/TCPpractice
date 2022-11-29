package TCPPractice04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端：数据来自文本文件
public class ClientDemo {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // 创建客户端socket对象
        Socket s = new Socket("192.168.127.86", 10000);
        // 封装文本文件的数据
        BufferedReader br = new BufferedReader(new FileReader("D:\\a.txt"));
        // 封装输出流写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // 释放资源
        br.close();
        s.close();
    }
}
