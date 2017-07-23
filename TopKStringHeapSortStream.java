import java.util.HashMap;

public class TopKStringHeapSortStream {
    private static Node[] nodes;
    private static int topK;
    private static int number;
    private static HashMap<String, Integer> map;
    private static HashMap<String, Integer> index;

    private static class Node {
        public String name;
        public int frequency;
    }

    public static void setK(int k) {
        map = new HashMap<>();
        index = new HashMap<>();
        nodes = new Node[k];
        topK = k;
        number = 0;
    }

    public static void topKsort(String array) {
        if (map.get(array) != null) {
            map.put(array, map.get(array) + 1);
            for(int i=0;i<number;i++){
                if(nodes[i].name.equals(array)){
                    nodes[i].frequency++;
                }
            }
            if (index.get(array) != -1) {
                heapDelete(nodes, number, index.get(array));
            }
        } else {
            map.put(array, 1);
            index.put(array, -1);
            if (number < topK) {
                nodes[number] = new Node();
                nodes[number].name = array;
                nodes[number].frequency = map.get(array);
                heapInsert(nodes, number, topK, nodes[number]);
                number++;
            } else {
                Node node = new Node();
                node.name = array;
                node.frequency = map.get(array);
                heapInsert(nodes, topK, topK, node);
            }
        }
        for (int i = 0; i < number; i++) {
            System.out.print(nodes[i].name + " " + nodes[i].frequency+"  |   ");
        }
        System.out.println();
    }

    public static void heapInsert(Node[] nodes, int i, int topk, Node node) {
        if (i < topk) {
            int number = i;
            while (number != 0) {
                int parent = (number - 1) / 2;
                if (nodes[parent].frequency > nodes[number].frequency) {
                    swap(nodes, parent, number);
                    number = parent;
                } else {
                    index.put(nodes[parent].name, parent);
                    index.put(nodes[number].name, number);
                    break;
                }
            }
        } else {
            if (nodes[0].frequency < node.frequency) {
                nodes[0] = node;
                index.put(node.name, 0);
                heapDelete(nodes, topk, 0);
            }
        }
    }

    public static void heapDelete(Node[] node, int length, int deletePoint) {
        for (int i = deletePoint; i <= (length - 2) / 2; ) {
            int left = i * 2 + 1;
            int right = i * 2 + 2 > length - 1 ? length - 1 : i * 2 + 2;
            if (node[i].frequency > node[left].frequency || node[i].frequency > node[right].frequency) {
                if (node[left].frequency > node[right].frequency) {
                    swap(node, right, i);
                    i = right;
                } else {
                    swap(node, left, i);
                    i = left;
                }
            } else {
                break;
            }
        }
    }

    public static void swap(Node[] node, int parent, int child) {
        index.put(node[parent].name, child);
        index.put(node[child].name, parent);
        Node tmp = node[parent];
        node[parent] = node[child];
        node[child] = tmp;
    }

    public static void main(String args[]) {
        setK(3);
        topKsort("four");
        topKsort("four");
        topKsort("four");
        topKsort("four");
        topKsort("three");
        topKsort("two");
        topKsort("three");
        topKsort("two");
        topKsort("three");
        topKsort("one");
    }
}
