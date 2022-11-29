package chatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo3 {
    public static void main(String[] args) throws IOException {
        // 创建发送端的Scoket对象（DatagramScoket());
        DatagramSocket ds = new DatagramSocket();

        // 自己封装键盘录入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            // 输入的数据为886，发送数据结束
            if ("886".equals(line)) {
                break;
            }
            // 创建数据并把数据打包
            byte[] bys = line.getBytes();
            DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("192.168.31.81"), 10010);

            // 调用DagramScoket对象的方法发送数据
            ds.send(dp);

        }
        // 关闭发送端
        ds.close();
    }
}
