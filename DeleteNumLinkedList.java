import java.util.HashMap;

public class DeleteNumLinkedList {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode DeleteNumber(LinkedListNode head,int number) {
        if (head == null) {
            return head;
        }
        LinkedListNode last = null;
        LinkedListNode cur = head;
        LinkedListNode newhead=head;
        while(newhead.value==number){
            newhead=newhead.next;
            cur=newhead;
        }
        while (cur != null) {
            last=cur.value==number?last:cur;
            if(cur.value==number){
                last.next=cur.next;
            }
            cur = cur.next;
        }
        return newhead;
    }


    public static void printOutCome(LinkedListNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String args[]) {
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(1);
        head1.next.next = new LinkedListNode(3);
        head1.next.next.next = new LinkedListNode(3);
        head1.next.next.next.next = new LinkedListNode(2);
        printOutCome(DeleteNumber(head1,1));
    }
}
