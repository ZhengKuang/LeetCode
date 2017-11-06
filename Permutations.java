import java.util.*;

class Permutations{
    public static List<List<Integer>> permute(int[] nums){
        int[] visited=new int[nums.length];
        List<List<Integer>> answer=new ArrayList<>();
        helper(0,nums.length,visited,nums,new ArrayList<Integer>(),answer);
        return answer;

    }

    public static void helper(int curlen, int targetlen,int[] visited, int[] nums,List<Integer> curset, List<List<Integer>> answer){
        if(curlen==targetlen){
            answer.add(new ArrayList<Integer>(curset));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==1) continue;
            visited[i]=1;
            curset.add(nums[i]);
            helper(curlen+1,targetlen,visited,nums,curset,answer);
            curset.remove(curset.size()-1);
            visited[i]=0;
        }
        return;
    }

    public static void main(String[] args){
        int[] n=new int[]{1,2,3};
        System.out.println(Arrays.toString(permute(n).toArray()));
    }
}
