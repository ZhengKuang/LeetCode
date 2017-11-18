import java.util.*;

class WordBreak2{
    public List<String> wordBreak(String s,List<String> wordDict){
        HashSet<String> set=new HashSet<>(wordDict);
        return helper(s,set,new HashMap<String, List<String>>());
    }

    //sanddog
    public List<String> helper(String s, Set<String> set,Map<String,List<String>> memo){
        if(memo.containsKey(s)){
            return memo.get(s);
        }

        List<String> ans=new ArrayList<String>();

        if(s.equals("")){
            ans.add("");
            return ans;
        }

        for(String tmp:set){
            if(s.startsWith(tmp)){
                int n=tmp.length();
                List<String> next=helper(s.substring(n),set,memo); //tmp-> sand. next->["dog","d og"]
                for(String a:next){
                    if(a.equals("")) ans.add(tmp);   //ans->["sand dog","sand d og"]
                    else ans.add(tmp+" "+a);
                }
            }
            else{
                continue;
            }
        }
        memo.put(s,ans);
        return ans;

    }
    public static String minWindow(String S, String T) {
        String output = "";
        int minLen = 20001;
        for (int i = 0; i <= S.length() - T.length(); i++) {
            while (i < S.length() && S.charAt(i) != T.charAt(0)) {
                i++;
            }
            int l = find(S.substring(i, Math.min(i + minLen, S.length())), T);
            if (l != -1 && l < minLen) {
                minLen = l;
                output = S.substring(i, i + l);
            }
        }
        return output;
    }


    private static int find(String S, String T) {
        for (int i = 0, j = 0; i < S.length() && j < T.length();) {
            if (S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
                if (j == T.length()) {
                    return i;
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public static String dpminWindow(String S, String T) {
        if(S==null||T==null) return "";
        int[][] dp=new int[T.length()][S.length()];
        int same=1;
        for(int i=0;i<dp.length;i++){
            same=1;
            for(int j=0;j<dp[0].length;j++){
                if(i==0){
                    if(S.charAt(j)==T.charAt(i)){
                        dp[i][j]=1;
                    }
                    else{
                        if(j==0) dp[i][j]=0;
                        else dp[i][j]=dp[i][j-1]==0?0:dp[i][j-1]+1;
                    }
                }
                else{
                    if(S.charAt(j)==T.charAt(i)){
                        if(T.charAt(i)==T.charAt(i-1)&&same==1){
                            same--;
                            dp[i][j]=0;
                        }
                        else if(T.charAt(i)==T.charAt(i-1)&&same==0) dp[i][j]=dp[i-1][j-1]+1;
                        else dp[i][j]=dp[i-1][j];
                    }
                    else{
                        if(j==0) dp[i][j]=0;
                        else dp[i][j]=dp[i][j-1]==0?0:dp[i][j-1]+1;
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        String out="";
        for(int j=0;j<S.length();j++){
            if(dp[T.length()-1][j]!=0&&dp[T.length()-1][j]<min){
                min=dp[T.length()-1][j];
                out=S.substring(j+1-min,j+1);
            }
        }
        return out;
    }
//"fweekpamjwqobhxiesgzivminqqjjkgnhkdxpfjvvgfcdlgwvwtdwizpjcuwnwpioxcshyjglqjnkluedopzyhozjzqnjentspwffoawwbgyhrrapncwetqulmaupkkwugkpfztgejujlakrnkvefbvncfzhhmciztzjzrzrzlcfkejmlkhlogtraexhgrvxitcnaacegjrkwbseomwvdawsymemhsvtqcpbfvinhngdvhnrswwgoff"
//        "qkkwtlzbbn"
    public static void main(String args[]){
        System.out.println(dpminWindow("qkkkkwwtlzbbn","qkkwtlzbbn"));
        String s="catsanddog";
        StringBuilder sb=new StringBuilder();
        String[] list=new String[]{"cat","cats","sand","and","dog"};
        List<String> al=new ArrayList<>(Arrays.asList(list));
        WordBreak2 wb=new WordBreak2();
        List<String> check=wb.wordBreak(s,al);
        System.out.println(check.toString());

    }
}