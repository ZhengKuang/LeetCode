public class HanoStack {
    private String from;
    private String to;
    private String help;
    private int level;
    public HanoStack(String from,String to,String help, int level){
        this.from=from;
        this.to=to;
        this.help=help;
        this.level=level;
        print(from,to,help,level);
    }

    public void print(String from,String to,String help, int level){
        if(!help.equals("mid")){
            if(level==1){
                System.out.println("move "+level+" from "+from+" to "+to);
                return;
            }
            print(from,help,to,level-1);
            System.out.println("move "+level+" from "+from+" to "+to);
            print(help,to,from,level-1);
            return;
        }
        else{
            if(level==1){
                System.out.println("move "+level+" from "+from+" to "+help);
                System.out.println("move "+level+" from "+help+" to "+to);
                return;
            }
            print(from,to,help,level-1);
            System.out.println("move "+level+" from "+from+" to "+help);
            print(to,from,help,level-1);
            System.out.println("move "+level+" from "+help+" to "+to);
            print(from,to,help,level-1);
            return;
        }
    }
    public static void main(String args[]){
        HanoStack hs=new HanoStack("left","mid","right",3);
    }
}
