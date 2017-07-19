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
        int max=0;
        for(int i=0;i<help.length;i++){
            int left=0,right=0,start=i;
            while(start>0){
                if(help[--start]>=help[i]) left++;
            }
            start=i;
            while(start<help.length-1){
                if(help[++start]>=help[i]) right++;
            }
            max=max>=(left+right+1)* help[i]?max:(left+right+1)* help[i];
        }
        return max;
    }
    public static void main(String args[]){
        int[][] map={ { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 },{1,1,1,1}};
        int a=map.length;
        int b=map[0].length;
        System.out.println(maxRecSize(map));;
    }
}
