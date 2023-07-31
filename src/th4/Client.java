package th4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {
        public static void main(String[] args) {
            String serverIp = "127.0.0.1";
            int serverPort = 8081;

            try {
                Socket socket = new Socket(serverIp, serverPort);


                Scanner sc = new Scanner(System.in);
                while (true) {
                    OutputStream outputStream = socket.getOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                    String messsage = sc.nextLine();
                    dataOutputStream.write(messsage.getBytes());


                    InputStream inputStream = socket.getInputStream();
                    DataInputStream dataInputStream = new DataInputStream(inputStream);
                    byte[] buffer = new byte[1024];
                    int bytesRead = dataInputStream.read(buffer);
                    String message = new String(buffer, 0, bytesRead);
                    System.out.println(message);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }




