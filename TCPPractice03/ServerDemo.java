package TCPPractice03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 创建服务器socket对象
        ServerSocket ss = new ServerSocket(10000);
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("s.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            if ("886".equals(line)) {
                break;

            }

            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        ss.close();

    }
}
