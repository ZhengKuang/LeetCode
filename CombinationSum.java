import java.util.*;

class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer=new ArrayList<>();
        if(candidates==null||candidates.length==0) return answer;
        for(int i=0;i<candidates.length;i++){
            helper(candidates,0,i,answer,new ArrayList<Integer>(),target);
        }
        return answer;
    }

    public static void helper(int[] nums, int cur, int index, List<List<Integer>> answer, List<Integer> curset,int target){
        cur=cur+nums[index];
        curset.add(nums[index]);
        if(cur==target){
            List<Integer> copy=new ArrayList<>(curset);
            answer.add(copy);
            curset.remove(curset.size()-1);
            return;
        }
        else if(cur>target){
            curset.remove(curset.size()-1);
            return;
        }
        else{
            for(int i=index;i<nums.length;i++){
                helper(nums,cur,i,answer,curset,target);
            }
        }
        curset.remove(curset.size()-1);
        return;
    }

    public static void main(String args[]){
        int[] a = new int[]{1,2};
        int target=3;
        System.out.println(Arrays.toString(combinationSum(a,target).toArray()));
    }

}