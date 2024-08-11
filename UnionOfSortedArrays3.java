
// Finding Union of Two Sorted arrays
/*
Solution 3: Two Pointers
Solution 1 and 2 work for the unsorted arrays also, The arrays arr1 and arr2 are sorted, can we use this property to reduce the time Complexity?

Using the property that the arrays are sorted we can bring down the time complexity from

O((m+n)log(m+n))    TO    O(m+n).
Approach:
Take two pointers let’s say i,j pointing to the 0th index of arr1 and arr2.
Create an empty vector for storing the union of arr1 and arr2.
From solution 2 we know that the union is nothing but the distinct elements in arr1 + arr2 
Let’s traverse the arr1 and arr2 using pointers i and j and insert the distinct elements found into the union vector.
While traversing we may encounter three cases.

arr1[ i ] == arr2[ j ] 
Here we found a common element, so insert only one element in the union. Let’s insert arr[i] in union and increment i.

NOTE: There may be cases like the element to be inserted is already present in the union, in that case, we are inserting duplicates which is not desired. So while inserting always check whether the last element in the union vector is equal or not to the element to be inserted. If equal we are trying to insert duplicates, so don’t insert the element, else insert the element in the union. This makes sure that we are not inserting any duplicates in the union because we are inserting elements in sorted order.
arr1[ i ]  < arr2[ j ]
arr1[ i ] < arr2[ j ] so we need to insert arr1[ i ] in union.IF last element in  union vector is not equal to arr1[ i ],then insert in union else don’t insert. After checking Increment i.
arr1[ i ] > arr2[ j ]
arr1[ i ] > arr2[ j ] so we need to insert arr2[ j ] in union. IF the last element in the union vector is not equal to arr2[ j ], then insert in the union, else don’t insert. After checking Increment j. After traversing if any elements are left in arr1 or arr2 check for condition and insert in the union
*/
import java.util.*;

class UnionOfSortedArrays3 {
  static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) 
  {
    int i = 0, j = 0; // pointers
    ArrayList<Integer> Union = new ArrayList<>(); // Uninon vector
    while (i < n && j < m)
    {
      if (arr1[i] <= arr2[j]) // Case 1 and 2
      {
        // if Union.size() == 0, it is for the first time. So, Just take it.
        if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i])
        {
          Union.add(arr1[i]);
        } 
        i++;
      }
      else // case 3
      {
        if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j])
        {
          Union.add(arr2[j]);
        }
        j++;
      }
    }
    while (i < n) // If any element is left in arr1
    {
      if (Union.get(Union.size() - 1) != arr1[i])
      {
        Union.add(arr1[i]);
      }  
      i++;
    }
    while (j < m) // If any elements left in arr2
    {
      if (Union.get(Union.size() - 1) != arr2[j])
      {
        Union.add(arr2[j]);
      }
      j++;
    }
    return Union;
  }

  public static void main(String[] args)
  {
    int arr1[] = { 1, 1, 2, 3, 4, 5};
    int arr2[] = { 2, 3, 4, 4, 5, 6};
    int n = arr1.length, m = arr2.length;
    ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);
    System.out.println("Union of arr1 and arr2 is ");
    for (int val : Union)
      System.out.print(val + " ");
  }
}
/*
OUTPUT:
Union of arr1 and arr2 is 
1 2 3 4 5 6 
*/
/*
 * Time Complexity: O(m+n), Because at max, 'i' runs for 'n' times and 'j' runs for 'm'
 * times. When there are no common elements in arr1 and arr2 and all elements in
 * arr1, arr2 are distinct.
 * 
 * Space Complexity : O(m+n) {If Space of Union ArrayList is considered}
 * 
 * O(1) {If Space of union ArrayList is not considered}
 */
