import java.util.*;

class Foursum2{
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int sum=A[i]+B[j];
                if(map.get(sum)==null){
                    map.put(sum,0);
                }
                else{
                    int fre=map.get(sum);
                    map.put(sum,fre+1);
                }
            }
        }

        int answer=0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                int sum=C[i]+D[j];
                answer=answer+(map.get(sum)==null?0:map.get(sum));
            }
        }
        return answer;
    }

    public static void main(String args[]){

    }
}