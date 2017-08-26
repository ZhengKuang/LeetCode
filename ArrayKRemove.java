import java.util.Arrays;
import java.util.Scanner;

public class ArrayKRemove {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Please input number");
        int number=0;
        while(s.hasNext()){
            number=Integer.valueOf(s.next());
            break;
        }
        int k=0;
        System.out.println("Please input k");
        while(s.hasNext()){
            k=Integer.valueOf(s.next());
            break;
        }
        int[] array=new int[number];
        int i=0;
        System.out.println("Please input array");
        while(s.hasNext()){
            String sr=s.next();
            if(sr.equals("-1")) break;
            array[i++]=Integer.valueOf(sr);
            if(i==number) break;
        }
        System.out.println(Arrays.toString(array));
        remove(array,k);
    }

    public static void remove(int [] num,int length){
        int location=1;
        int k=1;
        for(int pointer=1;pointer<num.length;pointer++){
            if(num[pointer-1]==num[pointer]){
                k++;
            }
            if(num[pointer-1]!=num[pointer]){
                k=1;
            }
            if(k<=length){
                num[location++]=num[pointer];
            }
        }
        for(int i=0;i<location;i++){
            System.out.print(num[i]);
        }
    }
}