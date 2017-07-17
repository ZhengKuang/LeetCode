public class ArrayToQueue {
    private int first;
    private int size;
    private int last;
    private int iniSize;
    private int[] array;

    public ArrayToQueue(int initSize){
        this.iniSize=initSize;
        array=new int[iniSize];
        first=0;
        last=0;
    }
    public void push(int val){
        if(size==array.length){
            throw new RuntimeException("the size if full!");
        }
        array[last]=val;
        last=last==array.length-1?0:last+1;
        size++;
    }

    public Integer pop(){
        if(size==0){
            throw new RuntimeException("the size is empty, you cannot pop");
        }
        else{
            size--;
            int popInt=first;
            first=first==array.length-1?0:first+1;
            return array[popInt];
        }
    }

    public Integer peek(){
        if(size==0) {
            return null;
        }
        else{
            return array[first];
        }
    }
    public static void main(String args[]){
        ArrayToQueue atq=new ArrayToQueue(5);
        atq.push(0);
        atq.push(1);
        atq.push(2);
        atq.push(3);
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


    }
}
