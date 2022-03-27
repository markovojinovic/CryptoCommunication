package Communication;

public class ClientRaciveMain {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 4001;

        MessageBufferInterface buffer = new NetMessageBuffer(host, port);

        ClientRacive cl = new ClientRacive(buffer);

        cl.start();

        try {
            cl.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
