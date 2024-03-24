package edu.itstep.javaintro.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
    private static final int PORT_NUMBER = 10_000;

    public static void main(String... args) {

        try (var serverSocket = new ServerSocket(PORT_NUMBER)) {
            System.out.printf("%s %d %n", "Server was started on port", serverSocket.getLocalPort());
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String client = dis.readUTF();
            System.out.printf("%S %n",client);
            socket.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

}
