package dz3;

import java.util.Arrays;
import java.util.Comparator;

public class Task3 {

    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(maxNumber(arr));
    }

    public static int maxNumber(int[] arr){
        String[] strNumb = new String[arr.length];

        for (int i = 0; i < arr.length; ++i){
            strNumb[i] = String.valueOf(arr[i]);
        }


        Arrays.sort(strNumb, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String right  = o1 + o2;
                String left = o2 + o1;
                return left.compareTo(right);
            }
        });

        if (strNumb[0].equals("0")){
            return 0;
        }

        StringBuffer sb = new StringBuffer();
        for (String elem: strNumb){
            sb.append(elem);
        }

        return Integer.parseInt(String.valueOf(sb));
    }
}
