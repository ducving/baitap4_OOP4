package bt1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        int serverPort = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);

            Socket socket = serverSocket.accept();
            System.out.println("may khach da ket noi");

            InputStream ips = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = ips.read(buffer);
            int message = Integer.parseInt(new String(buffer, 0, bytesRead));
            System.out.println("so thu nhat : " + message);

            InputStream ips1 = socket.getInputStream();
            byte[] buffer1 = new byte[1023];
            int bytesRead1 = ips1.read(buffer1);
            int message1 = Integer.parseInt(new String(buffer1, 0, bytesRead1));
            System.out.println("so thu hai    : " + message1);




            int tong = message1 + message;

            OutputStream outputStream = socket.getOutputStream();
            String a=String.valueOf(tong);
            outputStream.write(a.getBytes());





            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
