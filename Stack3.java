import java.util.*;

//import java.util.Iterator;

public class Stack3 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        
        // peek an element
        int first_element;
        first_element= s.peek();
        System.out.println("First element: " + first_element);
        // Search an element
        int location = s.search(2);
        System.out.println("Location of 2: " + location);
        // Checks the Stack is empty or not
        boolean rslt = s.empty();
        System.out.println("Is the stack empty or not? " + rslt);

        // throws exception if the stack is empty
        try {
            s.pop();
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
        first_element= s.peek();
        System.out.println("First element after pop operation: " + first_element);
        // Using the iterator() Method
        System.out.println("Iteration over the Stack from bottom to top using the iterator() Method: ");
        Iterator<Integer> iterator = s.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            System.out.println(value);
        }

        // Using the forEach() Method
        System.out.println("Iteration over the stack from bottom to top using forEach() Method:");
        // invoking forEach() method for iteration over the stack
        s.forEach(n -> {
            System.out.println(n);
        });

        // Using listIterator() Method
        ListIterator<Integer> ListIterator = s.listIterator(s.size());
        System.out.println("Iteration over the Stack from top to bottom using listIterator() Method:");
        while (ListIterator.hasPrevious()) {
            Integer num = ListIterator.previous();
            System.out.println(num);
        }

    }
}
/*
OUTPUT:
First element: 5
Location of 2: 4
Is the stack empty or not? false
First element after pop operation: 4
Iteration over the Stack from bottom to top using the iterator() Method:
1
2
3
4
Iteration over the stack from bottom to top using forEach() Method:
1
2
3
4
Iteration over the Stack from top to bottom using listIterator() Method:
4
3
2
1
*/