/**
 * Created by zhengkuang on 12/10/17.
 */
import java.util.*;
public class MergeStream {
    static class Stream{
        public int key;
        public String value;
        public long timestamp;
        public Stream(int key, String value,long timestamp){
            this.key=key;
            this.value=value;
            this.timestamp=timestamp;
        }

        public String toString(){
            return key+" "+value+" "+timestamp;
        }
    }

    public static List<Stream> merge(List<Stream> l1, List<Stream>l2){
        List<Stream> ans=new ArrayList<>();
        int p1=0;
        int p2=0;
        while(p1!=l1.size()&&p2!=l2.size()){
            Stream s1=l1.get(p1);
            Stream s2=l2.get(p2);
            if(s1.key<s2.key) {
                ans.add(s1);
                p1++;
            }
            else if(s1.key>s2.key) {
                ans.add(s2);
                p2++;
            }
            else{
                if(s1.timestamp>s2.timestamp) ans.add(s1);
                else ans.add(s2);
                p1++;
                p2++;
            }
        }
        while(p1!=l1.size()){
            ans.add(l1.get(p1));
            p1++;
        }
        while(p2!=l2.size()){
            ans.add(l2.get(p2));
            p2++;
        }
        return ans;
    }

    public static void main(String args []){
        Stream s1=new Stream(1,"k",1);
        Stream s2=new Stream(2,"z",2);
        Stream s3=new Stream(3,"y",3);
        List<Stream> l1=new ArrayList<>();
        l1.add(s1);
        l1.add(s2);
        l1.add(s3);
        Stream s4=new Stream(1,"kk",1);
        Stream s5=new Stream(2,"zz",3);
        Stream s6=new Stream(3,"yy",2);
        List<Stream> l2=new ArrayList<>();
        l2.add(s4);
        l2.add(s5);
        l2.add(s6);
        List<Stream> ans=merge(l1,l2);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
