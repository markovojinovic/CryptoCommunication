package Communication;

import java.util.Scanner;

public class ClientSend extends Thread{

    private MessageBufferInterface buffer;

    public ClientSend(MessageBufferInterface buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {

            String item = read();

            buffer.sendMessage(item);
        }
    }

    private String read() {

        Scanner myObj = new Scanner(System.in);

        return myObj.nextLine();

    }
}
