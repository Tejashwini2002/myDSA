
// Implementing queue using 2 stacks
/*
Approach: we'll take 2 stacks s1 and s2. If s1 is empty, directly insert 1st element into s1. If s1 is not empty, and you want to insert element into s1, then pop the contents from s1 and go on pushing them into s2 until s1 becomes empty. Once s1 is empty, push your new element into s1 and then pop the elements from s2 and go on pushing into s1.
*/
import java.util.*;

public class queue5 {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Here add operation takes O(N) time
        public static void add(int data) {
            while (!s1.isEmpty()) { // until s1 becomes empty
                s2.push(s1.pop()); // popping from s1 and pushing into s2.
            }
            // once s1 becomes empty, push new data into it.
            s1.push(data);
            // Next, until s2 becomes empty pop elements from s2 and go on pushing in s1.
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Here remove operation takes O(1) time
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            // The topmost element of stack s1 is our front element of the queue.
            return s1.pop();
        }

        // Here peek operation takes O(1) time
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            // The topmost element of stack s1 is our front element of the queue.
            return s1.peek();
        }
        public static void print() {
           for(int i = s1.size()-1;i>=0;i--){
            System.out.print(s1.elementAt(i)+ " ");
           }
           System.out.println();
        }
    }

    public static void main(String[] args) {
        // Queue q = new Queue();
        // q.add(1);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.print();

        Queue.add(1);
        Queue.add(2);
        Queue.add(3);
        Queue.add(4);
        Queue.add(5);
        Queue.add(6);
        Queue.print();
        System.out.println("The element removed is: "+Queue.remove());
        Queue.print();
        System.out.println("The element at the queue front is: "+Queue.peek());  
    }
}
/*
OUTPUT:

1 2 3 4 5 6 
The element removed is: 1
2 3 4 5 6 
The element at the queue front is: 2
*/
