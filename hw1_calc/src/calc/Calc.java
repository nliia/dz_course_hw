package calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Liia on 01.10.2016.
 */
public class Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        String[] expAr = exp.split(" ");

        Stack<String> stack = new Stack<String>();
        List result = new LinkedList<String>();
        Pattern number = Pattern.compile("[0-9]+");

        for(int i = 0; i < expAr.length; i++) {

            Matcher m = number.matcher(expAr[i]);

            if (m.matches()) {
                result.add(expAr[i]);
            } else {
                if (stack.isEmpty()) {
                    stack.push(expAr[i]);
                } else{

                    String top = stack.peek();
                Matcher t = number.matcher(top);
                switch (expAr[i]) {
                    case "*":
                    case "/":
                        if (t.matches()) {
                            stack.push(expAr[i]);
                        } else {
                            while (top.equals("*") || top.equals("/") || top.equals("^")) {
                                result.add(stack.pop());
                                if(!stack.isEmpty()){
                                    top = stack.peek();
                                }else{
                                    top = "_";
                                }
                            }
                            stack.push(expAr[i]);
                        }
                        break;

                    case "-":
                    case "+":
                        if (t.matches()) {
                            stack.push(expAr[i]);
                        } else {
                            while (top.equals("+") || top.equals("-") || top.equals("*") || top.equals("/") || top.equals("^")) {
                                result.add(stack.pop());
                                if(!stack.isEmpty()){
                                    top = stack.peek();
                                }else{
                                    top = "_";
                                }
                            }
                            stack.push(expAr[i]);
                        }
                        break;
                    case "(":
                        stack.push(expAr[i]);
                        break;
                    case ")":
                        while (!stack.peek().equals("(")) {
                            result.add(stack.pop());

                        }
                        stack.pop();
                        break;
                }
            }
        }
        }
        while(!stack.isEmpty()) {
            result.add(stack.pop());

        }
        String out = calc(result);

        for (int i = 0; i < result.size(); i++) {

            System.out.print(result.get(i));
        }
        System.out.print(" = " + out);
    }

    public static String calc(List exp){
        Pattern number = Pattern.compile("[0-9]+");
        Stack<String> result = new Stack();
        for (int i = 0; i < exp.size(); i++) {
            String a = (String) exp.get(i);
            Matcher m = number.matcher(a);
            if(m.matches()){
                result.push(a);
            } else {
                int res = 0;
                int second = Integer.parseInt(result.pop());
                int first = Integer.parseInt(result.pop());
               switch (a){
                   case "+":
                       res = first + second;
                       break;
                   case "-":
                       res = first - second;
                       break;
                   case "*":
                       res = first * second;
                       break;
                   case "/":
                       res = first / second;
                       break;
               }
                String newRes = Integer.toString(res);
                result.push(newRes);
            }

        }
        return result.get(0);
    }
}
