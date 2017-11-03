import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by zhengkuang on 10/16/17.
 */
public class CanPrtitionK {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        boolean[] visited = new boolean[nums.length];
       // return dfs(k, sum / k, 0, sum / k, visited, nums);
        return dfs2(0,nums,visited,sum/k,sum/k,k);
    }

    public boolean dfs(int k, int target, int begin, int needMore, boolean[] visited, int[] nums) {
        if (visited[begin] == false) {
            visited[begin] = true;
            if (needMore-nums[begin] == 0) {
                if (k == 1) return true;
                for(int i=0;i<visited.length;i++){
                    if(visited[i]==false) return dfs(k - 1, target, i, target, visited, nums);
                }
            }
            for (int i = begin + 1; i < nums.length; i++) {
                if (dfs(k, target, i, needMore - nums[begin], visited, nums) == true) return true;
            }
            visited[begin] = false;
        }
        return false;
    }

    public boolean dfs2(int start, int[] nums,boolean[] visited, int target, int current, int k){
        if(visited[start]==false){
            visited[start]=true;
            if(current-nums[start]==0){
                if(k==1) return true;
                for(int i=0;i<visited.length;i++){
                    if(visited[i]==false) {
                        if(dfs2(i,nums,visited,target,target,k-1)==true){
                            return true;
                        }
                        else{
                            visited[start]=false;
                            return false;
                        }
                    }
                }
            }
            for(int i=start+1;i<nums.length;i++){
                if(dfs2(i,nums,visited,target,current-nums[start],k)==true) return true;
            }
            visited[start]=false;
        }
        return false;
    }

    public boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum = 0;
        for(int num:nums)sum += num;
        if(k <= 0 || sum%k != 0)return false;
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum/k);
    }

    public boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target){
        if(k==1)return true;
        if(cur_sum == target && cur_num>0)return canPartition(nums, visited, 0, k-1, 0, 0, target);
        for(int i = start_index; i<nums.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if(canPartition(nums, visited, i+1, k, cur_sum + nums[i], cur_num++, target))return true;
                visited[i] = 0;
            }
        }
        return false;
    }

    public static String route(String s, int numRows){
        //0 down
        //1 diagnal->left up
        int i=0,j=0;
        int index=0;
        char[][] map=new char[numRows][s.length()];
        while(index<s.length()){
            while(i!=map.length&&index<s.length()){
                map[i][j]=s.charAt(index);
                index++;
                i++;
            }
            i=i-1;
            j=j+1;
            while(i!=0&&index<s.length()){
                map[i][j]=s.charAt(index);
                index++;
                i--;
                j++;
            }
        }
        String result="";
        for(int k=0;k<map.length;k++){
            for(int m=0;m<map[0].length;m++){
                if(map[k][m]!='\u0000') result=result+Character.toString(map[k][m]);
            }
        }
        return result;
    }

    public static void main(String args[]) {
    //    int[] array = new int[]{2,2,10,5,2,7,2,2,13};
    //    StringBuilder sb=new StringBuilder(""
    //    );
    //    sb.ap
    //    int k = 3;
       // CanPrtitionK cpk = new CanPrtitionK();
    //    char[][] a=new char[2][2];
    //    String test="PAYPALISHIRING";
    //    route(test,3);
     //   int b=2;
        char a='a';
        a=(char)((int)(a)+1);
 //       System.out.print(a);
        System.out.println(Integer.toBinaryString(2));
    }
}
