import java.io.*;
import java.net.*;

class client {
 public static void main(String[] Args) {
  try {
   Socket sock = new Socket("127.0.0.1", 4000);
   System.out.println("Enter file name");
   BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
   String fname = keyRead.readLine();

   OutputStream ostream = sock.getOutputStream();
   PrintWriter pwrite = new PrintWriter(ostream, true);
   pwrite.println(fname);

   InputStream iStream = sock.getInputStream();
   BufferedReader socketRead = new BufferedReader(new InputStreamReader(iStream));

   String str;
   while ((str = socketRead.readLine()) != null) {
    System.out.print(str);
   }
   pwrite.close();
   socketRead.close();
   keyRead.close();

  } catch (Exception e) {
   System.out.println("error");
  }
 }
}