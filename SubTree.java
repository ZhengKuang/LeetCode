public class SubTree {
    public static class Tree{
        public Tree left;
        public Tree right;
        public int value;
        public Tree(int value){
            this.value=value;
        }

    }

    public static String serializationPre(Tree root){
        String s="";
        if(root==null){
            return "#!";
        }
        s+=String.valueOf(root.value)+"!";
        s+=serializationPre(root.left);
        s+=serializationPre(root.right);
        return s;
    }

    public static void main(String args[]){
        Tree node=new Tree(1);
        node.left=new Tree(2);
        node.right=new Tree(3);
        node.left.left=new Tree(4);

        System.out.println(serializationPre(node));
    }
}
