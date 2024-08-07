// Implementation of Queue using LinkedList

// We add elements at tail and remove elements at head.
/*
   while adding, we do
    tail.next = newNode; 
    tail = tail.next;

   and while deleting, we do
    head = head.next; 
 */
public class Queue3 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // enqueue- O(1)
        public static void add(int data) {
            Node newNode = new Node(data);
            if (tail == null) {
                tail = head = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // dequeue - O(1)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = head.data;
            // when single element is there, after deleting it, we should make tail also
            // null.
            if (head == tail) { // means only one element is there.
                tail = null;
            }
            head = head.next;
            return front;

        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }

        // print
        public static void print() {
            Node start = head;
            while (start != null) {
                System.out.print(start.data+" ");
                start = start.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Queue q = new Queue();
        Queue.add(1);
        Queue.add(2);
        Queue.add(3);
        Queue.add(4);
        Queue.add(5);
        Queue.add(6);

        Queue.print();
        Queue.remove();
        Queue.print();

    }
}
/*
OUTPUT:
1 2 3 4 5 6 
2 3 4 5 6
*/
