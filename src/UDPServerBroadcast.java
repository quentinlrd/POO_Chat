import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServerBroadcast extends Thread {
    
    
    private DatagramSocket socketbroadcast;
    private boolean running;
    private byte[] buf = new byte[256];
    private int portbroadcast = 2045 ;
     
 
    public UDPServerBroadcast() {
        
        try{
        socketbroadcast = new DatagramSocket(portbroadcast);
      
        
        }catch (SocketException e){System.out.println(socketbroadcast.getLocalPort()); };
        }
        
        
 
    public void run() {
        System.out.printf("Run thread Server \n \n"); 
        running = true;
 
        while (running) {
        	 try
             {
               byte[] recvBuf = new byte[5000];
               DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
               
               socketbroadcast.receive(packet);
               
               
               //int byteCount = packet.getLength();
               ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
               ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
               MessageConnexion o = (MessageConnexion) is.readObject();
               //MessageConnexion mo = (MessageConnexion) is.readObject();
               is.close();
            
          
           // if (o.getText().equals("end")) {
            //    running = false;
            //    continue;
           // }
               
             }
             catch (IOException e)
             {
               System.err.println("Exception:  " + e);
               e.printStackTrace();
             }
             catch (ClassNotFoundException e)
             { e.printStackTrace(); }
              }
         
        socket.close();
    
        }
}