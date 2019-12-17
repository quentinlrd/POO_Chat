import java.net.*;
import java.util.Enumeration; 

public class Connexion {
	
	
	
	
	public InetAddress getBroadcast() throws SocketException {
	
		try{
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
		
			
				}
		catch(UnknownHostException e) 
		{System.out.println("Could not find local address!");}
		
		
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while (interfaces.hasMoreElements()) 
		{
		    NetworkInterface networkInterface = interfaces.nextElement();
		    if (networkInterface.isLoopback())
		        continue;    // Do not want to use the loopback interface.
		    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) 
		    {
		        InetAddress broadcast = interfaceAddress.getBroadcast();
		        if (broadcast == null)
		            continue;
		        
		        System.out.println("l'adresse de broadcast est "+ broadcast) ; 
		        //
		        return broadcast ;  
		    }
		}
		return null;
			   
	 }
			
		
	}

/*UDPClient client = new UDPClient();
			    IPEndPoint ip = new IPEndPoint(IPAddress.Broadcast, 15000);
			    byte[] bytes = Encoding.ASCII.GetBytes("Foo");
			    client.Send(bytes, bytes.Length, ip);
			    client.Close();
			    */


