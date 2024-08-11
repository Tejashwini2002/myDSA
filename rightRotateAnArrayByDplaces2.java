/*
Given an array of N integers and a non-negative integer D, right rotate the array by D place. 
*/
// Brute force approach: By using a temporary array

import java.util.Scanner;

public class rightRotateAnArrayByDplaces2 {
    static void rightRotate(int[] arr, int n, int d) {
        if (n == 0) {
            return;
        }
        // Get the effective number of rotations
        d = d % n;
        // checking if d is a multiple of n
        if (d == 0) {
            return;
        }
        int[] temp = new int[d]; // temporary array

        // Step 1: Copying the last d elements in the temporary array:
        for (int i = (n - d); i < n; i++) {
            temp[i - (n - d)] = arr[i];
        }
        // Step 2: Shift first (n-d) elements to the right by d places in the given
        // array.
        for (int i = (n - d - 1); i >= 0; i--) {
            arr[i + d] = arr[i];
        }
        // Step 3: Place the elements of the temporary array in the first d places of
        // the given array.
        for (int i = 0; i < d; i++) {
            arr[i] = temp[i];
        }
    }
    static void printArray(int[] arr) {
        System.out.println("The array elements are: ");
        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] + " ");
        }
        System.out.println();
     }
      public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the number of elements in the array: ");
      int n = sc.nextInt();
      int arr[] = new int[n];
      System.out.println("Enter the elements of the array: ");
      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }
      printArray(arr);
      System.out.println("Enter the value of d(i.e., By how many places you want the elements to left rotate? )");
      int d = sc.nextInt();
      rightRotate(arr, n, d);
      System.out.println("The array elements after left rotation by d places: ");
      printArray(arr);
   }
}
/*
OUTPUT:
Enter the number of elements in the array: 
7
Enter the elements of the array: 
1 2 3 4 5 6 7
The array elements are: 
1 2 3 4 5 6 7 
Enter the value of d(i.e., By how many places you want the elements to left rotate? )
3
The array elements after left rotation by d places:
The array elements are:
5 6 7 1 2 3 4
*/
