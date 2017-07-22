public class MaxTreeHeapInsert {
    public static void heapInsert(int[] array,int i){
        int index=i;
        while(index!=0){
            int parent=(index-1)/2;
            if(array[parent]<array[index]){
                swap(array,parent,index);
                index=parent;
            }
            else{
                break;
            }
        }
    }

    public static void heapDelete(int[] array,int lastindex){
        for(int i=0;i<=(lastindex-1)/2;){
            int left=2*i+1;
            int right=2*i+2>lastindex?lastindex:2*i+2;
            if(array[i]<array[left]||array[i]<array[right]){
                if(array[left]<array[right]){
                    swap(array,i,right);
                    i=right;
                }
                else {
                    swap(array,i,left);
                    i=left;
                }
            }
            else{
                break;
            }
        }
    }

    public static void swap(int[] array,int parent,int index){
        int tmp=array[index];
        array[index]=array[parent];
        array[parent]=tmp;
    }

    public static void main(String args[]){
        int[] a={6,10,2,5,7,1,4,8,3,9};
        for(int i=0;i<a.length;i++){
            heapInsert(a,i);
        }
        for(int i=a.length-1;i>=0;i--){
            int output=a[0];
            System.out.print(output+" ");
            a[0]=a[i];
            heapDelete(a,i);
        }
    }
}
