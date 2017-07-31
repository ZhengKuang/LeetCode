public class RemoveNode {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static void deleteNode(LinkedListNode node) {
        LinkedListNode cur=node;
        if(cur.next==null) return;
        while(cur!=null){
            cur.value=cur.next.value;
            if(cur.next.next==null) {
                cur.next=null;
                break;
            }
            cur=cur.next;
        }
    }


    public static void printOutCome(LinkedListNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String args[]) {
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(2);
        head1.next.next = new LinkedListNode(3);
        head1.next.next.next = new LinkedListNode(4);
        head1.next.next.next.next = new LinkedListNode(5);
        deleteNode(head1.next.next.next);
        printOutCome(head1);
    }
}
