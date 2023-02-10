import java.io.*;
import java.math.*;
import java.util.*;

class rsa
{
 private BigInteger p,q,n,d,e,phi;
 private int bitLength = 1024;
 Random rand;

 public rsa(){
  rand = new Random();
  p = BigInteger.probablePrime(bitLength, rand);
  q = BigInteger.probablePrime(bitLength, rand);
  n = p.multiply(q);
  phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
  e = BigInteger.probablePrime(bitLength/2, rand);
  while(phi.gcd(e).compareTo(BigInteger.ONE) >0 && e.compareTo(phi) <0)
  {
   e.add(BigInteger.ONE);
  }
  d = e.modInverse(phi);
 }

 public rsa(BigInteger e , BigInteger d , BigInteger n)
 {
  this.e = e;
  this.d = d;
  this.n = n;
 }

 public static void main(String[] args) throws IOException {
  rsa example = new rsa();
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  String text;
  System.out.println("Enter plain text");
  text = in.readLine();
  System.out.println("Encrypting string  : " + text);
  System.out.println("string in bytes : " + bytesToString(text.getBytes()));

  //encrypt
  byte[] encrypted = example.encrypt(text.getBytes());
  byte[] decrypted = example.decrypt(encrypted);
  System.out.println("decrypting in bytes "+ bytesToString(decrypted));
  System.out.println("decrypting string " + new String(decrypted));
 }

 private static String bytesToString(byte[] encrypted)
 {
  String test = "";
  for(byte b : encrypted)
  {
   test += Byte.toString(b);
  }
  return test;
 }

 public byte[] encrypt(byte[] message)
 {
  return (new BigInteger(message)).modPow(e, n).toByteArray();
 }

 public byte[] decrypt(byte[] message)
 {
  return (new BigInteger(message)).modPow(d, n).toByteArray();
 }

}