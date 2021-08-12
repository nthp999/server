import java.io.*;
import java.net.*;

class server1
{
  public static void main(String[] args) {
    String clientMsg;
    String serverMsg;

    ServerSocket serSocket;
    Socket s;

    DataInputStream streamFromClient;
    DataOutputStream streamToClient;

    System.out.print("Sever is running at 5555" + '\n');

    try
    {
      while (true)
      {
        serSocket = new ServerSocket (5555);
        System.out.println("Server is waiting connection..." + '\n');

        s = serSocket.accept();
        System.out.println("connection from " + s + '\n');

        //doc luong du lieu di vao
        streamFromClient = new DataInputStream(s.getInputStream());
        clientMsg = streamFromClient.readUTF();

        System.out.println("Client msg: " + clientMsg + '\n');

        //chinh sua noi dung
        serverMsg = "From server: " + clientMsg.toUpperCase() + '\n';

        //mo luong du lieu di ra
        streamToClient = new DataOutputStream(s.getOutputStream());
        streamToClient.writeUTF(serverMsg);

        System.out.println("Sent" + '\n');
        
        streamToClient.flush();
        streamToClient.close();
        
        streamFromClient.close();
        
        s.close();
        serSocket.close();
      }
    }
    catch (UnknownHostException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (IOException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }
}
