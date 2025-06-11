package lastLesson;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sum(new int[]{1, 2, 3, 4, 5, 6, 7}, 7)));
    }


    public static int[] sum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];
        int[] res = new int[]{nums[0], nums[1], nums[2]};

        for (int i = 0; i < n - 2; ++i) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                    res = new int[]{nums[i], nums[left], nums[right]};
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}
