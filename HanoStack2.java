import java.util.Stack;

public class HanoStack2 {
    Stack<Integer> lStack;
    Stack<Integer> mStack;
    Stack<Integer> rStack;
    int num;

    public HanoStack2(int num){
        lStack=new Stack<>();
        mStack=new Stack<>();
        rStack=new Stack<>();
        lStack.push(Integer.MAX_VALUE);
        mStack.push(Integer.MAX_VALUE);
        rStack.push(Integer.MAX_VALUE);
        for(int i=num;i>0;i--){
            lStack.push(i);
        }
        this.num=num;
    }

    public enum Action{
        No,LM,ML,RM,MR
    }

    private Action[] actionList={Action.No};

    public void process(){
        for(int i=0;rStack.size()!=num+1;i++){
            move(actionList,lStack,mStack,Action.LM,Action.ML,"left","mid");
            move(actionList,mStack,lStack,Action.ML,Action.LM,"mid","left");
            move(actionList,rStack,mStack,Action.RM,Action.MR,"right","mid");
            move(actionList,mStack,rStack,Action.MR,Action.RM,"mid","right");
        }
    }

    public void move(Action[] list,Stack<Integer> fstack,Stack<Integer> tstack,Action nextAction,Action preNoAction,String from,String to){
        if(list[0]!=preNoAction&&fstack.peek()<tstack.peek()){
            System.out.println("move "+from+" to "+to);
            tstack.push(fstack.pop());
            list[0]=nextAction;
        }
    }

    public static void main(String args[]){
        HanoStack2 hs2=new HanoStack2(3);
        hs2.process();
    }

}