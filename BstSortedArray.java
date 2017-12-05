import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhengkuang on 12/4/17.
 */
public class BstSortedArray {
    static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value=value;
            left=null;
            right=null;
        }
    }

    public static void inOrder(Node root, ArrayList<Integer> list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.value);
        inOrder(root.right,list);
    }


    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(6);
        root.right=new Node(10);
        root.right.left=new Node(9);
        root.right.right=new Node(11);
        inOrder(root,list);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
