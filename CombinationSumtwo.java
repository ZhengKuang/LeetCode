/**
 * Created by zhengkuang on 11/4/17.
 */
import java.util.*;
public class CombinationSumtwo {
    public static List<List<Integer>> combinationSum2(int[] a,int target){
        List<List<Integer>> answer=new ArrayList<>();
        if(a==null||a.length==0) return answer;
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            if(i>0&&a[i]==a[i-1]) continue;
            helper(a,target,0,i,new ArrayList<Integer>(),answer);
        }
        return answer;
    }

    public static void helper(int[] a, int target, int cur, int index, List<Integer> curset,List<List<Integer>> answer){
        curset.add(a[index]);
        cur+=a[index];
        if(cur==target){
            ArrayList<Integer> list=new ArrayList<>(curset);
            answer.add(list);
            curset.remove(curset.size()-1);
            return;
        }
        if(index==a.length-1||cur>target){
            curset.remove(curset.size()-1);
            return;
        }
        for(int i=index+1;i<a.length;i++){
            if(i>index+1&&a[i]==a[i-1]) continue;
            helper(a,target,cur,i,curset,answer);
        }
        curset.remove(curset.size()-1);
        return;
    }
    public static void main(String args[]){
        int[] a=new int[]{2,2,2,2,2,2,2};
        int target=4;
        System.out.println(Arrays.toString(combinationSum2(a,target).toArray()));
    }

}
