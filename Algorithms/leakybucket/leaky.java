import java.lang.*;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

class leaky {
 public static void main(String[] Args) {
  int drop = 0, mini, p_remain = 0, b_size, o_Rate, nsec;
  int[] packet = new int[100];

  Scanner sc = new Scanner(System.in);
  System.out.println("Enter seconds");
  nsec = sc.nextInt();

  System.out.println("Enter bucket size");
  b_size = sc.nextInt();

  System.out.println("Enter rate");
  o_Rate = sc.nextInt();

  Random rand = new Random();
  for (int i = 0; i < nsec; i++) {
   packet[i] = ((rand.nextInt(9) + 1) * 10);
  }

  for (int i = 0; i < nsec; i++) {
   p_remain += packet[i];
   if (p_remain > b_size) {
    drop = p_remain - b_size;
    p_remain = b_size;
    System.out.print(i + " ");
    System.out.print(packet[i] + " ");
    mini = Math.min(p_remain, o_Rate);
    System.out.print(mini + " ");
    p_remain = p_remain - mini;
    System.out.print(p_remain + " ");
    System.out.print(drop + " ");
    System.out.println();
    drop = 0;

   }
  }

 }
}
