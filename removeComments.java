import java.util.*;


class removeComments{
    public static List<String> removeComments(String[] source) {
        StringBuilder sb = new StringBuilder();
        for(String s : source)
            sb.append(s).append("\n");
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < sb.length();) {
            int j=sb.indexOf("//",i);
            int k=sb.indexOf("/*",i);
            if(j<0&&k<0){
                sb2.append(sb.substring(i));
                break;
            }
            if(j<0||k>=0&&k<j){
                int end=sb.indexOf("*/",k+2);
                sb2.append(sb.substring(i,k));
                i=end+2;
            }
            else{
                int end=sb.indexOf("\n",j+2);
                sb2.append(sb.substring(i,j));
                i=end;
            }
        }
        List<String> answer=new ArrayList<>();
        for(int i=0;i<sb2.length();){
           int j=sb2.indexOf("\n",i);
           if(j<0) break;
           if(j>0&&sb2.charAt(j-1)!='\n') {
               answer.add(sb2.substring(i,j));
           }
           i=j+1;
        }

        return answer;
    }

    public static int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        String[] split=input.split("\n");
        for(String s:split){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            while(lev+1<stack.size()) stack.pop(); // find parent
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
        }
        return maxLen;
    }


    public static void main(String args[]){
 //       String[] source=new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
  //      System.out.println(Arrays.toString(removeComments(source).toArray()));
        String s="dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lengthLongestPath(s));
    }



}