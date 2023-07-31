package bt1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverIp="127.0.0.1";
        int serverPort = 8080;
        try {

            Socket socket=new Socket(serverIp,serverPort);
            OutputStream outputStream=socket.getOutputStream();
            Scanner scanner=new Scanner(System.in);


            System.out.println("nhap so");
            int so;
            int a;
            so=scanner.nextInt();
            a=scanner.nextInt();
            System.out.println(so);
            System.out.println(a);



            String massager= String.valueOf(so);
            String massager1=String.valueOf(a);



            outputStream.write(massager.getBytes());
            outputStream.write(massager1.getBytes());

            InputStream inputStream=socket.getInputStream();
            byte[] buffer1 = new byte[1023];
            int bytesRead1 = inputStream.read(buffer1);
            int message2 = Integer.parseInt(new String(buffer1, 0, bytesRead1));
            System.out.println("tong cua 2 so la  :  " + message2);



            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
