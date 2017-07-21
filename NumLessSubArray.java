import java.util.LinkedList;

public class NumLessSubArray {
    public static int numberOfSub(int[] array,int num){
        int i=0,j=0,number=0;
        LinkedList<Integer> dequeMax=new LinkedList<>();
        LinkedList<Integer> dequeMin=new LinkedList<>();
        for(;i<array.length;i++) {
            for(;j<array.length;j++) {
                while (!dequeMax.isEmpty() && array[dequeMax.peekLast()] <= array[j]) {
                    dequeMax.pollLast();
                }
                dequeMax.addLast(j);
                while (!dequeMin.isEmpty() && array[dequeMin.peekLast()] >= array[j]) {
                    dequeMin.pollLast();
                }
                dequeMin.addLast(j);
                if (dequeMax.peekFirst() - dequeMin.peekFirst() > num) {
                    break;
                }
                j++;
            }
            if(dequeMax.peekFirst()<=i){
                dequeMax.pollFirst();
            }
            if(dequeMin.peekFirst()<=i){
                dequeMin.pollFirst();
            }
            number+=j-i;
            i++;
        }

        return number;
    }

    public static int[] getRandomArray(int len){
        int []array=new int[len];
        for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*10);
        }
        return array;
    }
    public static void main(String args[]){
        int[] array=getRandomArray(5);
        int num=5;
        int numSub=numberOfSub(array,num);
        System.out.println(numSub);
    }
}
