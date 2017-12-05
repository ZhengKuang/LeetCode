import java.io.*;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

class Test implements Comparable{

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
/*        Scanner in = new Scanner(new File("adder2.txt"));

        Test cal = new Test();

        String equation = in.nextLine();
        while(equation.equals("END")==false){
            System.out.println( cal.eval("("+equation+")") ); // safe zone
            equation = in.nextLine();
        }
        in.close();
        */
 /*       String s="a(sssss)b";
        System.out.println(s.indexOf(')'));
        System.out.println(s.substring(s.indexOf('(')+1,s.indexOf(')')));
        String startDate="27/09/2016:05:22";
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy:hh:mm");
        Date date;
        try{
            date=df.parse(startDate);
            String k=df.format(date);
            System.out.println(k);
        }
        catch (Exception e){
            e.printStackTrace();
        }
*/

        String s="123456";
        System.out.println(s.substring(0,6));
        try {
            //inputformater.parse("27/Sep/2016:05:22:00 +0000")
            SimpleDateFormat inputformater=new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z");
            inputformater.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = inputformater.parse("27/Sep/2016:05:22:00 +0300");
            Date date2 = inputformater.parse("27/Sep/2016:05:23:00 +0300");
            long elapsed= date2.getTime()-date.getTime();

       //     Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
       //     cal.setTime(date);
            System.out.println(date);
            System.out.println(inputformater.format(date));
            System.out.println(elapsed);
      /*      SimpleDateFormat outputfomart=new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z");
            System.out.println(outputfomart.format(cal.getTime()));
            Format formatter = new SimpleDateFormat("Z");
            String s1 = formatter.format(new Date());
            System.out.println(s1);
            */
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


