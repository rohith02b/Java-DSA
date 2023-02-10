import java.lang.*;
import java.util.Scanner;
import java.io.*;

class QueueOps {
   int queue[];
   int front, rear;
   int size;
   Scanner sc = new Scanner(System.in);

   public QueueOps(int n) {
      size = n;
      queue = new int[size];
      rear = -1;
      front = 0;
   }

   public void enQueue() {
      if (rear == size - 1) {
         System.out.println("Queue overflow");
      } else {
         int element = sc.nextInt();
         queue[++rear] = element;
      }
   }

   public void deQueue() {
      if (front > rear) {
         System.out.println("No elements to delete");
         front = -1;
      }
      System.out.println("Dequeue'd element : " + queue[front]);
      front++;
   }

   public void display() {
      if (front > rear) {
         System.out.println("Queue empty");
      } else {
         for (int i = front; i < rear; i++) {
            System.out.println(queue[i] + " ");
         }
      }
   }
}

class Queue {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.println("Welcome to Queue Operations");
      System.out.println("Enter the size of the Queue");
      int n = in.nextInt();
      QueueOps arr = new QueueOps(n);
      do {
         int option;
         System.out.println("Enter the option");
         System.out.println("1.enQueue\t2deQueue\t3.Display\t4.Exit");
         option = in.nextInt();
         System.out.println();

         switch (option) {
            case 1:
               arr.enQueue();
               System.out.println();
               break;

            case 2:
               arr.deQueue();
               System.out.println();
               break;

            case 3:
               arr.display();
               System.out.println();
               break;

            case 4:
               System.exit(0);

            default:
               System.out.println("Wrong option");

         }
      } while (true);
   }
}