public class DeletKNodeDoubleLinkedListAnswer {
    private static class DoubleLinkedListNode{
        public DoubleLinkedListNode next;
        public DoubleLinkedListNode last;
        public int value;
        public DoubleLinkedListNode(int value){
            this.value=value;
        }
    }

    public static DoubleLinkedListNode DeletK(int k,DoubleLinkedListNode head){
        int kth=k;
        DoubleLinkedListNode cur=head;
        while(cur!=null){
            kth--;
            cur=cur.next;
        }
        if(kth==0){
            head=head.next;
            head.last=null;
        }
        if(kth<0){
            cur=head;
            while(++kth!=0){
                cur=cur.next;
            }
            cur.next=cur.next.next;
            if(cur.next!=null){
                cur.next.last=cur;
            }
        }
        return head;
    }

    public static void printNode(DoubleLinkedListNode head){
        DoubleLinkedListNode top=head;
        DoubleLinkedListNode last=head;
        while(last.next!=null){
            last=last.next;
        }
        while(top!=null){
            System.out.println("From top: "+top.value);
            top=top.next;
        }
        while(last!=null){
            System.out.println("From last: "+last.value);
            last=last.last;
        }
    }

    public static void main(String args[]){
        DoubleLinkedListNode node=new DoubleLinkedListNode(1);
        node.next=new DoubleLinkedListNode(2);
        node.next.next=new DoubleLinkedListNode(3);
        node.next.next.next=new DoubleLinkedListNode(4);
        node.next.next.next.next=new DoubleLinkedListNode(5);

        node.next.next.next.next.last=node.next.next.next;
        node.next.next.next.next.last.last=node.next.next;
        node.next.next.next.next.last.last.last=node.next;
        node.next.next.next.next.last.last.last.last=node;

        printNode(node);

        printNode(DeletK(5,node));
    }
}
