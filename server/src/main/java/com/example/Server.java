package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 3000;

    public static void main(String[] args) {
        System.out.println("Server di calcolo avviato sulla porta " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuovo client connesso da: " + clientSocket.getInetAddress());

                ClientHandler handler = new ClientHandler(clientSocket);
                
                Thread thread = new Thread(handler);
                thread.start();
            }
            
        } catch (IOException e) {
            System.out.println("Errore nell'avvio del server: " + e.getMessage());
        }
    }
}
