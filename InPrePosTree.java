import java.util.Stack;

public class InPrePosTree {
    public static class Tree {
        public Tree left;
        public Tree right;
        public int value;

        public Tree(int value) {
            this.value = value;
        }
    }

    public static void inOrderUnRecur(Tree root) {
        Stack<Tree> treeStack = new Stack<>();
        while (!treeStack.isEmpty() || root != null) {
            if (root != null) {
                treeStack.push(root);
                root = root.left;
            } else {
                root = treeStack.pop();
                System.out.println("the value is " + root.value);

                root = root.right;
            }

        }
        System.out.println("____________");
    }

    public static void porstOrderUnRecur(Tree root) {
        Stack<Tree> treeStack1 = new Stack<>();
        Stack<Tree> treeStack2 = new Stack<>();
        treeStack1.push(root);
        while (!treeStack1.isEmpty()) {
            Tree node = treeStack1.pop();
            treeStack2.push(node);
            if (node.left != null) {
                treeStack1.push(node.left);
            }
            if (node.right != null) {
                treeStack1.push(node.right);
            }
        }
        while (!treeStack2.isEmpty()) {
            System.out.println("the value is " + treeStack2.pop().value);

        }
        System.out.println("____________");
    }

    public static void porstOrderUnRecur2(Tree head) {
        Stack<Tree> treeStack1 = new Stack<>();
        treeStack1.push(head);
        Tree c=null;
        while (!treeStack1.isEmpty()) {
            c = treeStack1.peek();
            if(c.left!=null&&head!=c.left&&head!=c.right){
                treeStack1.push(c.left);
            }
            else if (c.right != null&&head!=c.right) {
                treeStack1.push(c.right);
            }
            else  {
                System.out.println("the value is :" +treeStack1.pop().value);
                head=c;
            }
        }
        System.out.println("____________");
    }

    public static void preOrderUnRecur(Tree root) {
        Stack<Tree> treeStack = new Stack<>();
        treeStack.push(root);
        while (!treeStack.isEmpty()) {
            Tree node = treeStack.pop();
            System.out.println("the value is " + node.value);
            if (node.left != null) {
                treeStack.push(node.right);
            }
            if (node.right != null) {
                treeStack.push(node.left);
            }
        }
        System.out.println("____________");

    }



    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);

        preOrderUnRecur(tree);

        inOrderUnRecur(tree);

        porstOrderUnRecur(tree);

        porstOrderUnRecur2(tree);
    }
}
