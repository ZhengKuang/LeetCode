import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class Problem
{
    public static void main(String[] args)
    {

        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNextLine())
        {
            String aim=stdin.nextLine();
            try{
                int num = Integer.parseInt(aim);
                System.out.println(myDFS(num));
                // is an integer!
            } catch (NumberFormatException e) {
                // not an integer!
                ;
            }

        }
        stdin.close();
    }

    public static int myDFS(int aim){
        ArrayList<ArrayList<Integer>> answer=new ArrayList<>();
        for(int i=0;i<=(int)Math.sqrt(aim);i++){
            helper(aim,new ArrayList<Integer>(),answer,0,i);
        }
        int dfsanswer=0;
        for(ArrayList<Integer> list:answer){
            for(Integer i:list) dfsanswer+=i;
        }
        return dfsanswer;
    }


    public static int helper(int aim, ArrayList<Integer> currentset, ArrayList<ArrayList<Integer>> answer,int currentsum, int currentIndex){
        currentsum=currentsum+currentIndex*currentIndex;
        currentset.add(currentIndex);
        if(currentsum>aim){
            currentset.remove(currentset.size()-1);
            return 0;
        }
        if(currentset.size()==3){
            if(currentsum==aim){
                ArrayList<Integer> a=new ArrayList<>();
                for(int i:currentset) a.add(i);
                currentset.remove(currentset.size()-1);
                answer.add(a);
                return 1;
            }
            else{
                currentset.remove(currentset.size()-1);
                return 0;
            }
        }
        int tmpanswer=0;
        for(int i=currentIndex;i<=(int) Math.sqrt(aim);i++){
            tmpanswer+=helper(aim,currentset,answer,currentsum,i);
        }
        if(tmpanswer==0){
            currentset.remove(currentset.size()-1);
            return 0;
        }
        else{
            currentset.remove(currentset.size()-1);
            return 1;
        }

    }

    public static int dp(int aim){
        int[] dp=new int[aim];
        dp[0]=0;
        for(int i=0;i<aim;i++){

        }
        return dp[aim-1];
    }

}
