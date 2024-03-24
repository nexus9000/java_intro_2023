package edu.itstep.javaintro.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample {
    public static void main(String... arg) throws IOException {
        Socket socket = new Socket("192.168.88.239", 10_000);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("write something to server");
        Scanner scanner = new Scanner(System.in);
        String toServer = scanner.nextLine();
        dataOutputStream.writeUTF(toServer);
        dataOutputStream.flush();
        socket.close();
    }
}
