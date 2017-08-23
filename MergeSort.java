import java.util.Arrays;

public class MergeSort {
    public static void sort(int []num,int low,int high){
        if(low==high) return;
        int mid=(low+high)/2;
        sort(num,low,mid);
        sort(num,mid+1,high);
        merge(num,low,mid,high);
    }

    public static void merge(int[]num,int low,int mid, int high){
        int i=low;
        int j=mid+1;
        int []tmp=new int[high-low+1];
        int k=0;
        while(i!=mid+1&&j!=high+1){
            if(num[i]<num[j]){
                tmp[k++]=num[i++];
            }
            else{
                tmp[k++]=num[j++];
            }
        }
        while(i!=mid+1){
            tmp[k++]=num[i++];
        }
        while(j!=high+1){
            tmp[k++]=num[j++];
        }
        for(int n=0;n<tmp.length;n++){
            num[n+low]=tmp[n];
        }
    }
    public static void main(String args[]){
        int[] num={8,9,2,1,3,-1,-6,7,5,10,11,15,-19,-55};
        sort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }
}
