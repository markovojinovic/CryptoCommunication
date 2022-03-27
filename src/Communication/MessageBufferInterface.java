package Communication;

import java.io.Serializable;

public interface MessageBufferInterface extends Serializable {

    public void sendMessage(String message);

    public String getMessage();

}
