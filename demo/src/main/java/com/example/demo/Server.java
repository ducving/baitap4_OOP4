package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    @FXML
    private TextField textSever;


    @FXML
    protected void onButtonClick() {
        int serverPort = 8081;

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);

            Socket socket = serverSocket.accept();

            while (true) {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                byte[] buffer = new byte[1024];
                int bytesRead = dataInputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println(message);




                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                String messes=textSever.getText();
                dataOutputStream.write(messes.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}