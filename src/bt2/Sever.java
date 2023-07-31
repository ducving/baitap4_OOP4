package bt2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {

    public static void main(String[] args) {
        int serverPort = 8081;


        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            Socket socket = serverSocket.accept();
            System.out.println(" may khach da ket noi");


            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("dia chi ip nhan duoc la : " + message);



            OutputStream outputStream=socket.getOutputStream();
            if (isValidIPAddress(message)) {
                outputStream.write("dia chi ip hop le".getBytes());
            } else {
                outputStream.write("dia chi ip ko hop le".getBytes());
            }





        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
    public static boolean isValidIPAddress(String ipAddress) {
        String[] ipParts = ipAddress.split("\\.");

        if (ipParts.length != 4) {
            return false;
        }

        for (String part : ipParts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }
}
