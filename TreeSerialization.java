import java.util.LinkedList;

public class TreeSerialization {
    public static class Tree{
        public Tree left;
        public Tree right;
        public int value;
        public Tree(int value){
            this.value=value;
        }
    }

    public static String serialByPre(Tree head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Tree reconstruct(String s){
        String[] values=s.split("!");
        LinkedList<String> list=new LinkedList<>();
        for(int i=0;i!=values.length;i++){
            list.offer(values[i]);
        }
        return reconPreOrder(list);
    }

    public static Tree reconPreOrder(LinkedList<String> list){
        String node=list.poll();
        if(node.equals("#")){
            return null;
        }
        Tree head = new Tree(Integer.valueOf(node));
        head.left = reconPreOrder(list);
        head.right = reconPreOrder(list);
        return head;
    }

    public static String serializbylevel(Tree head){
        LinkedList<Tree> treeList=new LinkedList<Tree>();
        treeList.offer(head);
        String s="";
        while(!treeList.isEmpty()){
            Tree tmp=treeList.poll();
            if(tmp!=null) {
                treeList.offer(tmp.left);
                treeList.offer(tmp.right);
                s+=tmp.value+"!";
            }
            else{
                s+="#!";

            }
        }
        return s;
    }

    public static Tree reconstructByLevel(String s){
        String[] values=s.split("!");
        Tree[] list=new Tree[values.length];
        for(int i=0;i<values.length;i++){
            if(values[i].equals("#")){
                list[i]=null;
            }
            else{
                list[i]=new Tree(Integer.valueOf(values[i]));
            }
        }
        for(int i=0,j=1;j<=list.length-1;i++){
            list[i].left=list[j++];
            list[i].right=list[j++];
        }
        return list[0];

    }


    public static void main(String[] args){
        Tree node=new Tree(1);
        node.left=new Tree(2);
        node.right=new Tree(3);
        node.left.left=new Tree(4);
        String s= serializbylevel(node);
        Tree reTree=reconstructByLevel(s);
        int i=0;

    }
}
