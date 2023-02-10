import java.io.*;

class crc
{

 static int[] divide(int[] divisor,int[] rem)
 {
  int cur=0;
  while(true)
  {
   for(int i=0;i<divisor.length;i++)
    rem[cur+i] = (rem[cur+i] ^ divisor[i]);

   while(rem[cur] == 0 && cur != rem.length-1)
    cur++;

   if(rem.length-cur<divisor.length)
    break;

  }
   return rem;
 }

 public static void main(String[] args) throws IOException {
  // int[] div,r,rem,crc;
  int data_bits,divisor_bits,tot_length;

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Enter number of data bits");
  data_bits = Integer.parseInt(br.readLine());

  int data[] = new int[data_bits];
  System.out.println("Enter data");
  for(int i =0;i<data_bits;i++)
  {
   data[i] = Integer.parseInt(br.readLine());
  }

  divisor_bits = 17;
  int[] divisor = new int[] {1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};

  tot_length = data_bits + divisor_bits -1;

  int[] rem = new int[tot_length];
  int[] crc = new int[tot_length];
  int[] div = new int[tot_length];

  //crc generation
  for(int i=0;i<data.length;i++)
  {
   div[i] = data[i];
  }
  
  System.out.println("The divident after appending 0's : ");
  for(int i=0;i<div.length;i++)
  {
  System.out.print(div[i] + " ");
  }
  
  for(int j=0;j<div.length;j++)
  {
   rem[j] = div[j];
  }
  
  rem = divide(divisor,rem);

  for(int i=0;i<div.length;i++)
  {
   crc[i] = (div[i] ^ rem[i]);
  }

  System.out.println();
  System.out.println("The crc code is ");
  for(int i=0;i<crc.length;i++)
  {
  System.out.print(crc[i] + " ");
  }


 }
}