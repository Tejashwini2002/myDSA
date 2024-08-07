// IMPLEMENTING STACK USING ARRAYLIST.
import java.util.ArrayList;
public class Stack2 {
    static class Stack{ // we made this class as static so as to use it directly inside the main() function.
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0;
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            // the last element of the list must be removed. So index of last element i.e., list.size-1 is passed as an argument to the get method.
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
        public static void printlist(){
            if(isEmpty()){
                System.out.println("Stack is empty.");
            }
            int index = list.size()-1;
            while(index>=0){
                System.out.println(list.get(index));
                // index-=1;
                index= index-1;
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
        s.printlist();
    }
    
}
/*
OUTPUT:
4
3
2
1
*/