public class WhetherInterceptLinkedList {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode reverseNode(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode meet1 = firstMeet(head1);
        LinkedListNode meet2 = firstMeet(head2);
        int step1 = getStep(head1, meet1);
        int step2 = getStep(head2, meet2);
        if (meet1 != null && meet2 != null && meet1 != meet2) {
            LinkedListNode begin=meet1.next;
            while(begin!=meet1){
                if(begin==meet2){
                    return meet2;
                }
                begin=begin.next;
            }
            return null;
        } else if (meet1 == null && meet2 != null) {
            return null;
        } else if (meet1 != null && meet2 == null) {
            return null;
        } else {
            LinkedListNode longhead = step1 > step2 ? head1 : head2;
            LinkedListNode shorthead = step1 > step2 ? head2 : head1;
            int step = step1 > step2 ? step1 - step2 : step2 - step1;
            while (step != 0) {
                longhead = longhead.next;
                step--;
            }
            while (longhead != shorthead && longhead != null) {
                longhead = longhead.next;
                shorthead = shorthead.next;
            }
            return longhead;
        }
    }

    public static int getStep(LinkedListNode head, LinkedListNode firstmeet) {
        int step = 0;
        while (head != firstmeet) {
            head = head.next;
            step++;
        }
        return step;
    }

    public static LinkedListNode firstMeet(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
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
        head1.next.next.next.next.next = new LinkedListNode(0);
        head1.next.next.next.next.next.next=head1.next.next.next;


        LinkedListNode head2=new LinkedListNode(6);
        head2.next = new LinkedListNode(7);
        head2.next.next = new LinkedListNode(8);
        head2.next.next.next = new LinkedListNode(9);
        head2.next.next.next.next = new LinkedListNode(10);
        head2.next.next.next.next.next= head1.next.next.next.next;
        System.out.println(reverseNode(head1,head2)==null?"null":reverseNode(head1,head2).value);
    }
}
