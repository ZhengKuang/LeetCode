import java.util.HashSet;

/**
 * Created by zhengkuang on 12/4/17.
 */
public class MinRect {
    public static void main(String args[]){
        int[][] array=new int[][]{{1,1},{1,2},{1,3},{1,4},{0,1},{0,2},{0,3},{0,4},{-1,-1},{-1,3},{-1,6}};
        System.out.println(minRect(array));
    }

    public static int minRect(int[][] matrix){
        int min=Integer.MAX_VALUE;
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            set.add(matrix[i][0]+","+matrix[i][1]);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix.length;j++){
                if(matrix[i][0]==matrix[j][0]||matrix[i][1]==matrix[j][1]) continue;
                else{
                    //This is a diagonal
                    if(set.contains(matrix[i][0]+","+matrix[j][1])&&set.contains(matrix[j][0]+","+matrix[i][1])){
                        int area=Math.abs(matrix[i][0]-matrix[j][0])*Math.abs(matrix[i][1]-matrix[j][1]);
                        min=Math.min(area,min);
                    }
                }
            }
        }
        return min;
    }
}
