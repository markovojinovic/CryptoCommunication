package Communication;

public class ClientSendMain {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 4001;

        MessageBufferInterface buffer = new NetMessageBuffer(host, port);

        ClientSend cl = new ClientSend(buffer);

        cl.start();

        try {
            cl.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
