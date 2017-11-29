/**
 * Created by zhengkuang on 11/29/17.
 */
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class longestPathinTree {
    int count=0;
    class Node{
        public int value;
        public List<Node> kids;
        public int id;
        public int visited;
        public Node(int value,int id){
            kids=new ArrayList<>();
            this.value=value;
            this.id=id;
            visited=0;
        }


    }

    public int solution(int[] A, int[] B){
        if(A==null||B ==null) return 0;
        if(A.length==0||B.length==0) return 0;
        Node[] nodes=new Node[A.length];
        //build the tree
        for(int i=0;i<A.length;i++){
            nodes[i]=new Node(A[i],i+1);
        }
        //get its neighbor
        for(int j=0;j<B.length;j+=2){
            nodes[B[j]].kids.add(nodes[B[j+1]]);
            nodes[B[j+1]].kids.add(nodes[B[j]]);
        }
        int[] gmax=new int[1];
        gmax[0]=0;
        for(int i=0;i<A.length;i++){
            if(nodes[i].visited==0) helper(nodes[i],nodes[i].value,gmax,null);
        }
        return gmax[0];

    }

    public int helper(Node root, int value, int[] gmax, Node pre){
        count++;
        if(root==null) return 0;
        if(root.visited==1) return 0;
 //       System.out.println("Visiting: "+root.id);
        root.visited=1;
        int[] nei=new int[root.kids.size()];
        int biggest=0;
        for(int i=0;i<nei.length;i++){
            if(root.kids.get(i)!=pre) {
                nei[i] = helper(root.kids.get(i), root.value, gmax,root);
            }
        }
        int len=0;
        if(nei.length==0){
            len=0;
        }
        else if(nei.length==1){
            len=nei[0];
            biggest=nei[0];
        }
        else{
            Arrays.sort(nei);
            len=nei[nei.length-1]+nei[nei.length-2];
            biggest=nei[nei.length-1];
        }

        gmax[0]=Math.max(gmax[0],len);
        if(root.value==value){
            return biggest+1;
        }
        else return 0;
    }

    public static void main(String[] args){
        int[] A=new int[]{1,1,1,1,1,1,1,1};
        int[] B=new int[]{7,8,1,2,1,3,1,4,4,5,4,6,5,7};

        int[] val1 = {4, 4, 4, 1, 5, 5};
        int[] edge1 = {0, 1, 2, 1, 1, 3, 3, 4, 4, 5};
        int[] val2 = {0, 4, 2, 2, 4, 4, 1, 4, 4, 4, 4, 4, 4, 3, 3};
        int[] edge2 = {1, 4, 0, 1, 1, 3, 2, 1, 4, 5, 5, 6, 9, 8, 8, 7, 7, 5, 1, 10, 10, 11, 11, 12, 12, 13, 13, 14};
        //2, 5, 1, 2, 2, 4, 3, 2, 5, 6, 6, 7, 10, 9, 9, 8, 8, 6, 2, 11, 11, 12, 12, 13, 13, 14, 14, 15

        int[] val3 = {2, 2, 2, 5, 6, 4, 2, 2, 2, 2, 2, 2};
        int[] edge3 = {7, 8, 7, 9, 10, 11, 9, 10, 7, 2, 2, 1, 1, 0, 7, 3, 3, 4, 7, 6, 6, 5};
        //8, 9, 8, 10, 11, 12, 10, 11, 8, 3, 3, 2, 2, 1, 8, 4, 4, 5, 8, 7, 7, 6

        int[] val4 = {2, 2, 2, 2, 2, 2, 2};
        int[] edge4 = {0, 1, 1, 2, 2, 3, 3, 4, 2, 5, 2, 6};

        longestPathinTree sl=new longestPathinTree();
  //      System.out.println(sl.solution(A,B));
   //     System.out.println("DFS time: "+sl.count);

        System.out.println(sl.solution(val2, edge2));
        System.out.println(sl.solution(val3, edge3));
        System.out.println(sl.solution(val4, edge4));
        System.out.println(sl.solution(val1, edge1));

    }

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List[] adj=new List[numCourses];
            for(int i=0;i<numCourses;i++){
                adj[i]=new ArrayList<Integer>();
            }
            for(int i=0;i<prerequisites.length;i++){
                adj[prerequisites[i][0]].add(prerequisites[i][1]);
            }

            int[] visited=new int[numCourses];

            for(int i=0;i<numCourses;i++){
                if(hasCycle(visited,adj,i,new int[numCourses])) return false;
            }

            return true;
        }

        public boolean hasCycle(int[] visited,List[] adj, int cur, int[] stack ){
            if(visited[cur]==1) return false;

            if(stack[cur]==1) return true;

            stack[cur]=1;

            for(int i=0;i<adj[cur].size();i++){
                Integer u=(Integer) adj[cur].get(i);
                if(hasCycle(visited,adj,u,stack)) return true;
            }

            visited[cur]=1;

            return false;
        }
    }
}
