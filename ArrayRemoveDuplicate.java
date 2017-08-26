import java.util.Arrays;
import java.util.Scanner;

public class ArrayRemoveDuplicate {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Please input number");
        int number=0;
        while(s.hasNext()){
            number=Integer.valueOf(s.next());
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
        remove(array);
    }

    public static void remove(int [] num){
        int location=1;
        for(int pointer=1;pointer<num.length;pointer++){
            if(num[pointer-1]!=num[pointer]){
                num[location++]=num[pointer];
            }
        }
        for(int i=0;i<location;i++){
            System.out.print(num[i]);
        }
    }
}
