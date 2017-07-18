import java.util.Stack;

public class StackInvert {
    public Stack invertStack(Stack<Integer> a){
        Integer myint=getAndRemoveFirstElement(a);
        if(myint==null){
            return a;
        }
        invertStack(a);
        a.push(myint);
        return a;
    }

    public Integer getAndRemoveFirstElement(Stack<Integer> a){
        if(a.empty()) return null;
        int element=a.pop();
        Integer first=getAndRemoveFirstElement(a);
        if(first==null){
            return element;
        }
        a.push(element);
        return first;

    }

    public static void main (String args[]){
        Stack<Integer> myStack=new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        StackInvert si=new StackInvert();
        Stack<Integer> a=si.invertStack(myStack);
    }
}