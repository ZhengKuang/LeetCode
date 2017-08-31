import java.util.Arrays;

public class QuickSort {
    public static int devide(int[] array, int left,int right){
        int i=left,j=right;
        int pivot=array[(left+right)/2];
        while(i<=j){
            while(array[i]<pivot){
                i++;
            }
            while(array[j]>pivot){
                j--;
            }
            if(i<=j){
                int tmp=array[i];
                array[i]=array[j];
                array[j]=tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static void quickSort(int[] arr,int left,int right){
        int index=devide(arr,left,right);
        if(left<index-1){
            quickSort(arr,left,index-1);
        }
        if(right>index){
            quickSort(arr,index,right);
        }
    }

    public static void main(String args[]){
        int a[]={2,1};
        quickSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
