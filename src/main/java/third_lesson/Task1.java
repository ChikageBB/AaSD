package third_lesson;

import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true){
            String s = scanner.nextLine().trim();


            if (s.equalsIgnoreCase("exit")){
                break;
            }else {
                System.out.println(s + " " + check(s));
            }
        }

        scanner.close();

    }


    // () {} [] - true
    // (([]} - false


    public static boolean check(String s){
        while (true){
            if (s.contains("()")){
               s =  s.replace("()", "");
            }else if (s.contains("[]")) {
               s =  s.replace("[]", "");
            }else if (s.contains("{}")){
               s =  s.replace("{}", "");
            }else{
                return s.isEmpty();
            }
        }
    }

    public static boolean check1(String s){
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if (!((c == ')' && pop == '(') ||
                        (c == '}' && pop == '{') ||
                        (c == ']' && pop == '[')))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
