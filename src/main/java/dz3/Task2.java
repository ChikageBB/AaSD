package dz3;




public class Task2 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        reverseStringByWord2(s);
    }

//Задача 2.
//Есть строка. Нужно развернуть строку так, чтобы каждое из слов осталось в естественном порядке.
//Например.
// Input 1: A = "the sky is blue" Output 1: "blue is sky the" Input 2: A = "this is ib"
// Output 2: "ib is this". Сложность линейная, с О(1) дополнительной памяти.


    public static void reverseStringByWord1(String s){
        StringBuilder stringBuilder= new StringBuilder();
        String[] words = s.split(" ");

        for (int i = words.length - 1; i >= 0; --i){
            stringBuilder.append(words[i]).append(' ');
        }

        System.out.println(stringBuilder);
    }

    public static void reverseStringByWord2(String s){
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; --i ){
            if (s.charAt(i) == ' '){
                System.out.print(s.substring(i + 1, j) + " ");
                j = i;
            }
        }
        System.out.print(s.substring(0, j));
    }
}
