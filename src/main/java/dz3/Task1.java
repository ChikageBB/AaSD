package dz3;

public class Task1{
    public static void main(String[] args) {
        int[] arr = {20, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {10, 9, 6, 2, 1};
        System.out.println(binarySearch(arr));
    }

// Задача 1.
//Дана последовательность различных чисел, в которой все числа до определенного индекса j отсортированы по убыванию, а после j по возрастанию. Найдите этот индекс j.  (Сложность O(log n).)
// [20, 19, 12, 11, 10, 8, 5, 3, 1, 2, 4, 6,9]
//                         ^     ^
//                         |     |
//                         l     r
//
// l = 3 r = 4
// 10, 9, 6, 2, 1
//           ^  ^
//           |  |
//           l  r


    public static int binarySearch(int[] arr){
        int l = 0;
        int r = arr.length - 1;

        while (l < r){
            int m = (r + l) / 2;
            if (arr[m] > arr[m + 1]){
                l = m + 1;
            }else{
                r = m;
            }
        }
        return r;
    }
}
