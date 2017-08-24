import java.util.Arrays;

public class SelectionSort {
    public static void main(String args[]){
        int a[]={3,2,4,5,1,6,7,4,8};
        selection(a);
        System.out.print(Arrays.toString(a));
    }

    public static void selection(int []num){
        for(int i=0;i<num.length;i++){
            int minIndex=i;
            for(int j=i+1;j<num.length;j++){
                if(num[j]<num[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                swap(num,minIndex,i);
            }
        }
    }

    public static void swap(int[] num,int minIndex,int i){
        int tmp=num[minIndex];
        num[minIndex]=num[i];
        num[i]=tmp;
    }
}
