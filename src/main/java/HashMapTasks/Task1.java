package HashMapTasks;

import java.util.HashMap;
import java.util.Map;


//Задача 1
//Напишите функцию, которая принимает на вход текст и вовращает количество вхождений
// каждого слова (с учетом окончаний. Т.е. "яблоко" и "яблока" -- это два разных слова ). Сложность -- O(n)


public class Task1 {
    public static void main(String[] args) {

        String text = "Hello, World World World";

        func(text);

    }

    public static void func(String text){
        HashMap<String, Integer> res = new HashMap<>();

        text = text.replace(",", "").replace("!", "").replace(".", "");

        for (String elem: text.split(" ")){
            if (!res.containsKey(elem)){
                res.put(elem, 1);
            }else{
                int value = res.get(elem);
                value++;
                res.put(elem, value);
            }
        }


        for (Map.Entry<String, Integer> elem: res.entrySet()){
            System.out.println(elem.getKey() + " " + elem.getValue());
        }
    }
}

