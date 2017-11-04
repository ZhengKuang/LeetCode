import java.util.*;

class FourSum{
    public static List<List<Integer>> fourSum(int[]nums, int target){
        List<List<Integer>> answer=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;){
            for(int j=i+1;j<nums.length-2;) {
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum < target) m++;
                    else if (sum > target) n--;
                    else {
                        answer.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[m], nums[n])));
                        int k = m + 1;
                        while(k < n && nums[k] == nums[m]) k++;
                        m = k;
                    }
                }
                int tmp = j + 1;
                while (tmp < nums.length - 2 && nums[tmp] == nums[j]) tmp++;
                j = tmp;
            }
            int tmpi=i+1;
            while(tmpi<nums.length-3&&nums[tmpi]==nums[i]) tmpi++;
            i=tmpi;
        }
        return answer;
    }

    public static void main(String args[]){
        int[] nums=new int[]{1,0,0,2,-1,-2};
        int target=0;
        System.out.println(Arrays.toString(fourSum(nums,target).toArray()));
    }

}


