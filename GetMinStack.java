import java.util.Stack;

public class GetMinStack{
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public GetMinStack(){
        dataStack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(Integer val){
        dataStack.push(val);
        if(minStack.empty()){
            minStack.push(val);
        }
        else {
            if(val<=minStack.peek()){
                minStack.push(val);
            }
            else{
                minStack.push(getMin());
            }
        }
    }

    public int pop(){
        minStack.pop();
        return dataStack.pop();

    }

    public int getMin(){
        return minStack.peek();
    }


    public static void main (String args[]) {
        GetMinStack myStack = new GetMinStack();
        myStack.push(5);
        myStack.push(4);
        myStack.push(3);
        myStack.push(5);
        myStack.push(1);
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
    }
}
