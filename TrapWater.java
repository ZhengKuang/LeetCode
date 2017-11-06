/**
 * Created by zhengkuang on 11/4/17.
 */
import java.util.*;
public class TrapWater {
    public static int maxArea(int[] height) {
        int max=Math.min(height[0],height[height.length-1])*(height.length-1);
        int i=0,j=height.length-1;
        while(i<j){
            if(height[i]<height[j]) i++;
            else j--;
            max=Math.max(max,Math.min(height[j],height[i])*(j-i));
        }
        return max;


    }



    public static void main(String args[]){
        int[] a=new int[]{1,2,1};
        System.out.println(maxArea(a));
    }
}
