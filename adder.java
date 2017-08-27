import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class adder {
    public static void add(String line){
        Stack<Integer> nums=new Stack<>();
        Stack<Character>  operation=new Stack<>();;
        int number=0;
        for(int i=0;i<line.length();i++){
            char ch=line.charAt(i);
            switch(ch){
                case '+':
                case '-':
                    nums.add(number);
                    number=0;
                    if(nums.size()>1){
                        nums.push((cal(nums.pop(),nums.pop(),operation.pop())));
                    }
                    operation.add(ch);
                    break;
                default:
                   number=number*10+(int)(ch-'0');
            }
        }
        nums.add(number);
        if(nums.size()>1){
            nums.push((cal(nums.pop(),nums.pop(),operation.pop())));
        }
        System.out.println(nums.pop());
    }

    public static int cal(int number1,int number2,char operation){
        switch (operation){
            case '+':
                return number2+number1;
            case '-':
                return number2-number1;
            default:
                return -1;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File("adder.txt"));
        String s=scanner.nextLine();
        while(!s.equals("END")){
            add(s);
            s=scanner.nextLine();
        }
    }
}
