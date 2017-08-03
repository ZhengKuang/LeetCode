public class OneThreeKillProblem {
    public static class Node{
        public Node next;
        public int value;
        public Node(int value){
            this.value=value;
        }
    }

    public static Node getLastOne(Node head,int length,int killnumber){
        int value=getNodeValue(length,killnumber);
        Node cur=head;
        while(cur.value!=value){
            Node next=cur.next;
            cur=null;
            cur=next;
        }
        return cur;
    }

    public static int getNodeValue(int length,int killnumber){
        int newIndex=1;
        int i=2;
        while(i<=length) {
            int s = getIndex(i, killnumber);
            newIndex = getOldIndex(newIndex, s, i);
            i++;
        }
        return newIndex;
    }

    public static int getOldIndex(int newIndex,int killindexInold,int oldlength){
        int odd=(newIndex+killindexInold-1)%oldlength+1;
        return odd;
    }

    public static int getIndex(int length,int killNumber){
        return (killNumber-1)%length+1;
    }

    public static void main(String args[]){
        Node head1 = new Node (1);
        head1.next = new Node (2);
        head1.next.next = new Node (3);
        head1.next.next.next = new Node (4);
        head1.next.next.next.next = new Node (5);
        head1.next.next.next.next.next=head1;
        System.out.println(getLastOne(head1,4,2).value);

    }
}
