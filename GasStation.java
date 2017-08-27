import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GasStation {
    public static void printBegin(int[] gas,int[] dis){
        Queue<Integer> queue=new LinkedList<>();
        if(gas==null||dis==null) return;
        int[] income=new int[gas.length];
        int sum=0;
        for(int i=0;i<income.length;i++){
            income[i]=gas[i]-dis[i];
            sum+=income[i];
        }
        if(sum<0){
            System.out.println("There is no suitable starting point for car to run a circle");
            return;
        }
        int index=0;
        int queuesum=0;
        while(queue.size()!=income.length){
            queue.add(income[index]);
            queuesum+=income[index];
            index=index==income.length-1?0:index+1;
            while(queuesum<0){
                queuesum-=queue.poll();
            }
        }
        System.out.println("The begin value is: "+queue.poll());


    }
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s=new Scanner(new File("GasStation.txt"));
        int npair=s.nextInt();
        int[] gas=new int[npair];
        int[] distance=new int[npair];
        int stop=0;
        while(stop!=-1){
            for(int i=0;i<npair;i++) {
                gas[i] = s.nextInt();
                distance[i] = s.nextInt();
            }
            stop=s.nextInt();
        }
        printBegin(gas,distance);

    }
}
