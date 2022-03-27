package Communication;

import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageBuffer implements MessageBufferInterface {

    ConcurrentLinkedQueue<String> buffer = new ConcurrentLinkedQueue<>();

    @Override
    public synchronized void sendMessage(String message) {

        buffer.add(message);

        notifyAll();

        System.out.println("Dodaje se u bafer");
    }

    @Override
    public synchronized String getMessage() {

        while (0 == buffer.size()) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        notifyAll();

        System.out.println("Uzima se iz bafera");
        String s = buffer.remove();

        return s;
    }
}
