package dz3;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(func(new int[]{15, 5, 11, 10, 12}, 30));
    }


    public static int func(int[] arr, int s){
        Arrays.sort(arr);

        int sum = 0;
        int count = 0;


        for (int elem: arr){
            if (sum + elem <= s){
                sum += elem;
                count++;
            }else{
                break;
            }
        }

        return count;
    }
}
