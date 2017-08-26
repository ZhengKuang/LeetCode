import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LRUCache {
    private HashMap<Integer,Node> map;
    private int capacity;
    private Node head;
    private Node tail;
    public class Node{
        Node pre;
        Node next;
        Integer value;
        Integer key;
        public Node(Integer key,Integer value){
            this.value=value;
            this.key=key;
            this.pre=null;
            this.next=null;
        }
    }

    public LRUCache(int capacity){
        this.capacity=capacity;
        head=new Node(null,null);
        tail=new Node(null,null);
        map=new HashMap<>();
        head.next=tail;
        head.pre=tail;
        tail.next=head;
        tail.pre=head;
    }

    public Integer get(Integer key){
        Node node=map.get(key);
        if(node!=null){
            detach(node);
            attach(node);
        }
        return node==null?null:node.value;
    }

    public void set(Integer key, Integer value){
        Node node=map.get(key);
        if(node!=null){
            node.value=value;
            detach(node);
            attach(node);
        }
        else{
            if(map.size()==capacity){
                map.remove(head.next.key);
                detach(head.next);
            }
            node=new Node(key,value);
            map.put(key,node);
            attach(node);
        }
    }

    public void detach(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
        node.next=null;
        node.pre=null;
    }

    public void attach(Node node){
        node.next=tail;
        node.pre=tail.pre;
        node.pre.next=node;
        tail.pre=node;
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner s=new Scanner(new File("input.txt"));
        int capacity=s.nextInt();
        while(capacity!=-1){
            LRUCache cache=new LRUCache(capacity);
            int m=s.nextInt();
            while(m--!=0){
                String sr=s.next();
                if(sr.equals("SET")){
                    cache.set(s.nextInt(),s.nextInt());
                }
                else {
                    System.out.println(cache.get(s.nextInt()));
                }
            }
            capacity=s.nextInt();
        }

    }
}
