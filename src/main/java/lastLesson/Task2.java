package lastLesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {

        List<List<Integer>> moves = new ArrayList<>();
        moves.add(Collections.emptyList());
        moves.add(List.of(1));
        moves.add(List.of(1));
        moves.add(List.of(1, 2));
        moves.add(List.of(1, 3));
        moves.add(List.of(1, 3));

        System.out.println(winner(5, moves));
    }


    public static String winner(int n, List<List<Integer>> moves) {
        boolean[] win = new boolean[n + 1];

        for (int i = 1; i <= n; ++i) {
            for (int take: moves.get(i)) {
                if (i - take >= 0 && !win[i - take]){
                    win[i] = true;
                    break;
                }
            }
        }

        return win[n] ? "first" : "second";

    }
}
