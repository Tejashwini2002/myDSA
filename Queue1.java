
// Implementing queue using array

public class Queue1 {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n){
           this.size = n;
           arr = new int[size];
           rear = -1;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }
        public static boolean isFull(){
            return rear == size-1;
            //rear == size-1 means rear is pointing to n-1th element, indicating we have already added n elements into the queue.
        }
        //enqueue - O(1) time
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full!");
                return;     
            }
            rear++;
            arr[rear] = data;
        }

        // dequeue - takes O(N) time when we implement queue using array
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            int front = arr[0];
            for(int i = 0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        // peek - O(1)
        public static int peek(){
            if(isEmpty()){
                return -1;
            }

            return arr[0];
        }
        public static void print(){
            for(int i = 0;i<=rear;i = i+1){
               System.out.print(arr[i]+" ");
            }
            System.out.println("\n");
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5); // we are passing array size as 5
        q.add(1);
        q.add(2);
        q.add(3);
        // 1 2 3 ......
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        q.print();
        q.remove();
        q.print();
    }
}
/*
1
2
3
*/