import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

class server {
 public static void main(String[] Args) {
  try {
   ServerSocket sersock = new ServerSocket(4000);
   Socket sock = sersock.accept();
   InputStream iStream = sock.getInputStream();
   BufferedReader fileRead = new BufferedReader(new InputStreamReader(iStream));
   String fname = fileRead.readLine();
   BufferedReader contentRead = new BufferedReader(new FileReader(fname));

   OutputStream ostream = sock.getOutputStream();
   PrintWriter pwrite = new PrintWriter(ostream, true);

   String str;
   while ((str = contentRead.readLine()) != null) {
    pwrite.println(str);
   }
   sock.close();
   sersock.close();
   pwrite.close();
   fileRead.close();
   contentRead.close();
  } catch (Exception e) {
   System.out.println(e);
  }
 }
}