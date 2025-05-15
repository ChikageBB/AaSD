package HashMapTasks;


//Задача 3
//Даны два массива целых чисел. Вернуть массив их общих элементов,
// где количество вхождений каждого элемента равно минимальному из его встречаемости в обоих массивах
//Пример:
//[2, 4, 4, 1], [2, 2, 4, 5]
//Вывод:
//[2, 4]

import java.util.*;

public class Task3 {
    public static void main(String[] args) {

        int[] fArr = {2, 4, 4, 1, 5};
        int[] sArr = {2, 2, 4, 5, 1};

        System.out.println(Arrays.toString(func(fArr, sArr)));

    }

    public static int[] func(int[] fArr, int[] sArr){

        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> fMap = new HashMap<>();
        for (int i = 0; i < fArr.length; ++i){
            fMap.put(fArr[i], fMap.getOrDefault(fArr[i], 0) + 1);
        }

        HashMap<Integer, Integer> sMap = new HashMap<>();
        for (int i = 0; i < sArr.length; ++i){
            sMap.put(sArr[i], sMap.getOrDefault(sArr[i], 0) + 1);
        }

        //[2, 4, 4, 1], [2, 2, 4, 5]
        // 2 : 1 ; 4 : 2 ; 1 : 1
        // 2 : 2 ; 4 : 1 ; 5 : 1

        for (Map.Entry<Integer, Integer> entry: fMap.entrySet()){
            if (sMap.containsKey(entry.getKey())){

                int a = fMap.get(entry.getKey());
                int b = sMap.get(entry.getKey());

                for (int i = 0; i < (a < b ? a : b); ++i){
                    res.add(entry.getKey());
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();

    }
}
