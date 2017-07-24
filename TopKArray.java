import java.util.Arrays;

public class TopKArray {
    private static class Node{
        public int arrayColumn;
        public int arrayRow;
        public int value;
        public Node(int arrayRow,int arrayColumn,int value){
            this.arrayColumn=arrayColumn;
            this.arrayRow=arrayRow;
            this.value=value;
        }
    }


    public static void topK(int[][] matrix,int topK){
        Node[] list=new Node[matrix.length];
        int[] nodelength=new int[1];
        nodelength[0]=matrix.length;
        for(int i=0;i<matrix.length;i++){
            list[i]=new Node(i,matrix[i].length-1,matrix[i][matrix[i].length-1]);
            heapInsert(list,topK,i);
        }
        for(int i=0;i<topK;i++){
            int value=getTop(list,matrix,nodelength);
            System.out.println(value);
        }
    }

    public static int getTop(Node[] nodes,int[][] matrix,int[] nodelength){
        int value;
        if(nodes[0].arrayColumn>=1){
            value=nodes[0].value;
            nodes[0].arrayColumn--;
            nodes[0].value = matrix[nodes[0].arrayRow][nodes[0].arrayColumn];
            heapDelete(nodes,nodelength[0],0);
        }
        else {
            value=nodes[0].value;
            swap(nodes,0,nodelength[0]-1);
            heapDelete(nodes,nodelength[0],0);
            nodelength[0]--;
        }
        return value;
    }


    public static void heapInsert(Node[] nodes,int topK,int i){
        int child=i;
        while(child!=0){
            int parent=(child-1)/2;
            if(nodes[parent].value<nodes[child].value){
                swap(nodes,parent,child);
                child=parent;
            }
            else{
                break;
            }

        }
    }

    public static void heapDelete(Node[] nodes,int length,int deleteIndex){
        for(int i=deleteIndex;i<=(length-2)/2;){
            int left=i*2+1>length-1?length-1:i*2+1;
            int right=i*2+2>length-1?length-1:i*2+2;
            if(nodes[i].value<nodes[left].value||nodes[i].value<nodes[right].value){
                if(nodes[left].value<nodes[right].value){
                    swap(nodes,i,right);
                    i=right;
                }
                else{
                    swap(nodes,i,left);
                    i=left;
                }
            }
            else{
                break;
            }
        }
    }

    public static void swap(Node[] nodes,int parent,int child){
        Node tmp=nodes[parent];
        nodes[parent]=nodes[child];
        nodes[child]=tmp;
    }



    public static void main(String args[]){
        int[][] matrix =generateRandomMatrix(5,10,1000);
        topK(matrix,5);
    }

    public static int[][] generateRandomMatrix(int maxRow,int maxColumn,int maxValue){
        int[][] matrix=new int[(int)(Math.random()*maxRow+1)][];
        for(int i=0;i<matrix.length;i++){
            matrix[i]=new int[(int)(Math.random()*maxColumn+1)];
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j]=(int)(Math.random()*maxValue+1);
            }
            Arrays.sort(matrix[i]);
        }
        return matrix;
    }
}
