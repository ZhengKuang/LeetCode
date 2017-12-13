import java.util.*;

/**
 * Created by zhengkuang on 12/10/17.
 */
public class ShortedCommonSuperString {
    public static String scs(String[] strs){
        int[] array=new int[strs.length];
        for(int i=0;i<array.length;i++) array[i]=i;
        List<List<Integer>> pm=permulation(array);
        int best=Integer.MAX_VALUE;
        String bestString="";
        for(int i=0;i<pm.size();i++){
            List<Integer> tmplist=pm.get(i);
            StringBuilder sb=new StringBuilder("");
            for(int j=0;j<tmplist.size();j++){
                String c=strs[tmplist.get(j)];
                if(j==0){
                    sb=sb.append(c);
                    continue;
                }
                else{
                    int length=c.length();
                    while(length>0){
                        String s1=sb.substring(sb.length()-length);
                        String s2=c.substring(0,length);
                        if(s1.equals(s2)) break;
                        length--;
                    }
                    sb.append(c.substring(length));
                }
            }
            String comstr=sb.toString();
            if(comstr.length()<best){
                bestString=comstr;
                best=comstr.length();
            }
        }
        return bestString;



    }

    public static List<List<Integer>> permulation(int[] array){
        List<List<Integer>> ans=new ArrayList<>();
        for(int i:array){
            recursive(new boolean[array.length],i,ans,new ArrayList<Integer>(),array);
        }
        return ans;
    }

    public static int lengthOfLongestSubstringKDistinct(String str, int k) {
        if (str == null || str.isEmpty() || k == 0) return 0;
        TreeMap<Integer, Character> lastOccurrence = new TreeMap<>();
        Map<Character, Integer> inWindow = new HashMap<>();
        int j = 0, max = 1;
        for (int i = 0; i < str.length(); i++) {
            char in = str.charAt(i);
            //update or add in's position in both maps
            if (inWindow.containsKey(in)) {
                lastOccurrence.remove(inWindow.get(in));
            }
            inWindow.put(in, i);
            lastOccurrence.put(i, in);
            // make sure the size satisfies the requirement
            if (inWindow.size() > k) {
                int first = lastOccurrence.firstKey();
                char out = lastOccurrence.get(first);
                inWindow.remove(out);
                lastOccurrence.remove(first);
                j = first + 1;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void recursive(boolean[] visited, int index, List<List<Integer>> ans, List<Integer> curList,int[] array){
        if(visited[index]) return;
        visited[index]=true;
        curList.add(array[index]);
        if(curList.size()==array.length){
            ans.add(new ArrayList<>(curList));
            curList.remove(curList.size()-1);
            visited[index]=false;
            return;
        }
        else{
            for(int i=0;i<array.length;i++) recursive(visited,i,ans,curList,array);
        }
        curList.remove(curList.size()-1);
        visited[index]=false;
        return;
    }




    public static void main(String args[]){
    //    String[] list=new String[]{"AAA","AAB","ABA","ABB","BAA","BAB","BBA","BBB"};
    //    System.out.println(scs(list));
    //    System.out.println(scs(list).length());
        ShortedCommonSuperString sc=new ShortedCommonSuperString();
        System.out.println(lengthOfLongestSubstringKDistinct("abaccc",2));
    }
}
