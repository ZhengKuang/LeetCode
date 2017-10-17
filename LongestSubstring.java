import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhengkuang on 2017/9/6.
 */
public class LongestSubstring {
    public static void LongestSub(){
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });

        queue.add(1);
        queue.add(2);
        queue.add(2);
        queue.add(2);
        queue.add(2);
        queue.add(2);
        ArrayList<List<Integer>> list=new ArrayList<>();

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static void main(String args[]){
        LongestSub();
    }
}
