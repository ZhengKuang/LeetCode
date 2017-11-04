import java.util.*;

class ThreeSumClosest{
    public static int threeSumClosest (int[] nums, int target) throws Exception{
        int dif=Integer.MAX_VALUE;
        int sum=0;
        if(nums==null||nums.length==0) throw new Exception("the array is null or empty!");
        Arrays.sort(nums);
        for(int k=0;k<nums.length;k++){
            int aim=target-nums[k];
            int i=k+1;
            int j=nums.length-1;
            while(i<j){
                int curSum=nums[i]+nums[j];
                int curdif=Math.abs(aim-curSum);
                if(curdif<=dif){
                    sum=nums[i]+nums[j]+nums[k];
                    dif=curdif;
                }
                if(curSum<aim) i++;
                if(curSum>aim) j--;
                if(curSum==aim) return nums[i]+nums[j]+nums[k];
            }
        }
        return sum;
    }

    public static void main (String args[]) throws Exception{
      //  ArrayList<Integer> list=new ArrayList<Integer>(new int[]{1,2,3});
        int[] nums=new int[]{0,1,2};
        int target=3;
        System.out.println(threeSumClosest(nums,target));
    }
}