import javafx.geometry.Pos;

import java.util.Stack;

public class IterativeTree {
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

    public static void Pre(Tree node){
        Stack<Tree> stack=new Stack<>();
        if(node==null) return;
        stack.push(node);
        while(!stack.isEmpty()){
            node=stack.pop();
            System.out.print(node.value);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }

    }

    public static void In(Tree node){
        Stack<Tree> stack=new Stack<>();
        while(node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }
            else{
                node=stack.pop();
                System.out.print(node.value);
                node=node.right;
            }
        }
    }

    public static void Post(Tree node){
        Stack<Tree> stack=new Stack<>();
        Tree lastVisited=null;
        while(!stack.isEmpty()||node!=null){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }
            else{
                Tree peek=stack.peek();
                if(peek.right!=null&&peek.right!=lastVisited){
                    node=peek.right;
                }
                else{
                    System.out.print(peek.value);
                    lastVisited=stack.pop();
                }
            }
        }

    }


    public static void main(String args[]){
        Tree myTree=new Tree(1);
        myTree.left=new Tree(2);
        myTree.right=new Tree(3);
        myTree.left.left=new Tree(4);
        myTree.left.right=new Tree(5);
        myTree.right.left=new Tree(6);
        myTree.right.right=new Tree(7);

        Pre(myTree);

        System.out.print("\n");

        In(myTree);

        System.out.print("\n");

        Post(myTree);
    }
}
