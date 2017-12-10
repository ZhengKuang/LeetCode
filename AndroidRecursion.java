/**
 * Created by zhengkuang on 12/10/17.
 */
import java.util.*;
public class AndroidRecursion {
    public static List<List<Integer>> getKey(int[] number, int level){
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<number.length;i++){
            recursive(number,level,i,new ArrayList<Integer>(),ans);
        }
        return ans;
    }

    public static void recursive(int[] number, int level,int curindex, List<Integer> curlist,List<List<Integer>> ans){
        curlist.add(number[curindex]);
        if(curlist.size()==level){
            ans.add(new ArrayList<Integer>(curlist));
            curlist.remove(curlist.size()-1);
            return;
        }
        else{
            for(int i=0;i<number.length;i++){
                recursive(number,level,i,curlist,ans);
            }
        }
        curlist.remove(curlist.size()-1);
        return;

    }

    public static void main(String args[]){
        int[] number=new int[]{1,2,3,4,5,6,7,8,9};
        int level=4;
        List<List<Integer>> ans=getKey(number,level);
       for(List<Integer> tmp:ans){
           System.out.println(Arrays.toString(tmp.toArray()));
       }

    }
}
