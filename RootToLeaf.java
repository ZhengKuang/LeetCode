import java.util.*;
/*
      1
    2   3
  4. 6

 5

*/
public class RootToLeaf{

    static class Node{
        Node left;
        Node right;
        int val;
        public Node(int val){
            this.val=val;
        }
    }

    public static List<List<Integer>> findAllPath(Node root){
        List<List<Integer>> answer=new ArrayList<>();
        if(root==null) return answer;
        backTrack(root,answer,new ArrayList<Integer>());
        return answer;
    }

    public static void backTrack(Node node, List<List<Integer>> answer, List<Integer> cur){
        if(node.left==null&&node.right==null){
            cur.add(node.val);
            answer.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size()-1);
            return;
        }
        cur.add(node.val);
        if(node.left!=null){
            backTrack(node.left,answer,cur);
        }
        if(node.right!=null){
            backTrack(node.right,answer,cur);
        }
        cur.remove(cur.size()-1);
        return;
    }



    public static void main(String args[]){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(6);
        root.left.left.left=new Node(5);
        System.out.println(Arrays.toString(findAllPath(root).toArray()));
    }


}


