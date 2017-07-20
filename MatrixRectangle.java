import java.util.Stack;

public class MatrixRectangle {
    public static int maxRecSize(int[][] map){
        int rowSize=map.length;
        int columnSize=map[0].length;
        int max=0;
        int[] help=new int[columnSize];
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<columnSize;j++){
                if(map[i][j]==1){
                    help[j]++;
                }
                else{
                    help[j]=0;
                }
            }
            max=max>=getMax(help)?max:getMax(help);
        }
        return max;
    }
    public static int getMax(int[] help){
        int columnSize=help.length;
        Stack<Integer> stack=new Stack<>();
        int max=0;
        for(int i=0;i<help.length;i++){
          while(!stack.isEmpty()&&help[stack.peek()]>=help[i]){
              int index=stack.pop();
              int value=stack.empty()?i*help[index]:(i-1-stack.peek())*help[index];
              max=Math.max(value,max);
          }
          stack.push(i);
        }
        int lastindex=stack.peek();
        while(!stack.isEmpty()){
            int index=stack.pop();
            int value=stack.empty()?help.length*help[index]:(lastindex-stack.peek())*help[index];
            max=Math.max(value,max);
            lastindex=index;
        }
        return max;
    }
    public static void main(String args[]){
        int[][] map={ { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 },{ 1, 1, 1, 1}};
        int a=map.length;
        int b=map[0].length;
        System.out.println(maxRecSize(map));;
    }
}
