package Communication;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetMessageBuffer implements MessageBufferInterface {

    String host;
    int port;

    public NetMessageBuffer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void sendMessage(String message) {

        try (Socket client = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());      //paziti na redosled otvaranja prikljucnica da se ne napravi deadlock
             ObjectInputStream in = new ObjectInputStream(client.getInputStream());) {

            out.writeUTF("send");

            out.writeObject(message);

            in.readObject();    //ACK

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMessage() {

        try (Socket client = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());      //paziti na redosled otvaranja prikljucnica da se ne napravi deadlock
             ObjectInputStream in = new ObjectInputStream(client.getInputStream());) {

            out.writeUTF("get");

            String ret = (String) in.readObject();  //ovde se pravi deadlock

            return ret;

        } catch (Exception e) {
            e.printStackTrace();

            System.err.println("Greska pri preuzimanju poruke!!!");

            return null;
        }
    }
}
