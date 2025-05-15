package HashMapTasks;

//Задача 2
//Дан массив целых чисел и число k. Определить, есть ли в массиве такие два различных индекса i и j, что nums[i] == nums[j] и |i - j| <= k
//Пример:
//[1, 2, 3, 1, 5], k = 3
//Вывод: true (индекс 0 и 3, расстояние 3)

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2};
        int k = 3;

        System.out.println(func(arr, k));
    }

    public static boolean func(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        // Ключ - число; Значение - индекс
        // Каждому числу присваиваем индекс -> 1 : 0 ; 2 : 1 и т.д.

        for (int i = 0; i < arr.length; ++i ){
            int numb = arr[i];

            // Если в мапе есть такой ключ, то это эквивалентно arr[i] == arr[j]
            if (map.containsKey(numb) && Math.abs(i - map.get(numb)) <= k){
                return true;
            }

            map.put(numb, i);
        }
        return false;
    }


    public static boolean funcV2(int[] arr, int k){

        // Ключ - индекс; Значение - число
        // Каждой позиции присваиваем число -> 0 : 1 ; 1 : 2

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; ++i){
            map.put(i, arr[i]);
        }

        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (map.get(i) == map.get(j) && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
