import java.util.Stack;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]<target){
                if(nums[end]<target&&nums[start]>=nums[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else if(nums[mid]>target){
                if(nums[start]>target&&nums[start]<=nums[mid]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            else return mid;
        }
        return -1;
    }
    public static boolean exist(char[][] board, String word) {
        if(word==null||word.length()==0) return false;
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean answer=backTracking(board,i,j,word,0,visited);
                if(answer==true) return true;
            }
        }
        return false;
    }

    public static boolean backTracking(char[][] board, int i, int j, String word, int index, boolean[][] visited){
//        System.out.println("i is: "+i+" j is"+j);
        if(i==-1||i==board.length||j==-1||j==board[0].length) return false;
        if(visited[i][j]==false){
            visited[i][j]=true;
            if(board[i][j]==word.charAt(index)){
                if(index==word.length()-1) return true;
                else
                return backTracking(board,i+1,j,word,index+1,visited)||backTracking(board,i-1,j,word,index+1,visited)||
                        backTracking(board,i,j+1,word,index+1,visited)||backTracking(board,i,j-1,word,index+1,visited);

            }
            else{
                visited[i][j]=false;
                return false;
            }
        }
        return false;
    }
    public static void main(String args[]){
   //     int[] num=new int[]{1,3};
   //     System.out.println(Math.pow(-2,-1));
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s="ABCCED";
        Stack<Integer> stack=new Stack<>();
        System.out.println(stack.peek());
   //     System.out.println(exist(board,s));
    }
}
