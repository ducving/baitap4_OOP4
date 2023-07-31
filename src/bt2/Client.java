package bt2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String severIP="127.0.0.1";
        int serverPort=8081;

        try {
            Socket socket=new Socket(severIP,serverPort);
            OutputStream outputStream=socket.getOutputStream();
            Scanner sc=new Scanner(System.in);

            System.out.println("nhap dia chi IP");
            String ip;
            ip=sc.nextLine();
            System.out.println(ip);


            String massager=String.valueOf(ip);
            outputStream.write(massager.getBytes());


            InputStream inputStream=socket.getInputStream();
            byte[] buffer1 = new byte[1023];
            int bytesRead1 = inputStream.read(buffer1);
            String message2 = new String(buffer1, 0, bytesRead1);
            System.out.println("ip  :  " + message2);

            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
