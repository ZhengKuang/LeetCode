import java.io.*;
import java.util.*;

class Test{

    HashMap<Character, Integer> prioriy;

    Test(){
        prioriy = new HashMap<Character, Integer>();
        prioriy.put('+',1);
        prioriy.put('-',1);
        prioriy.put('*',2);
        prioriy.put('/',2);
        prioriy.put('^',3);
        prioriy.put('(',0);
    }

    int eval(String equation){
        int num = 0;
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();

        for(int i=0;i<equation.length();++i){
            char next = equation.charAt(i);
            switch (next){
                case '(':
                    ops.add(next);
                    break;
                case ')':
                    while(ops.peek()!= '('){
                        nums.add( cal( nums.pop(), nums.pop(), ops.pop()) );
                    }
                    ops.pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                    if( ops.isEmpty() || prioriy.get(next)>prioriy.get(ops.peek()) ) {
                        ops.add(next);
                    }else {
                        nums.add(cal(nums.pop(), nums.pop(), ops.pop()));
                        ops.add(next);
                    }
                    // deal with it
                    break;
                default: // deal with number
                    num = num*10+(int)(next-'0');
                    if( Character.isDigit(equation.charAt(i+1))==false ){
                        nums.add(num);
                        num = 0;
                    }
            }
        }

        return nums.pop();
    }

    int cal(int second, int first, char op){
        switch (op){
            case '+':
                return first+second;
            case '-':
                return first-second;
            case '*':
                return first*second;
            case '/':
                return first/second;
            case '^':
                return (int)Math.pow(first,second);
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("adder2.txt"));

        Test cal = new Test();

        String equation = in.nextLine();
        while(equation.equals("END")==false){
            System.out.println( cal.eval("("+equation+")") ); // safe zone
            equation = in.nextLine();
        }
        in.close();
    }
}


