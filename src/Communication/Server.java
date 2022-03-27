package Communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int port = 4001;

        MessageBufferInterface buffer = new MessageBuffer();

        try (ServerSocket serverSocket = new ServerSocket(port);) {

            while (true) {
                Socket client = serverSocket.accept();
                new ServerThread(client, buffer).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
