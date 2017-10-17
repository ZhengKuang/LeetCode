import java.util.List;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by zhengkuang on 10/13/17.
 */
public class MostFrequentColor {
    public List<String> getFrequent(List<List<String>> lists){
        HashMap<String, Integer> map=new HashMap<>();
        List<String> rlist=new ArrayList<String>();
        int max=0;
        for(List<String> list:lists){
            for(String s:list){
                if(map.get(s)!=null){
                    int fre=map.get(s);
                    fre++;
                    map.put(s,fre);
                    max=Math.max(fre,max);
                }
                else{
                    map.put(s,0);
                }
            }
        }
        for(String s:map.keySet()){
            if(map.get(s)==max){
                rlist.add(s);
            }
        }
        Collections.sort(rlist);
        return rlist;
    }
    public static void main(String args[]){
        MostFrequentColor c=new MostFrequentColor();
        ArrayList<String> list=new ArrayList<>();
        list.add("yellow");
        list.add("red");
        list.add("yellow");
        list.add("white");
        list.add("red");
        list.add("red");
        ArrayList<String> list2=new ArrayList<>();
        list.add("blue");
        list.add("blue");
        list.add("blue");
        list.add("green");
        list.add("green");
        list.add("green");
        List<List<String>> input=new ArrayList<>();
        input.add(list);
        input.add(list2);
        System.out.print(c.getFrequent(input).toString());

    }
}
