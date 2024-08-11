
/*
Given an array of N integers and a non-negative integer D, right rotate the array by D place. 
*/
// Optimal approach: Without using a temporary array
import java.util.*;
public class rightRotateAnArrayByDplaces {
    // Function to reverse the array
    static void reverse(int arr[],int start,int end){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    static void rightRotate(int[] arr,int n,int d){
        if(n==0){
            return;
        }
        // Get the effective number of rotations
        d = d%n;
        // step 1: reverse the last d elements
        reverse(arr,n-d,n-1);
        // step 2: reverse the first (n-d) elements:
        reverse(arr,0,n-d-1);
        // step 3: reverse the whole array
        reverse(arr,0,n-1);
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
      System.out.println("Enter the value of d(i.e., By how many places you want the elements to right rotate? )");
      int d = sc.nextInt();
      rightRotate(arr, n, d);
      System.out.println("The array elements after right rotation by d places: ");
      printArray(arr);
    }
}
/*
Enter the number of elements in the array: 
7
Enter the elements of the array: 
1 2 3 4 5 6 7
The array elements are: 
1 2 3 4 5 6 7
Enter the value of d(i.e., By how many places you want the elements to right rotate? )
3
The array elements after right rotation by d places:
The array elements are:
5 6 7 1 2 3 4
*/
/*
 The above solution is the optimal one.
 Time Complexity: O(d)+O(n-d)+O(n)=O(2*n), where n = size of the array,d= the number of rotations. Each term corresponds to each reversal step.
 
 Space Complexity: O(1) since no extra space is required.
*/
