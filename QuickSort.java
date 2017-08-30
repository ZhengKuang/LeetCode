import java.util.Arrays;

public class QuickSort {
    public static int devide(int[] array, int left,int right, int k){
        int i=left,j=right;
        int pivot=array[(left+right)/2];
        int pivotindex=(left+right)/2;
        while(i<=j){
            while(array[i]<pivot){
                i++;
            }
            while(array[j]>pivot){
                j--;
            }
            if(i<=j){
                if(array[i]==pivot&&array[j]==pivot){
                    pivotindex=pivotindex;
                }
                else if(array[i]==pivot&&array[j]!=pivot){
                    pivotindex=j;
                }
                else if(array[i]!=pivot&&array[j]==pivot){
                    pivotindex=i;
                }
                int tmp=array[i];
                array[i]=array[j];
                array[j]=tmp;
                i++;
                j--;
            }
        }
        System.out.println(Arrays.toString(array)+"  pivot: "+pivot+"  pivotindex: "+pivotindex+" left "+left+" right "+right);
        return pivotindex;
    }

    public static void quickSort(int[] arr,int left,int right,int k){
        int index=devide(arr,left,right,k);
        if(index+1>k){
            quickSort(arr,left,index-1,k);
        }
        else if(index+1<k){
            quickSort(arr,index+1,right,k);
        }
        else System.out.println(arr[index]);
    }

    public static void main(String args[]){
        int a[]={1,2,3,7,10,7,8};
        quickSort(a,0,a.length-1,7);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
