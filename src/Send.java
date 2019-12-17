
import java.net.*;

public class Send {
    UDPClient client;
 
    //Before
    public void setup(){
        new UDPServer().start();
        client = new UDPClient();
    }
    
    
    //Test
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String echo = client.sendEcho("hello server");
        echo = client.sendEcho("server is working");
        
    }
 
    //After
    public void tearDown() {
        client.sendEcho("end");
        client.close();
    }
}
