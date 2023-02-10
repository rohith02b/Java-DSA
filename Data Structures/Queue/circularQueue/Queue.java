import java.lang.*;
import java.util.Scanner;
import java.io.*;

class QueueOps {
   int queue[];
   int front, rear, size, count;
   Scanner sc = new Scanner(System.in);

   public QueueOps(int n) {
      size = n;
      queue = new int[size];
      count = 0;
      rear = -1;
      front = 0;
   }

   public void enQueue() {
      if (count == size) {
         System.out.println("Queue overflow");
      } else {
         count++;
         int element = sc.nextInt();
         rear = (rear + 1) % size;
         queue[rear] = element;
      }

   }

   public void deQueue() {
      if (count == 0) {
         System.out.println("Queue empty");
      } else {
         count--;
         System.out.println("deQueued element : " + queue[front]);
         front = (front + 1) % size;
      }
   }

   public void display() {
      if (count == 0) {
         System.out.println("Queue empty");
      } else {
         int it = front;
         for (int i = 0; i < count; i++) {
            System.out.print(queue[it] + " ");
            it = (it + 1) % size;
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
