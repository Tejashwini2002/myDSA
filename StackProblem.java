// Competitive programming question on stack 
import java.util.*;

public class StackProblem {
    public static void pushAtBottom(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // Using listIterator() to iterater through the stack.
        ListIterator<Integer> ListIterator;
        ListIterator = s.listIterator(s.size()); 
        System.out.println("Iteration over the Stack from top to bottom using listIterator() Method:");
        while (ListIterator.hasPrevious()) {
            Integer num = ListIterator.previous();
            System.out.println(num);
        }
        pushAtBottom(4, s);
        ListIterator = s.listIterator(s.size());
        System.out.println("After inserting the element at the bottom of the stack: ");
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
After inserting the element at the bottom of the stack: 
Iteration over the Stack from top to bottom using listIterator() Method:
3
2
1
4
*/