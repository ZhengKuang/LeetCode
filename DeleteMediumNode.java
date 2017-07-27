public class DeleteMediumNode {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int data) {
            value = data;
        }
    }

    public static LinkedListNode DeletMeduim(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        LinkedListNode cur = head.next.next;
        LinkedListNode before = head;
        while (cur.next != null && cur.next.next != null) {
            cur = cur.next;
            before = before.next;
        }
        before.next = before.next.next;
        return head;

    }

    public static LinkedListNode DeletR(LinkedListNode head, int a, int b) {
        LinkedListNode cur = head;
        LinkedListNode beforKth = head;
        double increase = (double) a / (double) b;
        double index = 0.0;
        if (head == null||increase<0.0||increase>1.0) {
            return head;
        }
        while (cur != null) {
            cur = cur.next;
            index = index + increase;
        }
        int delete=(int)Math.ceil(index);
        if(delete==1){
            return head.next;
        }
        while(--delete!=1){
            beforKth=beforKth.next;
        }
        beforKth.next=beforKth.next.next;
        return head;
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
        printOutCome(DeletR(head1,1,6));
    }
}
