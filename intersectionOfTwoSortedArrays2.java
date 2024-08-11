// Optimal Approach: 
/*
Solution 2: 2 Pointer approach
As we saw in the brute force, we were not going forward as soon as we encountered any element greater than the element we are looking for. That fact, about arrays being sorted, can be used to solve this problem in one pass.
*/

import java.util.*;

class intersectionOfTwoSortedArrays2
{

  public static ArrayList<Integer> intersectionOfArrays(int[] A, int[] B)
  {
    // Declare ans array.
    ArrayList<Integer> ans = new ArrayList<>();

    int i = 0, j = 0;

    // to traverse the arrays
    while (i < A.length && j < B.length) {

      // if current element in i is smaller
      if (A[i] < B[j]) {
        i++;
      } else if (B[j] < A[i]) {
        j++;
      } else {

        // both elements are equal
        ans.add(A[i]);
        i++;
        j++;
      }
    }
    return ans;
  }

  public static void main(String args[]) {
    // Array Initialisation.
    int[] A = { 1, 2, 3, 3, 4, 5, 6, 7 };
    int[] B = { 3, 3, 4, 4, 5, 8 };

    ArrayList<Integer> ans = intersectionOfArrays(A, B);

    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }

  }
}
/*
3 3 4 5 
*/
/*
 * Time Complexity: O(n) { Since the elements are compared within the single
 * pass for both the arrays this approach would take a linear time and in the
 * worst case O(n1+n2) where n1 = A.size() and n2 = B.size() }.
 * 
 * Space Complexity: O(1) { There is no extra space used in the two-pointers
 * approach }.
 */