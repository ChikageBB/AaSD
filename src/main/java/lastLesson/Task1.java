package lastLesson;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {

    }


    public static int[] sum(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        int[] res = new int[] {nums[0], nums[1], nums[2]};


        for (int i = 0; i < n - 2; ++i){
            int a = nums[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right){
                int b = nums[left];
                int c = nums[right];

                int sum1 = a + b + c;

                if (Math.abs(sum - target)< Math.abs(sum1 - target)){
                    sum = sum1;
                    res = new int[] {a, b, c};
                }

                if (sum1 < target) {
                    left++;
                }else{
                    right--;
                }

            }
        }
        return res;
    }
}
