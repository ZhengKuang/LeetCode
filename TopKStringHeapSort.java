import java.util.HashMap;
import java.util.Map;

public class TopKStringHeapSort {
    private static class Node{
        public String name;
        public int frequency;
    }
    public static void topKsort(String[] array,int k){
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(map.get(array[i])!=null){
                map.put(array[i],map.get(array[i])+1);
            }
            else{
                map.put(array[i],1);
            }
        }
        Node[] node=new Node[array.length];
        int nodeNumber=0;
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            node[nodeNumber]=new Node();
            node[nodeNumber].name=entry.getKey();
            node[nodeNumber].frequency=entry.getValue();
            heapInsert(node,nodeNumber,k);
            nodeNumber++;
        }
        Node[] nodeOut=new Node[k];
        for(int i=0;i<k;i++){
            nodeOut[k-i-1]=new Node();
            nodeOut[k-i-1]=node[0];
            node[0]=node[k-i-1];
            heapDelete(node,k-i-1);
        }
        for(int i=0;i<nodeOut.length;i++){
            System.out.println(nodeOut[i].name+ " "+nodeOut[i].frequency);
        }
    }

    public static void heapInsert(Node[] node,int i,int topk){
        if(i<topk) {
            int index = i;
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (node[parent].frequency > node[index].frequency) {
                    swap(node, parent, index);
                    index = parent;
                } else {
                    break;
                }
            }
        }
        else{
           if(node[0].frequency<node[i].frequency){
                node[0]=node[i];
                heapDelete(node,topk);
           }
        }
    }

    public static void heapDelete(Node[] node, int length){
        for(int i=0;i<=(length-2)/2;){
            int left=i*2+1;
            int right=i*2+2>length-1?length-1:i*2+2;
            if(node[i].frequency>node[left].frequency||node[i].frequency>node[right].frequency){
                if(node[left].frequency>node[right].frequency){
                    swap(node,right,i);
                    i=right;
                }
                else{
                    swap(node,left,i);
                    i=left;
                }
            }
            else{
                break;
            }
        }
    }

    public static void swap(Node[] node,int parent,int index){
        Node tmp=node[parent];
        node[parent]=node[index];
        node[index]=tmp;
    }

    public static void main(String args[]){
        String[] array={"four","four","four","four","three","three","three","two","two","one","five","five","five","five","five"};
        topKsort(array,3);
    }
}
