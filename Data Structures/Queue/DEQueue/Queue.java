import java.lang.*;
import java.text.Format;
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

   public void insertRear() {
      if (count == size) {
         System.out.println("Queue overflow");
      } else if (rear == size - 1) {
         count++;
         int element = sc.nextInt();
         front = front - 1;
         for (int i = front; i < rear; i++) {
            queue[i] = queue[i + 1];
         }
         queue[rear] = element;
      } else {
         count++;
         int element = sc.nextInt();
         rear = rear + 1;
         queue[rear] = element;
      }
   }

   public void insertFront() {
      if (count == size) {
         System.out.println("Queue overflow");
      } else if (front == 0) {
         for (int i = rear + 1; i > 0; i--) {
            queue[i] = queue[i - 1];
         }
         int element = sc.nextInt();
         rear = rear + 1;
         count++;
         queue[front] = element;
      } else {
         front = front - 1;
         int element = sc.nextInt();
         queue[front] = element;
      }
   }

   public void deleteRear() {
      if (count == 0) {
         System.out.println("Queue Underflow");
         front = 0;
         rear = -1;
      } else {
         count--;
         System.out.println("Dequeued from rear : " + queue[rear]);
         rear--;
      }
   }

   public void deleteFront() {
      if (count == 0) {
         System.out.println("Queue Underflow");
         front = 0;
         rear = -1;
      } else {
         System.out.println("Dequeued from the front end : " + queue[front]);
         front = front + 1;
         count--;
      }
   }

   public void display() {
      if (count == 0) {
         System.out.println("Queue empty");
      } else {
         for (int i = front; i <= rear; i++) {
            System.out.println(queue[i] + " ");
         }
      }
   }

}

class Queue {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.println("Welcome to DEQueue Operations");
      System.out.println("Enter the size of the Queue");
      int n = in.nextInt();
      QueueOps arr = new QueueOps(n);
      do {
         int option;
         System.out.println("Enter the option");
         System.out.println("1.InsertRear\t2.insertFront\t3.deleteRear\t4.deleteFront\t5.display\t6.exit");
         option = in.nextInt();
         System.out.println();

         switch (option) {
            case 1:
               arr.insertRear();
               System.out.println();
               break;

            case 2:
               arr.insertFront();
               System.out.println();
               break;

            case 3:
               arr.deleteRear();
               System.out.println();
               break;

            case 4:
               arr.deleteFront();
               System.out.println();
               break;

            case 5:
               arr.display();
               break;

            case 6:
               System.exit(0);

            default:
               System.out.println("Wrong option");
         }
      } while (true);
   }
}