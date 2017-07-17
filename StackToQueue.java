import java.util.Stack;

public class StackToQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public StackToQueue(){
        pushStack=new Stack<>();
        popStack=new Stack<>();
    }

    public void push(int val){
        pushStack.push(val);
    }

    public Integer peek(){
        if(popStack.isEmpty()) {
            if(pushStack.empty())  return null;
            while(!pushStack.empty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public Integer poll(){
        if(popStack.isEmpty()) {
            if(pushStack.empty())  throw new RuntimeException("Queue is empty!");
            while(!pushStack.empty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public static void main(String args[]){
        StackToQueue stq=new StackToQueue();
        stq.push(0);
        stq.push(1);
        stq.push(2);
        stq.push(3);
        stq.push(4);
        System.out.println(stq.poll());
        System.out.println(stq.peek());
        System.out.println(stq.poll());
        System.out.println(stq.poll());
        System.out.println(stq.poll());
        System.out.println(stq.poll());
        stq.push(5);
        System.out.println(stq.peek());
        System.out.println(stq.poll());
    }
}
