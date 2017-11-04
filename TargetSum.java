import java.util.*;
/**
 * Created by zhengkuang on 11/2/17.
 */
public class TargetSum {
    public static List<String> targetSum(String input,int target){
        if(input==null||input.length()==0){

        }
        ArrayList<String> list=new ArrayList<>();
        helper("",list,0,target,0,1,input);
        return list;
    }

    public static void helper(String cur,List<String> answer, int sum, int target, int index,int multiply,String str){
        if(index==str.length()){
            if(target==sum) answer.add(cur);
            return;
        }
        if(index==0){
            for(int i=index+1;i<str.length();i++){
                int number=Integer.valueOf(str.substring(index,i));
                helper(cur+number,answer,number,target,i,i,str);
            }
        }
        else if(str.charAt(index)=='0') {
            helper(cur + "+" + 0, answer, sum + 0, target, index+1,0, str);
            helper(cur + "-" + 0, answer, sum - 0, target, index+1, 0,str);
            helper(cur + "*" + 0, answer, sum * 0, target, index+1, 0,str);
        }
         else {
                for(int i=index+1;i<=str.length();i++){
                    int number=Integer.valueOf(str.substring(index,i));
                    helper(cur + "+" + number, answer, sum + number, target, i,number, str);
                    helper(cur + "-" + number, answer, sum - number, target, i,-number,str);
                    helper(cur + "*" + number, answer, sum -multiply+multiply*number, target, i, multiply*number,str);
                }
        }
    }



    public static void main(String args[]){
        String s ="105";
        int target=5;
        List<String> answer=targetSum(s,target);
        System.out.println(Arrays.toString(answer.toArray()));
    }
}
