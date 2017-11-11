/**
 * Created by zhengkuang on 11/7/17.
 */
import java.util.*;
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0) return answer;
        int[][] visited=new int[matrix.length][matrix[0].length];
        dfs(matrix,visited,0,0,0,answer);
        return answer;
    }
    //0 right 1 down 2 left 3 up
    public static void dfs(int[][] matrix, int[][] visited, int direction, int i, int j, List<Integer> answer){
        int row=i;
        int col=j;
        if((i>=0&&i<matrix.length&&j>=0&&j<matrix[0].length)) return;
        if(visited[i][j]==1) return;
        while(col<matrix[0].length&&visited[row][col]==0){
            answer.add(matrix[row][col]);
            visited[row][col]=1;
            col++;
        }
        col--;
        row++;
        while(row<matrix.length&&visited[row][col]==0){
            answer.add(matrix[row][col]);
            visited[row][col]=1;
            row++;
        }
        row--;
        col--;
        while(col>=0&&visited[row][col]==0){
            answer.add(matrix[row][col]);
            visited[row][col]=1;
            col--;
        }
        col++;
        row--;
        while(row>=0&&visited[row][col]==0){
            answer.add(matrix[row][col]);
            visited[row][col]=1;
            row--;
        }
        row++;
        col++;
        dfs(matrix,visited,direction,row,col,answer);
        return;
    }

    public static void main(String[] args){
        int[][] matrix=new int[1][1];
        matrix[0]=new int[]{1};
        spiralOrder(matrix);
        String c="abcde".substring(5);
        System.out.println("abcde".substring(5));
    }
}
