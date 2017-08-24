import java.lang.reflect.Array;
import java.util.Arrays;

public class CountingSort {
    public static int[] countingSort(int num[]){
        if(num==null||num.length==0){
            return null;
        }
        int max=num[0],min=num[0];
        for(int i=0;i<num.length;i++){
            if(max<num[i]){
                max=num[i];
            }
            if(min>num[i]){
                min=num[i];
            }
        }
        if(max==min) return num;
        int range=max-min+1;
        int[] rangeArray=new int[range];
        for(int i=0;i<num.length;i++){
            rangeArray[num[i]-min]++;
        }
        int sum=0;
        for(int i=0;i<rangeArray.length;i++){
            sum+=rangeArray[i];
            rangeArray[i]=sum;
        }
        int[] renum=new int[num.length];
        for(int i=0;i<num.length;i++){
            renum[rangeArray[num[i]-min]-1]=num[i];
            rangeArray[num[i]-min]--;
        }
        return renum;
    }

    public static void main(String args[]){
        int[] a={3,2,1,5,4,7,8,9,6,10,5,4,3};

        System.out.println(Arrays.toString(countingSort(a)));
    }
}
