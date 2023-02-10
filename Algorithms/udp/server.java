
import java.net.*;
import java.io.*;

class server
{
 public static void main(String[] args) throws IOException {

  DatagramSocket socket = new DatagramSocket(4000);
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  byte[] recieveData = new byte[1024];
  byte[] sendData = new byte[1024];
  
  //recieveing message from client
  DatagramPacket recievePacket = new DatagramPacket(recieveData, recieveData.length); 
  socket.receive(recievePacket);
  String message = new String(recievePacket.getData());
  System.out.println("RECIEVED FROM CLIENT : " + message );
  InetAddress IPAdress = recievePacket.getAddress();
  int port = recievePacket.getPort();

  // sending message from server to client
  System.out.println("Enter your message");
  String cMessage = br.readLine();
  sendData = cMessage.getBytes();
  DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length ,IPAdress,port );
  socket.send(sendPacket);
  
  socket.close();
 }
}
