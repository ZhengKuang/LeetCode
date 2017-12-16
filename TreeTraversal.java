import java.util.*;
class TreeTraversal{
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

    public static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    public static void preOrder(Node root){
        if(root==null) return;
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    public static void preOrderIter(Node root){
        if(root==null) return;
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.value);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
    }

    public static void postOrderIter(Node root){
        if(root==null) return;
        Stack<Node> stack=new Stack<>();
        Node lastvisited=null;
        Node cur=root;
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        while(!stack.isEmpty()){
            cur=stack.peek();
            if(cur.right!=lastvisited&&cur.right!=null){
                cur=cur.right;
                if(cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                    while(cur!=null){
                        stack.push(cur);
                        cur=cur.left;
                    }
                }
            }
            else{
                lastvisited=stack.pop();
                System.out.println(lastvisited.value);
            }
        }
    }

    public static void inOrderIter(Node root){
        if(root==null) return;
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        while(!stack.isEmpty()){
            cur=stack.pop();
            System.out.println(cur.value);
            cur=cur.right;
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
                while(cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                }
            }
        }
    }


    public static void main(String[] args){
        Node n1=new Node(1);
        n1.left=new Node(2);
        n1.right=new Node(3);
        n1.left.left=new Node(4);
        n1.left.right=new Node(5);
        n1.right.left=new Node(6);
        n1.right.right=new Node(7);
        inOrderIter(n1);
        System.out.println("----------------");
        preOrderIter(n1);
        System.out.println("----------------");
        postOrderIter(n1);
        System.out.println("----------------");
        ArrayList<Integer> al=new ArrayList<>();
        System.out.println(al.size());
        Iterator<Integer> it=al.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());

    }
}