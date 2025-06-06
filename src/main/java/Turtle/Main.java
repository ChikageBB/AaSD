package Turtle;

public class Main {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };


        System.out.println(turtle(arr));
    }


    public static int turtle(int[][] field){
        if (field == null || field.length == 0 || field[0].length == 0){
            return 0;
        }

        int n = field.length;
        int m = field[0].length;

        int[][] temp = new int[n][m];

        temp[0][0] = field[0][0];

        for (int i = 1; i < m; ++i){
            temp[0][i] = temp[0][i - 1] + field[0][i];
        }

        for (int j = 1; j < n; ++j){
            temp[j][0] = temp[j - 1][0] + field[j][0];
        }

        for (int i = 1; i < n; ++i){
            for (int j = 1; j < m; ++j){
                temp[i][j] = Math.min(temp[i - 1][j], temp[i][j - 1]) + field[i][j];
            }
        }

        return temp[n - 1][m - 1];
    }
}
