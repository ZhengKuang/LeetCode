import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class adder2 {
    public static boolean priority(char stack,char cur){
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        map.put('^',3);
        map.put('(',0);
        return map.get(cur)<=map.get(stack)?true:false;
    }
    public static void add(String line){
        Stack<Integer> nums=new Stack<>();
        Stack<Character>  operation=new Stack<>();
        int number=0;
        for(int i=0;i<line.length();i++){
            char ch=line.charAt(i);
            switch(ch){
                case '(':
                    operation.add(ch);
                    break;
                case ')':
                    while(!operation.peek().equals('(')){
                        nums.push((cal(nums.pop(),nums.pop(),operation.pop())));
                    }
                    operation.pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                    if(operation.empty()||!priority(operation.peek(),ch)){
                        operation.add(ch);
                    }
                    else if(nums.size()>1&&priority(operation.peek(),ch)){
                        nums.push((cal(nums.pop(),nums.pop(),operation.pop())));
                        if(nums.size()>1&&priority(operation.peek(),ch)){
                            nums.push((cal(nums.pop(),nums.pop(),operation.pop())));
                        }
                        operation.add(ch);
                    }
                    break;
                default:
                    number=number*10+(int)(ch-'0');
                    if(i==line.length()-1||!Character.isDigit(line.charAt(i+1))){
                        nums.add(number);
                        number=0;
                    }
            }
        }
        System.out.println(nums.pop());
    }

    public static int cal(int number1,int number2,char operation){
        switch (operation){
            case '+':
                return number2+number1;
            case '-':
                return number2-number1;
            case '*':
                return number2*number1;
            case '/':
                return number2/number1;
            case '^':
                return (int)Math.pow(number2,number1);
            default:
                return -1;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File("adder2.txt"));
        String s=scanner.nextLine();
        while(!s.equals("END")){
            add('('+s+')');
            s=scanner.nextLine();
        }
    }
}
