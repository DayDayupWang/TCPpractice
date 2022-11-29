package TCPPractice06;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        // 接收数据写到文本文件
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            // 解决命名冲突问题
            int count = 0;
            File file = new File("myInet\\copy" + count + ".txt");
            while (file.exists()) {
                count++;
                file = new File("myInet\\copy" + count + ".txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            // 给出反馈
            OutputStream outputStream = s.getOutputStream();
            outputStream.write("服务器已成功接收数据".getBytes());
            // 释放资源
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
