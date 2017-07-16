import java.util.ArrayList;

public class ArrayToStack {
    int MAXSIZE = 15;
    int[] array;
    int index;

    public ArrayToStack(){
        array= new int[MAXSIZE];
        index=-1;
    }

    public Integer pop(){
        if(index<0){
            throw new RuntimeException("stack is empty!");
        }
        return array[index--];
    }
    public void push(int val){
        array[++index]=val;
    }
    public Integer peek(){
        if(index<0){
            return null;
        }
        return array[index];
    }
    public static void main(String args[]) {
        ArrayToStack ats=new ArrayToStack();
        ats.push(1);
        ats.push(2);
        ats.push(3);
        ats.push(4);
        System.out.println(ats.pop());
        System.out.println(ats.pop());
        System.out.println(ats.pop());
        System.out.println(ats.pop());
        System.out.println(ats.peek());

    }
}
