import java.util.zip.DeflaterOutputStream;

public class SortedTreeToDoubleLinkedList {
    public static class Tree {
        public Tree left;
        public Tree right;
        public int value;

        public Tree(int value) {
            this.value = value;
        }
    }

    public static class DoubleLinkedList {
        public DoubleLinkedList pre;
        public DoubleLinkedList next;
        public int value;

        public DoubleLinkedList(int value) {
            this.value = value;
        }
    }

    public static DoubleLinkedList getDoubleLinkedList(Tree root) {
        DoubleLinkedList list = getList(root);
        DoubleLinkedList head = list.next;
        list.next = null;
        return head;
    }

    public static DoubleLinkedList getList(Tree end) {
        if (end.left == null && end.right == null) {
            DoubleLinkedList node=new DoubleLinkedList(end.value);
            node.next=node;
            return node;
        }
        DoubleLinkedList left = null;
        DoubleLinkedList right = null;
        DoubleLinkedList mid = new DoubleLinkedList(end.value);
        if (end.left != null && end.right != null) {
            left = getList(end.left);
            right = getList(end.right);
            mid.next = right.next;
            right.next = left.next;
            left.next = mid;
            mid.pre = left;
            mid.next.pre=mid;
            return right;
        }
        if (end.left == null && end.right != null) {
            right = getList(end.right);
            mid.next = right.next;
            mid.pre = null;
            right.next.pre = mid;
            right.next = mid;
            return right;
        }
        if (end.left != null && end.right == null) {
            left = getList(end.left);
            mid.next = left.next;
            left.next = mid;
            mid.pre = left;
            return mid;
        }
        return null;
    }

    public static Tree getTree(int[] value) {
        if (value == null) return null;
        Tree root = new Tree(value[0]);
        for (int i = 1; i < value.length; i++) {
            insert(root, value[i]);
        }
        return root;
    }

    public static void insert(Tree root, int value) {
        if (value < root.value && root.left != null) {
            insert(root.left, value);
        }
        if (value < root.value && root.left == null) {
            root.left = new Tree(value);
        }
        if (value > root.value && root.right != null) {
            insert(root.right, value);
        }
        if (value > root.value && root.right == null) {
            root.right = new Tree(value);
        }
    }

    public static void main(String args[]) {
        int[] value = new int[]{5, 1, 3, 2, 4, 6, 8, 7, 9};
        Tree root = getTree(value);
        DoubleLinkedList list = getDoubleLinkedList(root);
        int i = 0;

    }
}
