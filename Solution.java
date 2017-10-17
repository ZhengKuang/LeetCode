import java.util.*;

class Solution {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> rlist=new ArrayList<>();
        HashMap<String,Integer> pos=new HashMap<>();
        Set<String> toremove=new HashSet<>();
        Set<String> wordset=new HashSet<>();
        for(String s:wordList) wordset.add(s);
        Set<String> explored=new HashSet<>();
        explored.add(beginWord);
        wordset.remove(beginWord);
        ArrayList<String> tmp=new ArrayList<>();
        tmp.add(beginWord);
        rlist.add(tmp);
        pos.put(beginWord,pos.size());
        int distance=1;
        while(!explored.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : explored) {
                for (int j = 0; j < each.length(); j++) {
                    char[] array = each.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        array[j] = c;
                        String word = new String(array);
                        if (wordset.contains(word)) {
                            int index=pos.get(each);
                            ArrayList<String> copy=new ArrayList<>();
                            for(String s:rlist.get(index)){
                                copy.add(s);
                            }
                            copy.add(word);
                            pos.put(word,rlist.size());
                            rlist.add(copy);
                            toremove.add(word);
                            toAdd.add(word);
                        }
                    }
                }
            }
            for(String s:toremove){
                wordset.remove(s);
            }
            if (toAdd.size() == 0) return new ArrayList<>();
            explored = toAdd;
            distance++;
        }
        List<List<String>> cleanList=new ArrayList<>();
        for(List<String> myeach:rlist){
            if(myeach.size()==distance-1){
                String word=myeach.get(myeach.size()-1);
                int count=0;
                for(int i=0;i<word.length();i++){
                    if(word.charAt(i)!=endWord.charAt(i)) count++;
                }
                if(count==1) myeach.add(endWord);
                cleanList.add(myeach);
            }
        }
        return cleanList;
    }



    public static void main(String args[]){
        char tmp='a';
        System.out.println((int)('a'));
        String s1="red";
        String s2="tax";
        List<String> arraylist=new ArrayList<String>();
        //["hot","dot","dog","lot","log","cog"]
        arraylist.add("ted");
        arraylist.add("tex");
        arraylist.add("red");
        arraylist.add("tax");
        arraylist.add("tad");
        arraylist.add("den");
        arraylist.add("rex");
        arraylist.add("pee");
        List<List<String>> rlist=findLadders(s1,s2,arraylist);
        int i=1;

    }
}