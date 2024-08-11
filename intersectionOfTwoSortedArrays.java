
/*
Intersection of two sorted arrays

21

0
Problem Statement: Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays, find all the elements which occur in both the arrays.

Examples:

Example 1:
Input: 
A: [1 2 3 3 4 5 6]
, B: [3 3 5]
Output: 3,3,5
Explanation: We are given two arrays A and B. 
The elements present in both the arrays  
are 3,3 and 5.

Example 2:
Input: 
A: [1 2 3 3 4 5 6]
B: [3 5]
Output: 3,5
Explanation: We are given two arrays A and B. 
The elements present in both the arrays are 3 and 5.

Brute Force Approach:
For the brute force approach, we are given 2 arrays, we take an element from array A and search if it is present in array B on the condition that the same element in array B hasn’t been traversed before by any duplicate element in array A.

For Example:

A: [1 2 3 3 4 5 6] 
B: [3 3 5]
We first create a visited array for array B which is initialized with 0 indicating that initially none of the elements of array B are visited.
We start checking the first element from array A if it matches with any element of array B which is not yet visited. If they match, we mark the element in array B as visited, put the element in ans array, and move to the next element in array A.
If the element matches but is already being visited before, we do not add it to the ans array concluding that the element has been mapped to some other element previously.
After iterating the whole of Array A, we get the intersection of two arrays stored in the ans array.
For better understanding of intuition, please watch the video at the bottom of my page
*/
// Brute Force Approach:
import java.util.*;

class intersectionOfTwoSortedArrays {

  public static ArrayList<Integer> intersectionOfArrays(int[] A, int[] B) {

    ArrayList<Integer> ans = new ArrayList<>();

    // to maintain visited
    int[] visited = new int[B.length];

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {

        if (A[i] == B[j] && visited[j] == 0) {

          // if element matches and has not been matched with any other before
          ans.add(B[j]);
          visited[j] = 1;

          break;
        } 
        else if (B[j] > A[i])
        {
          break;
          // because given array B is sorted , element will not be beyond this
        }   
      }
    }
    return ans;
  }

  public static void main(String[] args)
  {
    // Array Initialisation.
    int A[] = { 1, 2, 3, 3, 4, 5, 6, 7 };
    int B[] = { 3, 3, 4, 4, 5, 8 };

    ArrayList<Integer> ans = intersectionOfArrays(A, B);

    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }

  }
}
/*
 * OUTPUT:
 * 3 3 4 5
 */
/*
 * Time Complexity: O(n1 x n2) ~ O(n^2) { There are nested loops where the outer
 * one loops n1 times and the inner one loops n2 times, where n1 = A.size() and
 * n2 = B.size() }.
 * Space Complexity: O(n) { Extra Space used for the visited and ans arrays }.
 */