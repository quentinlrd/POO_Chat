import java.net.*;
import java.io.Serializable;
import java.io.*;

public class UDPClient implements Serializable {
 
    private DatagramSocket socket;
    private InetAddress address;
    private int destport ;
 
    private byte[] buf;
 
    public UDPClient() {
        try{
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
        destport = 2030;
        // for broadcast, use the following line :
        //adress = InetAdress.getByName("255.255.255.255") ;
        }catch(Exception e){};
        }
 
    public String sendEcho(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet 
          = new DatagramPacket(msg.getBytes(), msg.length(), address, destport);
        
         
        try {
            socket.send(packet);
        } catch (IOException Error){};
        packet = new DatagramPacket(buf, buf.length);
         
         try{
        socket.receive(packet);
        } catch (IOException Error){};
       
        String received = new String(
          packet.getData(), 0, packet.getLength());
        return received;
        
 
    }
      
    public void close() {
        socket.close();
    }
    

    public void sendMessage(Message message) {
    	try { 
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
        ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(byteStream));
        os.flush();
        os.writeObject(message);
        os.flush();
        byte[] sendBuf = byteStream.toByteArray();
        DatagramPacket packet = new DatagramPacket(
                            sendBuf, sendBuf.length, address, destport);
        int byteCount = packet.getLength();
        socket.send(packet);
        os.close();}
    	
        catch (UnknownHostException e)
        {
          System.err.println("Exception:  " + e);
          e.printStackTrace();    }
        catch (IOException e)    { e.printStackTrace();
        }
        }
    
    
    public void sendMessageBroadcast(Message message,InetAddress adbroadcast) {
    	try { 
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
        ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(byteStream));
        os.flush();
        os.writeObject(message);
        os.flush();
        byte[] sendBuf = byteStream.toByteArray();
        DatagramPacket packet = new DatagramPacket(
                            sendBuf, sendBuf.length, adbroadcast, destport);
        int byteCount = packet.getLength();
        socket.send(packet);
        os.close();}
    	
        catch (UnknownHostException e)
        {
          System.err.println("Exception:  " + e);
          e.printStackTrace();    }
        catch (IOException e)    { e.printStackTrace();
        }
        }



    
   
    
    
   
    
    
}