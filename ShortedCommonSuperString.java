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
        String[] list=new String[]{"AAA","AAB","ABA","ABB","BAA","BAB","BBA","BBB"};
        System.out.println(scs(list));
        System.out.println(scs(list).length());
    }
}
