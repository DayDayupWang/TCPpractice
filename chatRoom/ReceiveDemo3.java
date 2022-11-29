package chatRoom;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo3 {
    public static void main(String[] args) throws IOException {
        // 创建接收端的Scoket对象（DatagramScoket）
        DatagramSocket ds = new DatagramSocket(10010);

        while (true) {
            // 创建数据包用于接收数据
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);

            // 调用DatagramScoket对象的方法接收数据
            ds.receive(dp);

            // 解析数据包，并把数据输出在控制台
            System.out.println("数据是:" + new String(dp.getData(), 0, dp.getLength()));
        }

        // 关闭接收端操作，接收端在上面死循环接收数据时不必关闭
        // ds.close();
    }
}
