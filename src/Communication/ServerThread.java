package Communication;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

    Socket client;
    MessageBufferInterface buffer;

    public ServerThread(Socket client, MessageBufferInterface buffer) {
        this.client = client;
        this.buffer = buffer;
    }

    @Override
    public void run() {

        try (Socket socket = client;
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {

            String operation = in.readUTF();

            if ("send".equalsIgnoreCase(operation)) {

                String ret = (String) in.readObject();

                buffer.sendMessage(ret);

                out.writeObject("ACK");

                System.out.println("Poslato je: " + ret);

            } else if ("get".equalsIgnoreCase(operation)) { //ovde se pravi deadlock

                String s = buffer.getMessage();
                out.writeObject(s);

                System.out.println("Cita se poruka");

            } else {
                System.err.println(String.format("***Operacija %s nije podrzana.***", operation));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
