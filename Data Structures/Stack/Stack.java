import java.lang.*;
import java.util.*;

class StackOps {
   int[] stack;
   int top, n;
   Scanner in = new Scanner(System.in);

   public StackOps(int n) {
      this.n = n;
      stack = new int[n];
      top = -1;
   }

   public void push() {
      if (top == (n - 1)) {
         System.out.println("Stack overflow!");
      } else {
         System.out.println("Enter the element to be inserted");
         int element = in.nextInt();
         stack[++top] = element;
         System.out.println("pushed to top of stack");
      }
   }

   public void pop() {

      if (top == -1)
         System.out.println("Stack underflow");
      else {
         System.out.println("Deleted element from stack : " + stack[top]);
         top--;
      }
   }

   public void display() {

      if (top == -1) {
         System.out.println("Stack empty");
      } else {
         for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
         }
      }
   }

   public void peek() {
      System.out.println("The top of the stack has : " + stack[top]);
   }
}

class Stack {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.println("Welcome to Stack Operations");
      System.out.println("Enter the size of the Stack");
      int n = in.nextInt();
      StackOps arr = new StackOps(n);
      do {
         int option;
         System.out.println("Enter the option");
         System.out.println("1.Push\t2Pop Element\t3.Display\t4.Peek\t5.Exit");
         option = in.nextInt();
         System.out.println();

         switch (option) {
            case 1:
               arr.push();
               System.out.println();
               break;

            case 2:
               arr.pop();
               System.out.println();
               break;

            case 3:
               arr.display();
               System.out.println();
               break;

            case 4:
               arr.peek();
               break;

            case 5:
               System.exit(0);

            default:
               System.out.println("Wrong option");

         }
      } while (true);
   }
}
