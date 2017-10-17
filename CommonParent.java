import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class CommonParent {
    public static class Tree{
        int value;
        Tree left;
        Tree right;
        public Tree(int value){
            this.value=value;
            left=null;
            right=null;
        }
    }

    public static Tree findCommon(Tree a, Tree b, Tree root){
        if(root==a) return root;
        if(root==b) return root;
        if(root==null) return null;

        Tree node1=findCommon(a,b,root.left);
        Tree node2=findCommon(a,b,root.right);

        if(node1!=null&&node2!=null) return root;
        if(node1==null&&node2!=null) return root.right;
        if(node1!=null&&node2==null) return root.left;
        return null;
    }


    public CommonParent() {
    }

    public static void main(String args[]) throws FileNotFoundException{
        Scanner sc=new Scanner(new File("CommonParent.txt"));
        int n=sc.nextInt();
        Tree[] trees=new Tree[n];
        while(n!=-1) {
            for(int i=0;i<n;i++){
                trees[i] = new Tree(i);
            }
            for(int i=0;i<n;i++){
                int leftID=sc.nextInt();
                int rightID=sc.nextInt();
                if(leftID!=-1){
                    trees[i].left=trees[leftID];
                }
                if(rightID!=-1){
                    trees[i].right=trees[rightID];
                }
            }
            n=sc.nextInt();
            for(int i=0;i<n;i++){
                System.out.println(findCommon(trees[sc.nextInt()],trees[sc.nextInt()],trees[0]).value);
            }
            n=sc.nextInt();
        }
        sc.close();
        Set<Integer> beginIndex=new HashSet<Integer>();
        ArrayList<Integer> tuple=new ArrayList<>();
    }

    public static void testMethod(int i){

    }
}
