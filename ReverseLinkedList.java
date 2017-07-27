public class ReverseLinkedList {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode reverseNode(LinkedListNode head){
        if(head==null||head.next==null){
            return head;
        }
        LinkedListNode cur=head;
        LinkedListNode last=null;
        LinkedListNode tmp=null;
        while(cur!=null){
           tmp=cur.next;
           cur.next=last;
           last=cur;
           cur=tmp;
        }
        return last;
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
        printOutCome(reverseNode(head1));
    }
}
