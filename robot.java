/**
 * Created by zhengkuang on 11/29/17.
 */
import java.util.*;
public class robot {
    public class Node{
        public int id;
        List<Node> nei;

        public Node(int id){
            this.id=id;
            nei=new ArrayList<Node>();
        }
    }

//[1,2] first 1 then 2
    public void printOrder(int numParts, int[][] order){
        Node[] nodes=new Node[numParts];
        for(int i=0;i<numParts;i++){
            nodes[i]=new Node(i);
        }
        for(int i=0;i<order.length;i++){
            nodes[order[i][0]].nei.add(nodes[order[i][1]]);
        }

        boolean[] visited=new boolean[numParts];
        Stack<Node> stack=new Stack<>();


        for(int i=0;i<numParts;i++){
            visit(nodes[i],visited,stack);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().id);
        }

    }

    public void visit(Node node,boolean[] visited, Stack<Node> stack){
        if(visited[node.id]) return;

        visited[node.id]=true;

        for(int i=0;i<node.nei.size();i++){
            visit(node.nei.get(i),visited,stack);
        }

        stack.push(node);

    }

    public static void main(String args[]){
        robot rb=new robot();
        int numParts=6;
        int[][] order=new int[][]{{0,2},{1,2},{2,4},{3,4},{4,5}};
        rb.printOrder(numParts,order);
        System.out.println();
        System.out.println(1.0/6.0);
    }
}
