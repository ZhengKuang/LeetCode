import sun.awt.image.ImageWatched;

public class ReverseLinkedEveryK {
    private static class LinkedListNode {
        public LinkedListNode next;
        public int value;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode reverseNode(LinkedListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode cur=head;
        LinkedListNode pre=null;
        LinkedListNode next=null;
        LinkedListNode newhead=null;
        boolean getNewhead=false;
        int len=0;
        while(cur!=null){
            len++;
            pre=len%k==1?cur:pre;
            next=len%k==0?cur:next;
            cur=cur.next;
            if(len%k==0){
                if(!getNewhead){
                    newhead=next;
                    getNewhead=true;
                }
                LinkedListNode node1=pre;
                LinkedListNode node2=pre.next;
                LinkedListNode tmp;
                node1.next=returnKth(node1,2*k-1)==null?next.next:returnKth(node1,2*k-1);
                for(int i=k;i!=1;i--){
                    tmp=node2.next;
                    node2.next=node1;
                    node1=node2;
                    node2=tmp;
                }
            }
        }
        return newhead;
    }

    public static LinkedListNode returnKth(LinkedListNode start,int k){
        if(start==null||k==0) return start;
        else return returnKth(start.next,k-1);
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
        printOutCome(reverseNode(head1, 5));
    }
}
