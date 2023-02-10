
import java.io.*;
import java.net.*;

class client{
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  DatagramSocket socket = new DatagramSocket();
  InetAddress IPAddress = InetAddress.getByName("localhost");
  byte recieveData[] = new byte[1024];
  byte sendData[] = new byte[1024];

  // send message to server
  System.out.println("Enter message");
  String message = br.readLine();
  sendData = message.getBytes();
  DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress , 4000);
  socket.send(sendPacket);

  DatagramPacket recievePacket = new DatagramPacket(recieveData, recieveData.length);
  socket.receive(recievePacket);
  String rMessage = new String(recievePacket.getData());
  System.out.println("Response froms server is : " + rMessage);
  socket.close();
  
 }
}