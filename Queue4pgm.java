
// IMPLEMENTING QUEUE USING JAVA COLLECTION FRAMEWORK

/*
         NOTE: Difference between ArrayDeque and LinkedList: The ArrayDeque class implements the Deque interface as a resizable array, whereas the LinkedList class implements it as a list.

         Disadvantages of using ArrayDeque class:
         1. Not synchronized: By default, the ArrayDeque class is not synchronized, which means that multiple threads can access it simultaneously, leading to potential data corruption.
         2. Limited capacity: Although the ArrayDeque class uses a resizable array to store its elements, it still has a limited capacity, which means that you may need to create a new ArrayDeque when the old one reaches its maximum size.

         ADVANTAGES of using ArrayDeque class:
         1. Efficient: provides constant-time performance for inserting & removing elements from both ends of the queue.
         2. Resizable: uses a resizable array to store its elements.
         3. Lightweight: is a lightweight ds that doesn't require additional overhead, such as linkedlist nodes.
         4. The ArrayDeque class is not thread-safe, but you can use the Collections.synchronizedDeque method to create a thread-safe version of the ArrayDeque class.
        */
import java.util.*;

public class Queue4pgm {
    static class queue {
        static Queue<Integer> q = new LinkedList<>();
        // static Queue<Integer> q = new ArrayDeque<>(); // Deque means Double ended queue
        /*
         * we can make objects of only classes and not of interfaces. That's why we have
         * written here LinkedList and not Queue, as Queue is an Interface. Two classes
         * namely, ArrayDeque and LinkedList can be used to implement the Queue
         * Interface.
         */
        

        public static void enqueue(int ele) {
            q.add(ele);
        }

        public static int dequeue() {
            int ele = q.remove();
            return ele;
        }

        public static int peek() {
            return q.peek();
        }

        public static void print() {
            q.forEach(n -> {
                System.out.print(n + " ");
            });
            System.out.println();
        }
    }

    public static void main(String[] args) {
    //    queue qobj = new queue();
       queue.enqueue(10);
       queue.enqueue(11);
       queue.enqueue(22);
       queue.enqueue(33);
       queue.enqueue(44);
       queue.print();
       queue.dequeue();
       queue.print();
       System.out.println("The front element of the queue is: "+queue.peek());
         
    }
}
/*
OUTPUT: 
10 11 22 33 44 
11 22 33 44 
The front element of the queue is: 11

*/

/*
 * void java.lang.Iterable.forEach(Consumer<? super Integer> action)
 * Performs the given action for each element of the Iterable until all elements
 * have been processed or the action throws an exception. Actions are performed
 * in the order of iteration, if that order is specified. Exceptions thrown by
 * the action are relayed to the caller.
 * 
 * The behavior of this method is unspecified if the action performs
 * side-effects that modify the underlying source of elements, unless an
 * overriding class has specified a concurrent modification policy.
 * 
 * Parameters:
 * 
 * action The action to be performed for each element
 * Throws:
 * 
 * NullPointerException - if the specified action is null
 * Since:
 * 
 * 1.8
 * Impl Spec:
 * 
 * The default implementation behaves as if:
 * 
 * for (T t : this)
 * action.accept(t);
 * 
 */
