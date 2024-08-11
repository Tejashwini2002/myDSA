import java.util.*;

public class moveZerosToTheEnd2 {
    public static int[] moveZeros(int n, int []a) {
        int j = -1;
        //place the pointer j:
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                j = i;
                break;
            }
        }

        //no non-zero elements:
        if (j == -1) return a;

        //Move the pointers i and j and swap accordingly:
        for (int i = j + 1; i < n; i++) {
            if (a[i] != 0) {
                //swap a[i] & a[j]:
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                j++;
            }
        }
        return a;
    }
    static void printArray(int[] arr) {
        System.out.println("The array elements are: ");
        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int n = arr.length;
        System.out.println("Initially: ");
        printArray(arr);
        int[] ans = moveZeros(n, arr);
        System.out.println("Finally: ");
        printArray(ans);
    }
}
/*
OUTPUT:
Initially: 
The array elements are: 
1 0 2 3 2 0 0 4 5 1 
Finally: 
The array elements are: 
1 2 3 2 4 5 1 0 0 0
*/
/*
Time Complexity: O(N), N = size of the array.
Reason: We have used 2 loops and using those loops, we are basically traversing the array once.

Space Complexity: O(1) as we are not using any extra space to solve this problem.
*/