package th4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        int serverPort = 8081;

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);

            Socket socket = serverSocket.accept();
            System.out.println(" may khach da duoc ket noi ");
            Scanner sc = new Scanner(System.in);
            while (true) {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                byte[] buffer = new byte[1024];
                int bytesRead = dataInputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);

                System.out.println("Receive message from client: " + message);

                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                String messes = sc.nextLine();
                dataOutputStream.write(messes.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



