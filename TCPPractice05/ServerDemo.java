package TCPPractice05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//- 服务器：接收到的数据写入文本文件，给出反馈
public class ServerDemo {
    public static void main(String[] args) throws Exception{
        //创建服务端Socket对象
        ServerSocket ss = new ServerSocket(10010);

        //监听客户端，返回Socket对象
        Socket s = ss.accept();

        //创建输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //创建输出流
        BufferedWriter bw= new BufferedWriter(new FileWriter("myInet\\copy.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        System.out.println(11111);

        //创建输出流输出反馈数据
        OutputStream outputStream = s.getOutputStream();
        outputStream.write("数据已接收".getBytes());

        //释放资源
        ss.close();
        bw.close();
    }
}
