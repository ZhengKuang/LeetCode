import java.util.*;

class LongestParentheses{
    public static int longestValidParentheses(String s){
        boolean[] valid=new boolean[s.length()];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(!stack.isEmpty()&&s.charAt(stack.peek())=='('&&cur==')'){
                int index=stack.pop();
                valid[i]=true;
                valid[index]=true;
            }
            else stack.push(i);
        }
        int max=0;
        int tmp=0;
        for(boolean i:valid){
            if(i==true){
                tmp++;
                max=Math.max(tmp,max);
            }
            else tmp=0;
        }
        HashSet<String> cur=new HashSet<>();
        return max;

    }

    public static String longestWord(String[] words) {
        Queue<String> cur=new LinkedList<>();
        HashSet<String> allset=new HashSet<>();
        for(String word:words){
            if(word.length()==1) cur.add(word);
            allset.add(word);
        }
        boolean hasNext=true;
        ArrayList<String> list=new ArrayList<>();
        ArrayList<String> toadd=new ArrayList<>();
        while(!cur.isEmpty()&&hasNext) {
            int size = cur.size();
            hasNext=false;
            toadd.clear();
            while (size > 0) {
                String tmp = cur.poll();
                toadd.add(tmp);
                for (char c = 'a'; c <= 'z'; c++) {
                    String newtmp = tmp + c;
                    if (allset.contains(newtmp)){
                        cur.add(newtmp);
                        hasNext=true;
                    }
                }
                size--;
            }
            if(hasNext==false) {
                list=new ArrayList<>(toadd);
            }

        }
        Collections.sort(list);
        return list.size()==0?"":list.get(0);
    }
    public  List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,ArrayList<Integer>> map=new HashMap<>();
        List<List<String>> answer=new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            List<String> person=accounts.get(i);
            for(int j=1;j<person.size();j++){
                String email=person.get(j);
                if(map.get(email)==null){
                    ArrayList<Integer> adr=new ArrayList<>();
                    adr.add(i);
                    map.put(email,adr);
                }
                else{
                    ArrayList<Integer> adr=map.get(email);
                    adr.add(i);
                }
            }
        }

        int[] visited=new int[accounts.size()];
        for(int i=0;i<accounts.size();i++){
            if(visited[i]==0) {
                HashSet<String> curmail=new HashSet<>();
                String name=dfs(answer,curmail,i,accounts,map,visited);
                List<String> merge_P=new ArrayList<>();
                List<String> merge_email=new ArrayList<>(curmail);
                Collections.sort(merge_email);
                merge_P.add(name);
                merge_P.addAll(merge_email);
                answer.add(merge_P);
            }
        }
        return answer;
    }

    public String dfs(List<List<String>> answer, HashSet<String> curmail, int index,List<List<String>> accounts,HashMap<String,ArrayList<Integer>> map,int[] visited){
        visited[index]=1;
        List<String> person=accounts.get(index);
        String name=person.get(0);
        for(int i=1;i<person.size();i++){
            String email=person.get(i);
            curmail.add(email);
            ArrayList<Integer> tovisit=map.get(email);
            for(int j=0;j<tovisit.size();j++) {
                int to_index = tovisit.get(j);
                if (visited[to_index] == 0) {
                    dfs(answer, curmail, to_index, accounts, map, visited);
                }
            }
        }
        return name;
    }


 //   [["Kevin","Kevin1@m.co","Kevin5@m.co","Kevin2@m.co"],["Bob","Bob3@m.co","Bob1@m.co","Bob2@m.co"],["Lily","Lily3@m.co","Lily2@m.co","Lily0@m.co"],["Gabe","Gabe2@m.co","Gabe0@m.co","Gabe2@m.co"],["Kevin","Kevin4@m.co","Kevin3@m.co","Kevin3@m.co"]]
//[["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],["David","David4@m.co","David5@m.co"],["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]
//[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
    public static void main(String args[]){
       List<List<String>> accounts=new ArrayList<>();
       String[] tmp=new String[]{"John","johnsmith@mail.com","john_newyork@mail.com"};
       accounts.add(new ArrayList<String>(Arrays.asList(tmp)));
       tmp=new String[]{"John","johnsmith@mail.com","john00@mail.com"};
        accounts.add(new ArrayList<String>(Arrays.asList(tmp)));
        tmp=new String[]{"Mary","mary@mail.com"};
        accounts.add(new ArrayList<String>(Arrays.asList(tmp)));
        tmp=new String[]{"John","johnnybravo@mail.com"};
        accounts.add(new ArrayList<String>(Arrays.asList(tmp)));
//        tmp=new String[]{"David","David1@m.co","David2@m.co"};
//        accounts.add(new ArrayList<String>(Arrays.asList(tmp)));

//        accountsMerge(accounts);
    }
}