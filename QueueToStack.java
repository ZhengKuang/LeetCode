import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public QueueToStack(){
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }
    public void push(int i){
        if(!queue1.isEmpty()){
            queue1.add(i);
        }
        else{
            queue2.add(i);
        }
    }

//    public Integer peek(){
//
//    }

    public Integer pop(){
        if(queue1.isEmpty()&&queue2.isEmpty()) throw new RuntimeException("stack is empty!");
        if(!queue1.isEmpty()){
            while(queue1.size()!=1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        else{
            while(queue2.size()!=1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    public static void main (String args[]){
        QueueToStack stq=new QueueToStack();
        stq.push(0);
        stq.push(1);
        stq.push(2);
        stq.push(3);
        stq.push(4);
        System.out.println(stq.pop());
        System.out.println(stq.pop());
        System.out.println(stq.pop());
        System.out.println(stq.pop());
        System.out.println(stq.pop());
        stq.push(5);
        System.out.println(stq.pop());
    }
}
