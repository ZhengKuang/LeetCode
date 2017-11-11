/**
 * Created by zhengkuang on 11/5/17.
 */
public class RegularExpressionMatching {
    public static boolean isMatch(String s,String p){
        int i=0,j=0;
        while(i<s.length()&&j<p.length()){
            if(p.charAt(j)=='*'){
                if(j==0) return false;
                char c=p.charAt(j-1);
                if(c=='.'){
                    char skip=s.charAt(i);
                    while(i<s.length()&&s.charAt(i)==skip) i++;
                    j++;
                }
                else{
                    char skip=p.charAt(j-1);
                    if(j<p.length()-1&&p.charAt(j+1)==skip){
                        int counti=0,countj=0;
                        j=j+1;
                        while(i<s.length()&&s.charAt(i)==skip){
                            counti++;
                            i++;
                        }
                        while(j<p.length()&&p.charAt(j)==skip){
                            countj++;
                            j++;
                        }
                        if(counti<countj) return false;
                    }
                    else{
                        while(i<s.length()&&s.charAt(i)==skip) i++;
                        j++;
                    }

                }
            }
            else if(p.charAt(j)=='.'){
                j++;
                i++;
            }
            else{
                if(j<p.length()-1&&p.charAt(j+1)=='*') j++;
                else if(p.charAt(j)==s.charAt(i)) {
                    j++;
                    i++;
                }
                else return false;
            }
        }
        if(i!=s.length()||j!=p.length()) return false;
        return true;
    }


    public static void main(String args[]){
        String a="aaa";
        String b="ab*a*c*a";
        System.out.println(isMatch(a,b));
    }
}
