
// Competitive programming question on stack 
import java.util.*;

public class Stack_reverse  {
    // we make use of recursion to push the element at the bottom of the stack.
    public static void pushAtBottom(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }
    /* We shall make use of recursion to reverse the stack. Here, our recursive approach will pop the topmost element first and then reverse the remaining elements of the stack and then insert the popped element into the stack but it will push at the bottom of the stack by calling pushAtBottom function written above.
    */
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverse(s);
        pushAtBottom(top, s);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // Using listIterator() to iterate through the stack.
        ListIterator<Integer> ListIterator;
        ListIterator = s.listIterator(s.size()); 
        System.out.println("Iteration over the Stack from top to bottom using listIterator() Method:");
        while (ListIterator.hasPrevious()) {
            Integer num = ListIterator.previous();
            System.out.println(num);
        }
        System.out.println("Index of 1 is"+s.indexOf(1));
        System.out.println("Index of 2 is"+s.indexOf(2));
        System.out.println("Index of 3 is"+s.indexOf(3));
        System.out.println("Size of stack is: "+s.size());
        
        reverse(s);

        ListIterator = s.listIterator(s.size());
        System.out.println("After reversing the stack: ");
        System.out.println("Iteration over the Stack from top to bottom using listIterator() Method:");
        while (ListIterator.hasPrevious()) {
            Integer num = ListIterator.previous();
            System.out.println(num);
        }
    }
}
/*
OUTPUT: 
Iteration over the Stack from top to bottom using listIterator() Method:
3
2
1
After reversing the stack: 
Iteration over the Stack from top to bottom using listIterator() Method:
1
2
3
*/