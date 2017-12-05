import java.util.HashSet;
import java.util.Stack;

/**
 * Created by zhengkuang on 12/5/17.
 */
public class BinaryTreeBadEdge {
    static class Node{
        public Node left;
        public Node right;
        public int id;
        public Node(int id){
            this.id=id;
            left=null;
            right=null;
        }
    }

    public static boolean hasBadEdge(Node root){
        if(root==null) return false;
        HashSet<Node> visited=new HashSet<>();
        Stack<Node> stack=new Stack<>();
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }
            else{
                root=stack.pop();
                System.out.println("visiting: "+ root.id);
                if(visited.contains(root)) return true;
                visited.add(root);

                //Do something
                root=root.right;
            }
        }
        return false;
    }




    public static void main(String[] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(4);
        root.left.left=new Node(3);
        root.left.right=root.right;
        System.out.println(hasBadEdge(root));

    }
}
