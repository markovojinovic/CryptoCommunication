package Communication;

public class ClientRacive extends Thread{

    private MessageBufferInterface buff;

    public ClientRacive(MessageBufferInterface buff) {
        this.buff = buff;
    }

    @Override
    public void run() {
        while (true) {

            System.out.println(buff.getMessage());

        }
    }

}
