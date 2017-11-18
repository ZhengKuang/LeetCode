import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhengkuang on 11/11/17.
 */
public class MaxCoin{
    public int maxCoins(int[] nums){
        if(nums==null||nums.length==1) return nums[0];
        int[][] dp=new int[nums.length][nums.length];
        for(int len=1;len<=nums.length;len++){
            for(int start=0;start+len-1<nums.length;start++){
                int end=start+len-1;
                for(int i=start;i<=end;i++){
                    int last=nums[i];
                    int left=i==start?0:dp[start][i-1];
                    int right=i==end?0:dp[i+1][end];
                    int a=start-1==-1?1:nums[start-1];
                    int b=end+1==nums.length?1:nums[end+1];
                    int sum=last*a*b+left+right;
                    dp[start][end]=Math.max(dp[start][end],sum);
                }
            }
        }
        Set<String> e=new HashSet<>();
        e.add("hello");
        for(String s:e){
            System.out.print(s);
        }
        return dp[0][nums.length-1];

    }

    public static void main(String args[]){
        int[] nums=new int[]{3,1,5,8};
        MaxCoin mx=new MaxCoin();
        System.out.println("dog".substring(1));
        System.out.println(mx.maxCoins(nums));
    }
}
