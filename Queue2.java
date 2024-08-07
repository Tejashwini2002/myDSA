
// When you implement a normal queue using array, it takes O(N) time for remove operation. But if you implement a Circular queue using array, then it will take O(1) Time for all operations.

// IMPLEMENTING A CIRCULAR QUEUE USING ARRAY                                            

public class Queue2 {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n){
           this.size = n;
           arr = new int[size];
           rear = -1;
           front = -1;
        }
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        public static boolean isFull(){
            return (rear+1)%size == front;
        }
        //enqueue - O(1) time
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full!");
                return;     
            }
            // when we are adding the first element, we should also move front from -1 to 0, as initially both front and rear will be pointing to -1.
            if(front == -1){
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        // dequeue - takes O(1) time
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            int front_element = arr[front];
            // when there is only single element in the queue, single element condition we will apply i.e,here rear = front = 0. after deleting the element, we make both of them to point to -1.
            if(rear == front){ // here, they are equal to zero
                rear = front = -1;
            }else{
                front = (front+1)%size;
            }
                                                                                                        
            return front_element;
        }

        // peek - O(1)
        public static int peek(){
            if(isEmpty()){
                return -1;
            }

            return arr[front];
        }

        public static void print(){
            for(int i = front;i!=rear;i = (i+1)%size){
               System.out.print(arr[i]+" ");
            }
            System.out.print(arr[rear]+"\n");
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5); // we are passing array size as 5
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        
        q.print();
        q.remove();
        q.remove();
        q.print();
        q.add(88);
        q.print();
        q.add(75);
        q.print();

        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }
    }
}
/*
OUTPUT:

1 2 3 4 5
3 4 5
3 4 5 88
3 4 5 88 75
*/