public class HeapSort {
    public static void heapInsert(int[] array, int index){
        while(index!=0){
            int parent=(index-1)/2;
            if(array[index]<array[parent]){
                swap(array,index,parent);
                index=parent;
            }
            else{
                break;
            }
        }
    }

    public static void swap(int[] array,int index,int parent){
        int tmp=array[index];
        array[index]=array[parent];
        array[parent]=tmp;
    }

    public static void heapify(int[] array,int index,int heapSize){
        int left=index*2+1;
        int right=index*2+2;
        int largest=index;
        while(left<heapSize){
            if(array[largest]>array[left]){
                largest=left;
            }
            if(right<heapSize&&array[largest]>array[right]){
                largest=right;
            }
            if(index!=largest){
                swap(array,index,largest);
            }
            else{
                break;
            }
            index=largest;
            left=index*2+1;
            right=index*2+2;
        }
    }

    public static int[] heapSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int b[]=new int[arr.length];
        int size=arr.length;
        for(int i=0;i<b.length;i++){
            b[i]=arr[0];
            arr[0]=arr[size-1];
            size--;
            heapify(arr,0,size);
        }
        return b;
    }
    //big root heap
     public static void main(String args[]){
        int[] a={6,10,2,5,7,1,4,8,3,9};
        int[] b=heapSort(a);
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]);
        }
     }
}
