import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

public class BucketSort {
    public static void main(String args[]) {
        int[] a = {1, 41, 32, 65, 44, -99, -32, 56, 73, 84};
      //  int[] a={0,2,1,3,4};
        bucketSort(a,11);
        System.out.println(Arrays.toString(a));

    }

    public static void bucketSort(int[] num, int bucketSize) {
        int max = num[0], min = num[0];
        double gap;
        for (int i = 0; i < num.length; i++) {
            if (max < num[i]) {
                max = num[i];
            }
            if (min > num[i]) {
                min = num[i];
            }
        }
        gap = (double) (max - min) / bucketSize;
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < num.length; i++) {
            if(num[i]!=max) {
                bucketList.get((int) ((num[i] - min) / gap)).add(num[i]);
            }
            else{
                bucketList.get((int) ((num[i] - min) / gap)-1).add(num[i]);
            }
        }
        int index=0;
        for(int i=0;i<bucketSize;i++){
            Integer[] list=new Integer[bucketList.get(i).size()];
            list=bucketList.get(i).toArray(list);
            InsertionSort(list);
            for(int j=0;j<list.length;j++){
                num[index++]=list[j];
            }
        }
    }

    public static void InsertionSort(Integer[] num){
        for(int i=1;i<num.length;i++){
            int index=i;
            if(index>=1&&num[index]<num[index-1]){
                int tmp=num[index];
                num[index]=num[index-1];
                num[index-1]=tmp;
                index--;
            }
        }
    }
}
