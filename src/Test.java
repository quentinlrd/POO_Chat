import java.net.SocketException;

public class Test {
    UDPClient client;
    UDPServer server ; 
    Connexion testCo ; 
    MessageConnexion testmsgco ; 
 
    //Before

    public void testmessageco() throws SocketException {
       try {
      testmsgco =  new MessageConnexion(true,11);
      System.out.println(testmsgco.getLocalIP()); 
       }
       catch (Exception UnknownHostException){}
    }
    public void setup() {
       new UDPServer().start();
       client = new UDPClient();
       testCo = new Connexion() ; 
    }
 
    //Test
    public void whenCanSendAndReceivePacket_thenCorrect() throws SocketException {
    	Message msg = new Message ("SALUT MON AIGLON", 1, 2);
    	client.sendMessageBroadcast(msg,testCo.getBroadcast());
    	Message aiglon = new Message ("end", 4,5);
    	client.sendMessageBroadcast(aiglon,testCo.getBroadcast());
    /*	Message msg1 = new Message ("test", 4,5);
    	client.sendMessage(msg1);*/
    	
    }
    
 
    //After
    public void tearDown() {
       client.sendEcho("end");
       client.close();
    }
}
