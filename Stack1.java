// Implementing Stack using linkedlist and arraylist is more efficient than implementing using array because array size is fixed and thus it is a tedious process.Whereas here, in case of linkedlist and arraylist, we can easily work with the basic operations(push,pop, and peek).

// IMPLEMENTING STACK USING LINKEDLIST.
public class Stack1 {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class Stack{
        public static Node head; // head is stack top // I must declare this head as static because it is the only head and in every function, we are talking about this only. If we don't make it static we get error in our program.
        public static boolean isEmpty(){
            return head == null;
        }
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                // if our stack is empty make new node as the head node.
                head = newNode;
                return;
            }
            // if our stack(which is being implemented using linkedlist) is not empty, then insert the new node at the beginning of the list and make it as new head and make it point to the previous head.
            newNode.next = head;
            head = newNode;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top_element = head.data;
            head = head.next;
            return top_element;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
        public static void printList(){
            Node start = head;
            while(start!=null){
                System.out.println(start.data);
                start = start.next;
            }
        }
    }
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        s.printList();
    }
    
}
/*
SAMPLE OUTPUT:
4
3
2
1
*/
