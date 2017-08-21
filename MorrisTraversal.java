public class MorrisTraversal {
    public static class Node{
        public Node left;
        public Node right;
        public int value;
        public Node(int value){
            this.value=value;
        }
    }

    public static void morrisTraversalIn(Node head){
        if(head==null) return;
        Node cur1=head;
        Node cur2=null;
        while(cur1!=null){
            cur2= cur1.left;
            if (cur2 != null) {
                while(cur2.right!=null&&cur2.right!=cur1){
                    cur2= cur2.right;
                }
                if(cur2.right==null){
                    cur2.right=cur1;
                    cur1=cur1.left;
                    continue;
                }
                else{
                    cur2.right=null;
                }
            }
            System.out.print(cur1.value);
            cur1=cur1.right;
        }
    }

    public static void morrisTraversalPre(Node head){
        if(head==null) return;
        Node cur1=head;
        Node cur2=null;
        while(cur1!=null){
            cur2= cur1.left;
            if (cur2 != null) {
                while(cur2.right!=null&&cur2.right!=cur1){
                    cur2= cur2.right;
                }
                if(cur2.right==null){
                    cur2.right=cur1;
                    System.out.print(cur1.value);
                    cur1=cur1.left;
                    continue;
                }
                else{
                    cur2.right=null;
                }
            }
            if(cur1.left==null){
                System.out.print(cur1.value);
            }
            cur1=cur1.right;
        }
    }


    public static void morrisTraversalPost(Node head){
        if(head==null) return;
        Node cur1=head;
        Node cur2=null;
        while(cur1!=null){
            cur2= cur1.left;
            if (cur2 != null) {
                while(cur2.right!=null&&cur2.right!=cur1){
                    cur2= cur2.right;
                }
                if(cur2.right==null){
                    cur2.right=cur1;
                    cur1=cur1.left;
                    continue;
                }
                else{
                    cur2.right=null;
                    Node leaf=reverseRight(cur1.left);
                    Node tmp=leaf;
                    while(tmp!=null){
                        System.out.print(tmp.value);
                        tmp=tmp.right;
                    }
                    reverseRight(leaf);
                }
            }
            cur1=cur1.right;
        }
        Node leaf=reverseRight(head);
        Node tmp=leaf;
        while(tmp!=null){
            System.out.print(tmp.value);
            tmp=tmp.right;
        }
        reverseRight(leaf);

    }

    public static Node reverseRight(Node root){
        Node cur=root;
        Node pre=null;
        while(cur!=null){
            Node tmp=cur.right;
            cur.right=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }


    public static void main(String args[]){
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.left=new Node(6);
        node.right.right=new Node(7);
        morrisTraversalPost(node);
    }


}
