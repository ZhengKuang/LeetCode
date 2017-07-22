
public class HeapSort {
    public static void heapOne(int[] array,int n, int index){
        int i=index;
        int left=0;
        int right=0;
        for(;i<=(n-1)/2;){
            left=i*2+1>n-1?n-1:i*2+1;
            right=i*2+2>n-1?n-1:i*2+2;
            if(array[i]>array[left]||array[i]>array[right]){
                if(array[left]>array[right]){
                    swap(array,i,right);
                    i=i*2+2;
                }
                else{
                    swap(array,i,left);
                    i=i*2+1;
                }
            }
            else{
                break;
            }

        }
    }

    public static void swap(int[] array,int i,int j){
            int tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
    }

    public static void heapSort(int [] array){
        for(int i=(array.length-1)/2;i>=0;i--){
            heapOne(array,array.length,i);
        }
        for(int i=array.length-1;i>=0;i--){
            int length=i+1;
            System.out.println(array[0]);
            array[0]=array[i];
            heapOne(array,length,0);

        }
    }

    //big root heap
     public static void main(String args[]){
        int[] a={6,10,2,5,7,1,4,8,3,9};
        heapSort(a);
     }
}
