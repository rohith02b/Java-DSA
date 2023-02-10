import java.util.Scanner;

class LinkedList {
   Node head;

   static class Node {
      int data;
      Node next;

      public Node(int d) {
         data = d;
         next = null;
      }
   }

   public LinkedList insert(LinkedList list, int data) {
      Node new_node = new Node(data);

      if (list.head == null)
         head = new_node;

      else {
         Node cur = list.head;
         while (cur.next != null) {
            cur = cur.next;
         }

         cur.next = new_node;
      }

      return list;
   }

   public LinkedList delete(LinkedList list, int data) {

      if (list.head == null) {
         System.out.println("No elements in the Linked List");
         return null;
      }

      if (list.head.data == data) {
         System.out.println("Element found and removed");
         list.head = list.head.next;
         return list;
      }

      Node cur = list.head;
      Node prev = null;

      int flag = 0;
      while (cur != null) {
         if (cur.data == data) {
            flag = 1;
            System.out.println("Element found and removed");
            prev.next = cur.next;
            break;
         }
         prev = cur;
         cur = cur.next;
      }

      if (flag == 0) {
         System.out.println("Element not found");
      }

      return list;
   }

   public void search(LinkedList list, int data) {

      int flag = 0;
      if (list.head == null) {
         System.out.println("Linked list is empty");
      }

      else {
         Node cur = list.head;
         while (cur != null) {
            if (cur.data == data) {
               System.out.println("Element found !");
               flag = 1;
               break;
            }

            cur = cur.next;
         }

         if (flag == 0) {
            System.out.println("Element not found");

         }
      }
   }

   public void printList(LinkedList list) {
      Node cur = list.head;

      if (list.head == null) {
         System.out.println("Linked list empty");

      }
      while (cur != null) {
         System.out.print(cur.data + " ");
         cur = cur.next;
      }
      System.out.println();
   }
}

class list {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      LinkedList list = new LinkedList();
      System.out.println("Welcome to Linked list operations");
      do {
         System.out.println("Enter the Option");
         System.out.println("1.Insert\t2.Delete\t3.Search\t4.Display");
         int option = sc.nextInt();
         int element;
         switch (option) {
            case 1:
               System.out.println("Enter the element to be inserted");
               element = sc.nextInt();
               list = list.insert(list, element);
               System.out.println();

               break;

            case 2:
               System.out.println("Enter the element to be removed");
               element = sc.nextInt();
               list.delete(list, element);
               System.out.println();

               break;

            case 3:
               System.out.println("Enter the element to be searched");
               element = sc.nextInt();
               list.search(list, element);
               System.out.println();

               break;

            case 4:
               list.printList(list);
               System.out.println();

               break;

            case 5:
               System.exit(0);

            default:
               System.out.println("Wrong input");
         }

      } while (true);
   }
}