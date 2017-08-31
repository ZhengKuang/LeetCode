import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ValidHeap {
    public static class Node{
        Node left;
        Node right;
        int value;
        public Node(){
            right=null;
            left=null;
            this.value=-1;
        }
    }
    public static boolean isminHeap(Node root){
        if(root==null) return true;
        if(root.left!=null&&root.value>root.left.value) return false;
        if(root.right!=null&&root.value>root.right.value) return false;
        return isminHeap(root.left)==true&&isminHeap(root.right)==true;
    }

    public static int findMax(Node root, int value){
        if(root==null) return -1;
        root.value=value;
        if(root.left==null&&root.right==null) return root.value;
        return Math.max(findMax(root.left,2*value+1),findMax(root.right,2*value+2));
    }

    public static int getNumber(Node root){
        if(root==null) return 0;
        return 1+getNumber(root.left)+getNumber(root.right);
    }

    public static boolean validHeap(Node root){
        System.out.println(isminHeap(root)+" "+findMax(root,0)+" "+getNumber(root));
        return isminHeap(root)==true&&findMax(root,0)+1==getNumber(root);
    }

    public static void main(String args[]) throws FileNotFoundException{
        Scanner sc=new Scanner(new File("ValidHeap.txt"));
        int n=sc.nextInt();
        while(n!=-1){
            Node[] nodes=new Node[n];
            for(int i=0;i<n;i++){
                nodes[i]=new Node();
            }
            for(int i=0;i<n;i++){
                int root=sc.nextInt();
                int left=sc.nextInt();
                int right=sc.nextInt();
                if(left!=-1) nodes[root].left=nodes[left];
                if(right!=-1) nodes[root].right=nodes[right];

            }
            System.out.println(validHeap(nodes[0]));
            n=sc.nextInt();
        }
    }
}
