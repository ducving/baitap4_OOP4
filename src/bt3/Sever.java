package bt3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static void main(String[] args) {
        int serverPort=8080;

        try {
            ServerSocket serverSocket=new ServerSocket(serverPort);
            Socket socket=serverSocket.accept();
            System.out.println(" may khach da ket noi");

            InputStream inputStream=socket.getInputStream();
            DataInputStream dataInputStream=new DataInputStream(inputStream);
            byte[]buffer=new byte[2000];
            int bytesRead= dataInputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);

            System.out.println(message);








        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
