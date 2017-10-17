import java.util.HashMap;
import java.util.HashSet;

class LFUCache {
    HashMap<Integer,Node> map;
    HashSet<Integer> set=new HashSet<>();
    HashMap<Integer,Integer> frequency;
    Node head;
    Node tail;
    int capacity;
    class Node{
        public int key;
        public int value;
        public Node pre;
        public Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public LFUCache(int capacity) {
        map=new HashMap<>();
        frequency=new HashMap();
        head=new Node(-1,-1);
        tail=new Node(-2,-1);
        head.next=tail;
        head.pre=null;
        tail.pre=head;
        tail.next=null;
        frequency.put(-1,-1);
        frequency.put(-2,-2);
        this.capacity=capacity;
    }

    public int get(int key) {
        if(map.get(key)!=null){
            //move the node to the head, return the value
            Node getnode=map.get(key);
            Integer fre=frequency.get(key);
            frequency.put(key,fre+1);
            getnode.pre.next=getnode.next;
            getnode.next.pre=getnode.pre;
            putNode(getnode);
            return getnode.value;
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.get(key)!=null){
            Node getnode=map.get(key);
            getnode.value=value;
            int fre=frequency.get(key);
            frequency.put(key,fre+1);
            getnode.pre.next=getnode.next;
            getnode.next.pre=getnode.pre;
            putNode(getnode);
            //get the node, update the value, move to the head
        }
        else{
            //if <capacity
            if(map.size()<capacity){
                Node node=new Node(key,value);
                map.put(key,node);
                frequency.put(key,0);
                putNode(node);
            }
            //initialize the node, move node to the head capacity++
            //if ==capacity=
            //initialize the node, move node to the head, remove the last node
            else{
                Node node=new Node(key,value);
                map.put(key,node);
                frequency.put(key,0);
                removeNode();
                putNode(node);

            }

        }
    }

    public void putNode(Node node){
        Node cur=head.next;
        while(frequency.get(node.key)<frequency.get(cur.key)) {
            cur=cur.next;
        }
        node.next=cur;
        node.pre=cur.pre;
        cur.pre=node;
        node.pre.next=node;
    }

    public void removeNode(){
        Node tmp=tail.pre;
        tmp.pre.next=tail;
        tail.pre=tmp.pre;
        map.remove(tmp.key);
        frequency.remove(tmp.key);
        tmp.next=null;
        tmp.pre=null;
    }

    public static void main(String args[]){
        LFUCache cache=new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */