public class ArrayToQueue {
    private int index;
    private int size;
    private int iniSize;
    private int[] array;

    public ArrayToQueue(int initSize){
        this.iniSize=initSize;
        array=new int[iniSize];
    }
    public void push(int val){
        int value=size+1;
        if(iniSize-value<0){
            throw new RuntimeException("the size if full!");
        }
        array[(index+size)%iniSize]=val;
        size++;
    }

    public Integer pop(){
        int value=size-1;
        if(value<0){
            throw new RuntimeException("the size is empty, you cannot pop");
        }
        else{
            size--;
            int popInt=index;
            index=(index+1)%iniSize;
            return array[popInt];
        }
    }

    public Integer peek(){
        int value=size;
        if(value==0) {
            return null;
        }
        else{
            return array[index];
        }
    }
    public static void main(String args[]){
        ArrayToQueue atq=new ArrayToQueue(5);
        atq.push(0);
        atq.push(1);
        atq.push(2);
        atq.push(3);
        atq.push(4);
        atq.push(4);
        System.out.println(atq.pop());
        System.out.println(atq.peek());
        System.out.println(atq.pop());
        System.out.println(atq.pop());
        System.out.println(atq.pop());
        System.out.println(atq.pop());
        atq.push(5);
        System.out.println(atq.peek());
        System.out.println(atq.pop());
        System.out.println(atq.pop());


    }
}
