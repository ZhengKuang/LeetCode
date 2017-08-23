import java.util.Arrays;

public class InsertionSort {
    public static void main(String args[]){
        int[] num={8,6,5,7,9};
        InsertionSort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void InsertionSort(int[] num){
        for(int i=1;i<num.length;i++){
            int index=i;
            while(index>=1&&num[index]<num[index-1]){
                int tmp=num[index];
                num[index]=num[index-1];
                num[index-1]=tmp;
                index--;
            }
        }
    }
}
