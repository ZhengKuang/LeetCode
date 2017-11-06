import java.util.*;

class GenerateParentheses{
    public static List<String> generateParenthesis(int n){
        List<String> answer=new ArrayList<>();
        helper(1,n*2,"",answer,0,0);
        return answer;
    }

    public static void helper(int start, int end, String cur, List<String> answer,int totalleft, int remain){
        if(start==end){
            if(remain==1) answer.add(cur+")");
            return;
        }
        if(totalleft>end/2||remain<0) return;
        helper(start+1,end,cur+")",answer,totalleft,remain-1);
        helper(start+1,end,cur+"(",answer,totalleft+1,remain+1);
        return;
    }

    public static void main(String[] args){
        int n=3;
        System.out.println(Arrays.toString(generateParenthesis(n).toArray()));
    }
}