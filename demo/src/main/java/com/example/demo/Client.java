package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    @FXML
    private TextField textClient;

    @FXML
    private Label a;

    @FXML
    private void onButtonClick(){
        String serverIp = "127.0.0.1";
        int serverPort = 8081;

        try {
            Socket socket = new Socket(serverIp, serverPort);
//            while (true) {
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                String messes=textClient.getText();
                dataOutputStream.write(messes.getBytes());


                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                byte[] buffer = new byte[1024];
                int bytesRead = dataInputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println(message);
//            }
        } catch (IOException e){
            e.printStackTrace();
        }

        }
    }

