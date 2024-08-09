// Question: Left rotate array by d places
import java.util.*;

public class leftRotateArrayByDplaces {
static void leftRotate(int[] arr,int n, int d){
     if(n == 0){
        return;
     }
     // Get the effective number of rotations
     d = d % n;
     // checking if d is a multiple of n
     if(d == 0){
      return;
     }
     int[] temp = new int[d]; // temporary array

     // Step 1: Copying the first d elements in the temporary array:
     for(int i = 0;i<d;i++){
      temp[i] = arr[i];
     }
     // Step 2: Shift last (n-d) elements to the left by d places in the given array:
     for(int i = d;i<n;i++){
      arr[i-d] = arr[i];
     }
     // Step 3: Place the elements of the temporary arry in the last d places of the given array:
     for(int i = n-d;i<n;i++){
      arr[i] = temp[i-(n-d)];
     }  
}
static void printArray(int[] arr){
   System.out.println("The array elements are: ");
   for(int i = 0;i<arr.length;i++){
     System.out.print(arr[i]+" ");  
   }
   System.out.println();
}
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements in the array: ");
    int n = sc.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the elements of the array: ");
    for(int i = 0;i<n;i++){
      arr[i] = sc.nextInt();
    }
    printArray(arr);
    System.out.println("Enter the value of d(i.e., By how many places you want the elements to left rotate? )");
    int d = sc.nextInt();
    leftRotate(arr, n, d);
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
4 5 6 7 1 2 3
*/