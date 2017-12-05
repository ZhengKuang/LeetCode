
import java.math.BigInteger;
import java.util.*;


class Node{
    int val;
    ArrayList<Node> neighbors;
    Node(int i_val) {
        val = i_val;
    }
    Node() {}
}

class MySolution {
    Queue<String> q=new LinkedList<>();
    int max;
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        int[] val1 = {4, 4, 4, 1, 5, 5};
        int[] edge1 = {0, 1, 2, 1, 1, 3, 3, 4, 4, 5};
        int[] val2 = {0, 4, 2, 2, 4, 4, 1, 4, 4, 4, 4, 4, 4, 3, 3};
        int[] edge2 = {1, 4, 0, 1, 1, 3, 2, 1, 4, 5, 5, 6, 9, 8, 8, 7, 7, 5, 1, 10, 10, 11, 11, 12, 12, 13, 13, 14};
        //2, 5, 1, 2, 2, 4, 3, 2, 5, 6, 6, 7, 10, 9, 9, 8, 8, 6, 2, 11, 11, 12, 12, 13, 13, 14, 14, 15

        int[] val3 = {2, 2, 2, 5, 6, 4, 2, 2, 2, 2, 2, 2};
        int[] edge3 = {7, 8, 7, 9, 10, 11, 9, 10, 7, 2, 2, 1, 1, 0, 7, 3, 3, 4, 7, 6, 6, 5};
        //8, 9, 8, 10, 11, 12, 10, 11, 8, 3, 3, 2, 2, 1, 8, 4, 4, 5, 8, 7, 7, 6

        int[] val4 = {2, 2, 2, 2, 2, 2, 2};
        int[] edge4 = {0, 1, 1, 2, 2, 3, 3, 4, 2, 5, 2, 6};
        //1, 2, 2, 3, 3, 4, 4, 5, 3, 6, 3, 7
        MySolution s = new MySolution();

        System.out.println(s.solution(val2, edge2));
        System.out.println(s.solution(val3, edge3));
        System.out.println(s.solution(val4, edge4));
        System.out.println(s.solution(val1, edge1));
    }

    public int solution(int[] A, int[] E) {

        //corner case
        if(A == null || E == null || A.length == 0 || A.length == 1) return 0;
        max = 0;
        //init array
        Node[] nodeArray = new Node[A.length];
        for(int i = 0; i < A.length; i++) {
            nodeArray[i] = new Node(A[i]);
            nodeArray[i].neighbors = new ArrayList<Node>();
        }

        //add neighbors
        for(int i = 0; i < E.length; i += 2) {
            int node1 = E[i], node2 = E[i + 1];
            nodeArray[node1].neighbors.add(nodeArray[node2]);
            nodeArray[node2].neighbors.add(nodeArray[node1]);
        }

        //treate as tree, post order recursion
        postHelper(nodeArray[0], nodeArray[0]);

        return max;
    }

    public int postHelper(Node upper, Node self) {
        //end condition
        if(self.neighbors.size() == 1 && upper != self) return 0;
        //main tain two largest path
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        pq.add(-1);
        pq.add(-1);

        for(Node thisNode : self.neighbors) {
            if(thisNode == upper) continue;
            int nei_max = postHelper(self, thisNode);
            if(thisNode.val == self.val) {
                pq.offer(nei_max);
            }
        }

        //when -1, 0
        int firstMax = pq.poll() + 1;
        int secondMax = pq.poll() + 1;
        int globalMax = firstMax + secondMax;

        //update global max
        max = Math.max(globalMax, max);
        return firstMax;
    }
}