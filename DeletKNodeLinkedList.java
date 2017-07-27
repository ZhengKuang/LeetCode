public class DeletKNodeLinkedList {
    private static class LinkedListNode{
        public LinkedListNode next;
        public int value;
        public LinkedListNode(int data){
            value=data;
        }
    }

    public static LinkedListNode deleteKnode(int k,LinkedListNode head){
        int indexK=k;
        LinkedListNode cur=head;
        while(cur!=null){
            indexK--;
            cur=cur.next;
        }
        if(indexK==0){
            head=head.next;
        }
        if(indexK<0){
            cur=head;
            while(indexK!=-1){
                indexK++;
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;
    }

    public static void printNode(LinkedListNode head){
        LinkedListNode node=head;
        while(node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }

    public static void main(String args[]){
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(2);
        head1.next.next = new LinkedListNode(4);
        head1.next.next.next = new LinkedListNode(5);
        head1.next.next.next.next = new LinkedListNode(8);


        printNode(deleteKnode(5,head1));
    }

}
