import java.time.* ;
import java.util.Enumeration;
import java.net.*;
import java.io.Serializable;



public class MessageConnexion implements Serializable {
    
    boolean connected;
    InetAddress localIP;
    int myID ; 

    MessageConnexion(boolean connected , int myID ) throws SocketException,UnknownHostException{
        this.connected = connected ;
        this.localIP = this.getCurrentIp() ; 
        this.myID = myID ; 
    }
    
    public InetAddress getCurrentIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) networkInterfaces
                        .nextElement();
                Enumeration<InetAddress> nias = ni.getInetAddresses();
                while(nias.hasMoreElements()) {
                    InetAddress ia= (InetAddress) nias.nextElement();
                    if (!ia.isLinkLocalAddress() 
                     && !ia.isLoopbackAddress()
                     && ia instanceof Inet4Address) {
                    	System.out.println("l'adresse de broadcast est "+ ia) ;
                        return ia;
                        
                    }
                }
            }
        } catch (SocketException e) {
           // LOG.error("unable to get current IP " + e.getMessage(), e);
        }
        return null;
    }
	
	
    
    
    

public boolean getConnected() {
		return connected;
	}


public int getID() {
		return myID;
	}
public InetAddress getLocalIP() {
	return localIP;
	}
}
