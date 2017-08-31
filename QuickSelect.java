import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSelect {
    public static void quickselect(int[]a,int k){
        Select(a,0,a.length-1,k);
    }

    public static void Select(int[]a, int start,int end, int k){
        int pivot=a[end];
        int i=start;
        int left=start;
        for(;i<end;i++) {
            if (a[i] < pivot) {
                swap(a,i,left++);
            }
        }
        int number=left-start;//because left+1了
        if(number+1==k) System.out.println(a[end]);
        else if(number+1>k) Select(a,start,left-1,k);
        else if(number+1<k) Select(a,left,end-1,k-(number+1));
    }

    public static void swap(int[]a, int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }


    public static void main(String[] args) throws FileNotFoundException{
       Scanner sc=new Scanner(new File("QuickSelect.txt"));
       int n=sc.nextInt();
       int []a=new int[n];
       while(n!=-1){
           for(int i=0;i<n;i++){
               a[i]=sc.nextInt();
           }
           int loop=sc.nextInt();
           for(int i=0;i<loop;i++){
               quickselect(a,sc.nextInt());
           }
           n=sc.nextInt();
       }
    }
}
