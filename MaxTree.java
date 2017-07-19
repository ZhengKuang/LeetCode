import java.util.HashMap;
import java.util.Stack;

public class MaxTree {
    Node[] nodelist;
    public class Node{
        public Node left=null;
        public Node right=null;
        public int value;
    }

    public Node getMaxTree(int[] array){
        nodelist=new Node[array.length];
        Stack<Node> nodeStack=new Stack<>();
        HashMap<Node,Node> parent=new HashMap<>();
        for(int i=0;i<array.length;i++){
            Node a=new Node();
            a.value=array[i];
            nodelist[i]=a;
            while(!nodeStack.empty()&&nodeStack.peek().value<a.value){
                Node tmp1=nodeStack.pop();
                parent.put(tmp1,!nodeStack.empty()&&nodeStack.peek().value<a.value?nodeStack.peek():a);
            }
            nodeStack.push(a);
        }
        Node head=null;
        while(!nodeStack.empty()){
            Node tmp2=nodeStack.pop();
            parent.put(tmp2,!nodeStack.empty()?nodeStack.peek():null);
        }
        for(int i=0;i<nodelist.length;i++){
            Node tmp=nodelist[i];
            Node tmpParent=parent.get(tmp);
            if(tmpParent!=null){
                if(tmpParent.left==null) tmpParent.left=tmp;
                else tmpParent.right=tmp;
            }
            else{
                head=tmp;
            }
        }
        return head;
    }

    public void printTree(Node node){
        if(node==null) {
            System.out.println("null");
            return;
        }
        printTree(node.left);
        System.out.println(node.value);
        printTree(node.right);
    }

    public static void main(String args[]){
        int[] array=new int[]{3, 4, 5, 1, 2,6,9,8};
        MaxTree mt=new MaxTree();
        Node node=mt.getMaxTree(array);
        mt.printTree(node);
    }
}
