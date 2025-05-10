package fourth_Lesson;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> f = new ArrayDeque<>();
        f.add(3);
        f.add(2);
        f.add(8);

        Queue<Integer> s = new ArrayDeque<>();
        s.add(1);
        s.add(4);
        s.add(5);
        System.out.println(merge(f, s));
    }

    // (3 - 2) - 4
    // stack : 3 2
    // '-' 3 - 2 = 1
    // stack: 1 4
    // '-' 1 - 4 = -3;
    //stack: - 3
    public static int calcul(String s){
        Stack<Integer> stack = new Stack<>();
        String[] strs = s.trim().split("\\s+");

        for (String token: strs){
            if (token.matches("\\d+")){
                stack.push(Integer.parseInt(token));
            }else if ("+-*".contains(token)){
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;

                switch (token){
                    case "+" : res = a + b; break;
                    case "-" : res = a - b; break;
                    case "*" : res = a * b; break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    public static List<String> func(String[] arr){

        List<String> res = new ArrayList<>();
        res.add(arr[0]);
        for (int i = 1; i < arr.length; i++){
            if (!(arr[i].equals(arr[i - 1]))){
                res.add(arr[i]);
            }
        }

        return res;
    }
    // 1 2 3 4 5  6 7 8 9
    public static Queue<Integer> merge(Queue<Integer> firtsQueue, Queue<Integer> secondQueue){
        Queue<Integer> res = new ArrayDeque<>();

        while (!firtsQueue.isEmpty() && !secondQueue.isEmpty()){
            if (firtsQueue.peek() <= secondQueue.peek()){
                res.offer(firtsQueue.poll());
            }else{
                res.offer(secondQueue.poll());
            }
        }

        while (!firtsQueue.isEmpty()){
            res.offer(firtsQueue.poll());
        }

        while (!secondQueue.isEmpty()){
            res.offer(secondQueue.poll());
        }
        return res;
    }

    public static int[] function(int[] arr){

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        /**
         *  5 4 9 7 2
         *
         *  stack: 0 1 2 3 4
         *  res = 0 1 2 3 4
         */
        for (int i = 0; i < arr.length; ++i){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if (stack.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = stack.peek() + 1;
            }

            stack.push(i);
        }

        return res;
    }
}
