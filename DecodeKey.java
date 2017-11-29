import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhengkuang on 11/18/17.
 */
public class DecodeKey {
    public static void main(String args[]) {
        char[] s1 = new String("Your friend, Alice").toCharArray();
        char[] s2 = new String("Atvt hrqgse, Cnikg").toCharArray();
        int[] dif = new int[s1.length];
        for (int i = 0; i < dif.length; i++) {
            dif[i]=(int)s2[i]-(int)s1[i];
            if(dif[i]<0){
                dif[i]=26-Math.abs(dif[i]);
            }
        }
        ArrayList<Integer> rs=new ArrayList<>();
        for(int i:dif){
            if(i!=0) rs.add(i);
        }
        int[] rspace=new int[rs.size()];
        String s="";
        for(int i=0;i<rs.size();i++){
            rspace[i]=rs.get(i);
            s=s+String.valueOf(rspace[i]);
        }

        //find duplicate
        System.out.println(Dup("12341"));
    }

    public static String Dup(String array){
        char aim=array.charAt(0);
        int s=array.indexOf(aim,1);
        String ans=array;
        while(s!=-1){
            int length=s;
            if(s+length>array.length()){  //incomplete
                if(array.substring(0,length).contains(array.substring(s))){
                    ans=array.substring(0,length);
                    break;
                }
                else break;
            }
            else{ //complete or key is array
                if(array.substring(0,length).equals(array.substring(s,s+length))){
                    String aims=array.substring(0,length);
                    int begin=s;
                    int i=0;
                    boolean flag=true;
                    while(begin+i<array.length()&&flag){
                        if(array.charAt(begin+i)!=aims.charAt(i%length)){
                            flag=false;
                        }
                        i++;
                    }
                    if(flag) {
                        ans=ans.substring(0,length);
                        return ans;
                    }
                }
            }
            s=array.indexOf(aim,s+1);
        }
        return ans;
    }
}
