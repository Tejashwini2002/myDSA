// Question: Left rotate array by d places
/*
Approach 2: Optimal approach.
By making use of the given array itself instead of using a temporary array. That is, space complexity = O(1) as we don't use any extra space. But Time Complexity = O(d)+O(n-d)+O(n) = O(2n)
*/ 
import java.util.*;

public class leftRotateAnArrayByDplaces2 {
    // Function to reverse the array
    static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void leftRotate(int[] arr, int n, int d) {
        if (n == 0) {
            return;
        }
        // Get the effective number of rotations
        d = d % n;
        // step 1:
        reverse(arr, 0, d - 1);
        // step 2:
        reverse(arr, d, n - 1);
        // step 3:
        reverse(arr, 0, n - 1);
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
        leftRotate(arr, n, d);
        System.out.println("The array elements after left rotation by d places: ");
        printArray(arr);
    }
}
/*
 * Enter the number of elements in the array:
 * 7
 * Enter the elements of the array:
 * 1 2 3 4 5 6 7
 * The array elements are:
 * 1 2 3 4 5 6 7
 * Enter the value of d(i.e., By how many places you want the elements to left
 * rotate? )
 * 3
 * The array elements after left rotation by d places:
 * The array elements are:
 * 4 5 6 7 1 2 3
 */