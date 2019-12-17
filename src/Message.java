import java.time.* ;
import java.io.Serializable;
import java.net.*;


public class Message implements Serializable {

	
	String text;
	int idsrc ;
	int iddest ;
	LocalTime time ;
	
	
	
	//constructor
	Message(String msg, int src, int dest) {
		this.text = msg ;
		this.idsrc = src ;
		this.iddest = dest ;
		this.time = LocalTime.now();
	}
	
	
	
	//getters
	public int getIddest() {
		return iddest;
	}
	public String getText() {
		return text;
	}
	public int getIdsrc() {
		return idsrc;
	}
	public LocalTime getLocalTime() {
		return time ; 
	}

	
	
	
}
