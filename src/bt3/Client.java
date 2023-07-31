package bt3;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverIp="127.0.0.1";
        int serverPort=8081;

        try {
            Socket socket=new Socket(serverIp,serverPort);
            OutputStream outputStream=socket.getOutputStream();
            DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
            String ib="xin chao toi la trong hay an cut";
            dataOutputStream.write(ib.getBytes());


            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
