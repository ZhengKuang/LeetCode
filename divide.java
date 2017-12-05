/**
 * Created by zhengkuang on 12/3/17.
 */
import java.util.*;
public class divide {
    class Node{
        char id;
        public List<Node> neighbor;
        public HashMap<Node,Double> map;
        public Node(char id){
            this.id=id;
            neighbor=new ArrayList<>();
            map=new HashMap<>();
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<Character,Node> map=new HashMap<>();
        HashMap<Character,Boolean> visited=new HashMap<>();
        if(equations==null||values==null||queries==null) return null;
        for(int i=0;i<equations.length;i++){
            char source=equations[i][0].toCharArray()[0];
            char target=equations[i][1].toCharArray()[0];
            if(map.get(source)==null) map.put(source,new Node(source));
            if(map.get(target)==null) map.put(target,new Node(target));
            Node s=map.get(source);
            Node t=map.get(target);
            s.neighbor.add(t);
            t.neighbor.add(s);
            s.map.put(t,values[i]);
            t.map.put(s,1/values[i]);
        }
        double[] ans=new double[queries.length];
        for(int i=0;i<queries.length;i++){
            Node s=map.get(queries[i][0].charAt(0));
            Node t=map.get(queries[i][1].charAt(0));
            if(s==null||t==null) ans[i]=-1.0;
            else {
                for(char c:map.keySet()) visited.put(c,false);
                ans[i]=dfs(s,t,s,visited);
            }
        }
        return ans;
    }

    public double dfs(Node s,Node t,Node cur, HashMap<Character,Boolean> visited){
        if(visited.get(cur)==true) return -1.0;
        visited.put(cur.id,true);
        if(cur==t) return 1.0;
        for(Node nei:cur.neighbor){
            double dis=dfs(s,t,nei,visited);
            if(dis!=-1){
                return cur.map.get(nei)*dis;
            }
        }
        return -1.0;
    }


    public static void main(String args[]){
        String[][] a=new String[][]{{"a","b"},{"b","c"}};
        double[] b=new double[]{2.0,3.0};
        String[][] c=new String[][]{ {"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};
        divide d=new divide();
        d.calcEquation(a,b,c);
    }
}
