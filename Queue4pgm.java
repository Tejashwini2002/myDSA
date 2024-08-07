
// IMPLEMENTING QUEUE USING JAVA COLLECTION FRAMEWORK
import java.util.*;

public class Queue4pgm {
    static class queue {
        static Queue<Integer> q = new LinkedList<>();
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
       queue qobj = new queue();
       qobj.enqueue(11);
       qobj.enqueue(22);
       qobj.enqueue(33);
       qobj.enqueue(44);
       qobj.print();
       qobj.dequeue();
       qobj.print();
       System.out.println("The front element of the queue is: "+qobj.peek());
         
    }
}
/*
OUTPUT: 
11 22 33 44 
22 33 44 
The front element of the queue is: 22

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