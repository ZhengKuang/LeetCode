import java.util.*;
class SimsonFamily{
    static class Node{
        public String name;
        public List<Node> nei;
        public Node(String name){
            this.name=name;
            this.nei=new ArrayList<>();
        }

        public void addKid(Node kid){
            nei.add(kid);
            kid.nei.add(this);
        }
    }

    public static int getDistance(Node n1,Node n2){
        HashSet<Node> visited=new HashSet<>();
        return dfs(n1,n2,visited);
    }

    public static int dfs(Node n1,Node n2, HashSet<Node> visited){
        if(visited.contains(n1)) return -1;
        visited.add(n1);
        if(n1==n2) return 0;
        for(Node tmp:n1.nei){
            int ans=dfs(tmp,n2,visited);
            if(ans!=-1) return ans+1;
        }
        return -1;
    }


    public static void main(String args[]){
        Node n1=new Node("ABE MONA");
        Node n2=new Node("HERB");
        Node n3=new Node("HOMER MARGE");
        Node n4=new Node("BART");
        Node n5=new Node("LISA");
        Node n6=new Node("MAGGIE");
        Node n7=new Node("CLANCY JAC");
        Node n8=new Node("PATTY");
        Node n9=new Node("SELMA");
        Node n10=new Node("LING");
        n1.addKid(n2);
        n1.addKid(n3);
        n3.addKid(n4);
        n3.addKid(n5);
        n3.addKid(n6);
        n7.addKid(n3);
        n7.addKid(n8);
        n7.addKid(n9);
        n9.addKid(n10);
        SimsonFamily sf=new SimsonFamily();
        System.out.println(sf.getDistance(n1,n10));
        System.out.println(sf.getDistance(n1,n2));
        System.out.println(sf.getDistance(n1,n4));


    }

}