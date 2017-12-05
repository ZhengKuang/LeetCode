import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by zhengkuang on 12/4/17.
 */
public class RectPath {
    public static void dfs(ArrayList<ArrayList<String>> path, ArrayList<String> cur, int cvalue, int aim,int ti, int tj, int ci, int cj,int[][] matrix, int[][] visited){
        if(ci<0||ci>=matrix.length||cj<0||cj>=matrix[0].length||visited[ci][cj]==1) return;
        visited[ci][cj]=1;
        if(ci==ti&&cj==tj&&cvalue+matrix[ti][tj]<aim){
            cur.add(ci+","+cj);
            path.add(new ArrayList<String>(cur));
            cur.remove(cur.size()-1);
            visited[ci][cj]=0;
            return;
        }
        if(cvalue+matrix[ti][tj]>=aim){
            visited[ci][cj]=0;
            return;
        }
        visited[ci][cj]=1;
        cvalue+=matrix[ci][cj];
        cur.add(ci+","+cj);
        dfs(path,new ArrayList<String>(cur),cvalue,aim,ti,tj,ci+1,cj,matrix,visited);
        dfs(path,new ArrayList<String>(cur),cvalue,aim,ti,tj,ci-1,cj,matrix,visited);
        dfs(path,new ArrayList<String>(cur),cvalue,aim,ti,tj,ci,cj+1,matrix,visited);
        dfs(path,new ArrayList<String>(cur),cvalue,aim,ti,tj,ci,cj-1,matrix,visited);
        cur.remove(cur.size()-1);
        visited[ci][cj]=0;
        return;
    }



    public static void main(String args[]){
        int[][] matrix=new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        int[][] visited=new int[4][4];
        int aim=7;
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        ArrayList<String> cur=new ArrayList<>();
        dfs(ans, cur, 0, aim, 3, 3, 0,0,matrix, visited);
        for(ArrayList<String> s:ans)
        System.out.println(Arrays.toString(s.toArray()));

    }
}
