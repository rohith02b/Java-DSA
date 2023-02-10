import java.util.*;
import java.lang.*;

class ArrayOps {
  int[] arr;
  int index = 0;

  public ArrayOps(int n) {
    arr = new int[n];
  }

  public void insert(int element) {
    try {
      arr[index++] = element;
    } catch (Exception e) {
      index--;
      System.out.println(e);
    }
  }

  public void delete(int position) {

    if (position > index) {
      System.out.println("Cannot delete as there is no element at this position");
    } else {
      for (int i = position - 1; i < index - 1; i++) {
        arr[i] = arr[i + 1];
      }

      index--;
    }
  }

  public void display() {
    for (int i = 0; i < index; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}

class Array {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to Array Operations");
    System.out.println("Enter the size of the array");
    int n = in.nextInt();
    ArrayOps arr = new ArrayOps(n);
    do {
      int option;
      System.out.println("Enter the option");
      System.out.println("1.Insert\t2.Delete Element\t3.Display");
      option = in.nextInt();
      System.out.println();

      switch (option) {
        case 1:
          System.out.println("Enter the element to be inserted");
          int element = in.nextInt();
          arr.insert(element);
          System.out.println();

          break;

        case 2:
          System.out.println("Enter the position of the element to be deleted");
          int pos = in.nextInt();
          arr.delete(pos);
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