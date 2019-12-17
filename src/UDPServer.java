import java.net.*;
import java.io.*;


public class UDPServer extends Thread {
    
    private DatagramSocket socket;
    private DatagramSocket socketbroadcast;
    private boolean running;
    private byte[] buf = new byte[256];
    private int port = 2030 ;
     
 
    public UDPServer() {
        
        try{
        socket = new DatagramSocket(port);
      
        
        }catch (SocketException e){System.out.println(socket.getLocalPort()); };
        }
        
        
 
    public void run() {
        System.out.printf("Run thread Server \n \n"); 
        running = true;
 
        while (running) {
        	 try
             {
               byte[] recvBuf = new byte[5000];
               DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
               
               socket.receive(packet);
               
               
               //int byteCount = packet.getLength();
               ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
               ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
               Message o = (Message) is.readObject();
               //MessageConnexion mo = (MessageConnexion) is.readObject();
               is.close();
               System.out.println("Message reçu : ");
               System.out.println("+++++++++ Text : ");
               System.out.println(o.getText());
               System.out.println("+++++++++ de : ");
           		System.out.println(o.getIdsrc());
           		System.out.println("+++++++++ à : ");
           		System.out.println(o.getIddest());
           		System.out.println("+++++++++ time : ");
           		System.out.println(o.getLocalTime());
          
            if (o.getText().equals("end")) {
                running = false;
                continue;
            }
               
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
    
    
    

     public Message receiveMessage()  
    {    try
        {
          byte[] recvBuf = new byte[5000];
          DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
          
          socket.receive(packet);
          
          //int byteCount = packet.getLength();
          ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
          ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
          Message o = (Message) is.readObject();
          is.close();
          return(o);
        }
        catch (IOException e)
        {
          System.err.println("Exception:  " + e);
          e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        { e.printStackTrace(); }
        return(null);  }
    }
    
    


