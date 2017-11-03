import java.util.*;

import java.util.*;

/**
 * Created by zhengkuang on 2017/9/6.
 */
public class LongestSubstring {
    public static void LongestSub(){
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(2,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });

        queue.add(1);
        queue.add(2);
        queue.add(2);
        queue.add(2);
        queue.add(2);
        queue.add(2);
        ArrayList<List<Integer>> list=new ArrayList<>();
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static int minimumDeleteSum(String s1, String s2) {
        if(s1==null||s2==null) return -1;
        int m=s1.length();
        int n=s2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0||j==0){
                    int a=0;
                    for(int k=1;k<=Math.max(i,j);k++) a=i==0?s2.charAt(k-1):s1.charAt(k-1);
                    dp[i][j]=a;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else{
                    int answer=Integer.MAX_VALUE;
                    answer=Math.min(dp[i-1][j]+s1.charAt(i-1),dp[i][j-1]+s2.charAt(j-1));
                    answer=Math.min(dp[i-1][j-1]+s1.charAt(i-1)+s2.charAt(j-1),answer);
                    dp[i][j]=answer;
                }
            }
        }
        return dp[m][n];
    }

    public static String  numberToWords(int num) {
        String answer="";
        String sign="";
        if(num==0) return "Zero";
        String[] oneD=new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        String[] twoD=new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] ty=new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] threeD=new String[]{"","One Hundred","Two Hundred","Three Hundred","Four Hundred","Five Hundred","Six Hundred","Seven Hundred","Eight Hundred","Nine Hundred"};
        String[] tbm=new String[]{"","","","","Thousand","","","Million","","","Billion"};
        Stack<Character> stack=new Stack<>();
        for(char c:String.valueOf(num).toCharArray()){
            if(c=='-'||c=='+') {
                sign=(c=='+'?"":"Negative");
                continue;
            }
            stack.push(c);
        }
        int digits=1;
        while(!stack.isEmpty()){
            if(!tbm[digits].equals("")) answer=tbm[digits]+" "+answer;
            int pre=-1;
            if(!stack.isEmpty()){
                int index=Character.getNumericValue(stack.pop());
                pre=index;
                answer=oneD[index].equals("")?answer:oneD[index]+" "+answer;
                digits++;
                System.out.println("the answer now is:"+answer);
            }
            if(!stack.isEmpty()){
                int index=Character.getNumericValue(stack.pop());
                if(index==1) {
                    int length=oneD[pre].length();
                    answer=answer.substring(length,answer.length());
                    answer=twoD[pre]+" "+answer;
                }
                else answer=ty[index].equals("")?answer:ty[index]+" "+answer;
                digits++;
            }
            if(!stack.isEmpty()){
                int index=Character.getNumericValue(stack.pop());
                answer=threeD[index].equals("")?answer:threeD[index]+" "+answer;
                digits++;
            }
        }
        answer=answer.trim();
        String[] results=answer.split(" ");
        List<String> list=new ArrayList<String>();
        for(String s:results){
            if(!(s.equals(" ")||s.equals(""))) list.add(s);
        }
        helper(list);
        return sign==""?answer:sign+" "+answer;
    }

    public static void helper(List<String> list){
        for(int i=0;i<list.size()-1;i++){
            String s1=list.get(i);
            String s2=list.get(i+1);
            if((s1.equals("Billion")&&s2.equals("Million"))||(s1.equals("Billion")&&s2.equals("Thousand"))||(s1.equals("Million")&&s2.equals("Thousand"))) {
                list.remove(i + 1);
                i--;
            }
        }
    }

    static class  Solution {
        public List<String> addOperators(String num, int target) {
            if(num==null||num.length()==0||num.equals("")) return new ArrayList<String>();
            List<String> answer=new ArrayList<String>();
            BFS(target,answer,"",0,0,1,num);
            return answer;
        }

        public void BFS(long target, List<String> answer, String path, int pos, long eval,long mul,String str){
            if(pos==str.length()){
                if(eval==target){
                    answer.add(path);
                }
                return;
            }
            else{
                for(int i=pos;i<str.length();i++){
                    long num=Long.parseLong(str.substring(pos,i+1));
                    if(pos==0){
                        BFS(target,answer,num+path,i+1,num,num,str);
                    }
                    else {
                        //+
                        long value = mul;
                        BFS(target, answer, path + "+" + num, pos + 1, eval + num, num, str);
                        //-
                        BFS(target, answer, path + "-" + num, pos + 1, eval - num, num, str);
                        //*
                        BFS(target, answer, path + "*" + num, pos + 1, eval -mul + mul * num, mul * num, str);
                    }
                }
            }
        }

    }
 /*
        public List<String> addOperators(String num, int target) {
            if(num==null||num.length()==0||num.equals("")) return new ArrayList<String>();
            List<String> answer=new ArrayList<String>();
            BFS(target,answer,"",0,num);
            return answer;
        }

        public void BFS(long target, List<String> answer, String path, int pos, String str){
            long num=Long.parseLong(str.substring(pos,pos+1));
            if(pos==str.length()-1){
                if(num==target){
                    answer.add(path+num);
                }
                return;
            }
            else{
                //+
                BFS(target-num,answer,path+num+"+",pos+1,str);
                //-
                BFS(target+num,answer,path+num+"-",pos+1,str);
                //*
                BFS(target/num,answer,path+num+"*",pos+1,str);
            }
        }
*/


    public static void main(String args[]){
        String[] split="2\t12796\t74".split("\\t");
        List<String> list=new ArrayList<>();
        list.add("1");
        String a=list.remove(0);
        System.out.println((int)'s');
        System.out.println((int)'e');
        System.out.println((int)'a');
        System.out.println(Integer.MAX_VALUE);
        System.out.println(minimumDeleteSum("sea","eat"));
        Solution s=new Solution();
        s.addOperators("105",5);
        numberToWords(1000000000);
    }
}