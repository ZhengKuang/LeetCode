import java.util.*;

/**
 * Created by zhengkuang on 12/5/17.
 */
public class GraphKeyDoor {
    static class Node{
        public List<Node> neighbors;
        public int id;
        public boolean treasure;
        public String key=null;
        public Node(int id,boolean treasure,String key){
            this.id=id;
            this.treasure=treasure;
            this.key=key;
            this.neighbors=new ArrayList<>();
        }
    }

    public static boolean hasTreasure(Node root,HashSet<String> allKey){
        HashSet<Node> curset=new HashSet<>();
        HashSet<String> keySet=new HashSet<>();
        boolean update=true;
        boolean[] hasTreasure=new boolean[1];
        hasTreasure[0]=false;
        int pre=-1;
        while(curset.size()!=pre){
            pre=curset.size();
            dfs(curset,hasTreasure,keySet,allKey,root,new HashSet<Node>());
            if(hasTreasure[0]) return true;
        }
        return false;
    }

    public static void dfs(HashSet<Node> curset,boolean[] hasTreasure, HashSet<String> curkey,HashSet<String> allKey, Node cur, HashSet<Node> visited){
        if(visited.contains(cur)) return;
        visited.add(cur);
        curset.add(cur);
        if(cur.key!=null&&!curkey.contains(cur.key)) curkey.add(cur.key);
        if(cur.treasure){
            hasTreasure[0]=true;
            return;
        }
        boolean update=false;
        for(Node nei:cur.neighbors){
            String key=cur.id+","+nei.id;
            if(allKey.contains(key)&&curkey.contains(key)) {
                dfs(curset,hasTreasure,curkey,allKey,nei,visited);


            }
            if(!allKey.contains(key)) {
                dfs(curset,hasTreasure,curkey,allKey,nei,visited);
            }
        }
    }

    public static void main(String[] args){
        Node root=new Node(1,false,"1,2");
        Node n2=new Node(2,false,"2,4");
        Node n3=new Node(3,true,null);
        Node n4=new Node(4,false,null);
        Node n5=new Node(5,false,null);
        String[] set=new String[]{"1,2","2,4","4,3"};
        HashSet<String> allKey=new HashSet<>(Arrays.asList(set));
        root.neighbors.add(n2);
        root.neighbors.add(n5);
        n2.neighbors.add(n4);
        n4.neighbors.add(n3);
        System.out.println(hasTreasure(root,allKey));

    }
}
