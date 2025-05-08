package convexHull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    //Генерация рандомных точек
    public static int[][] generatorRandomCase(int n){
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++){
           a[i][0] = (int) (Math.random() * 100_000);
           a[i][1] = (int) (Math.random() * 100_000);
        }
        return a;
    }

    //Генерация 4 точек на оболоке
    public static int[][] generatorBestCase(int n){
        int[][] a = new int[n][2];

        a[0] = new int[]{0, 0};
        a[1] = new int[]{100_000, 0};
        a[2] = new int[]{100_000, 100_000};
        a[3] = new int[]{0, 100_000};

        for (int i = 4; i < n; i++){
            a[i][0] = 1000 + (int) (Math.random() * 98000);
            a[i][1] = 1000 + (int) (Math.random() * 98000);
        }
        return a;
    }

    // Генерация окружности
    public static int[][] generatorWorstCase(int n){

        int[][] a = new int[n][2];
        double radius = 10_000;

        for (int i = 0; i < n; i++){
            double angle = 2 * Math.PI * i / n;

            // Увеличиваем точность: округляем до 3 знаков после запятой
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);

            a[i][0] = (int) Math.round(x * 1000) + 500000;
            a[i][1] = (int) Math.round(y * 1000) + 500000;
        }
        return a;
    }

    public static void writeToFile(int[][] data, String fileName) throws IOException {
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);

        for (int[] point: data){
            fileWriter.write(point[0] + " " + point[1] + "\n");
        }
        fileWriter.close();
    }

    /**
     * Осторожно!!! Сгенерируется много файлов!!!
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        for (int k = 1; k < 1001; k++){
            int n = k * 100;

            int[][] random = generatorRandomCase(n);
            int[][] best = generatorBestCase(n);
            int[][] worst = generatorWorstCase(n);
            
            writeToFile(random, "src/main/java/convexHull/DataRandom/data" + k);
            writeToFile(best, "src/main/java/convexHull/DataBest/data" + k);
            writeToFile(worst, "src/main/java/convexHull/DataWorst/data" + k);
        }
    }

}
