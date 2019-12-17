import java.net.*;
import java.io.*;
 
public class Transfert implements java.io.Serializable 


{
    public void Serializer(Socket Csoc, Message msg) 
    {
        try 
        {
            ObjectOutputStream oos = new ObjectOutputStream(Csoc.getOutputStream());
            oos.writeObject(msg);
        }
        catch (java.io.IOException e) 
            {e.printStackTrace();}
    }
 
    public Message Deserializer(Socket Csoc, Message m)
    {
        Message message = new Message("",1,2);
        try 
        {
            ObjectInputStream ois = new ObjectInputStream(Csoc.getInputStream());
            message = (Message) ois.readObject();          
        } 
        catch (java.io.IOException e) 
            {e.printStackTrace();}
        catch (ClassNotFoundException e) 
            {e.printStackTrace();}
        return message;  
 
    }
}