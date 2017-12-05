import java.util.*;

public class ShortedCycle {
    static class Node{
        public List<Node> neighbors;
        public int id;
        public Node(int id){
            this.id=id;
            neighbors=new ArrayList<>();
        }
    }

    public static ArrayList<Integer> shortestCycle(Node root){
        Queue<Node> queue=new LinkedList<>();
        HashSet<Node> visited=new HashSet<>();
        HashMap<Node,Node> premap=new HashMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        queue.add(root);
        premap.put(root,null);
        while(!queue.isEmpty()){
            Node tmp=queue.poll();
            visited.add(tmp);
            for(Node nei:tmp.neighbors){
                if(visited.contains(nei)){
                    while(premap.get(tmp)!=null){
                        ans.add(tmp.id);
                        tmp=premap.get(tmp);
                    }
                    ans.add(root.id);
                    return ans;
                }
                queue.offer(nei);
                if(nei!=root) premap.put(nei,tmp);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Node root=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        root.neighbors.add(n2);
        root.neighbors.add(n5);
        n2.neighbors.add(n3);
        n3.neighbors.add(n4);
        n4.neighbors.add(root);
        n5.neighbors.add(n6);
        n6.neighbors.add(root);
        System.out.println(shortestCycle(root));
    }
}
