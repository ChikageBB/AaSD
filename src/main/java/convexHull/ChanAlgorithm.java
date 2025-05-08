package convexHull;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ChanAlgorithm {
    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("src/main/java/convexHull/resultRandomData.txt");

        writer.write(
                "points" + ", hull" + ", time\n"
        );

        for (int k = 1; k < 1001; ++k){
            Path path = Path.of("src/main/java/convexHull/DataRandom/data" + k);
            List<String> lines = Files.readAllLines(path);

            int m = 20;
            List<Point> subListHulls = new ArrayList<>();
            List<Point> subList = new ArrayList<>();

            long start = System.nanoTime();

            for (String line: lines) {
                String[] arr = line.split(" ");
                subList.add(new Point(Double.parseDouble(arr[0]), Double.parseDouble(arr[1])));


                if (subList.size() == m) {
                    GrahamScan grahamScan = new GrahamScan();
                    subListHulls.addAll(grahamScan.scan(subList));
                    subList = new ArrayList<>();
                }
            }

            if (!subList.isEmpty()){
                GrahamScan grahamScan = new GrahamScan();
                subListHulls.addAll(grahamScan.scan(subList));
            }

            JarvisMarch hull = new JarvisMarch();
            List<Point> res = hull.march(subListHulls);

            long finish = System.nanoTime();

            long sec =  (finish - start) / 1_000_000;

            writer.write(lines.size() + ", " + res.size() + ", " + sec + "\n");

//            System.out.println("Chan's algorithm : " + hull.march(subListHulls));
//
//            System.out.println("Time : " + ((double)(finish - start) / 1_000_000_000));

        }

        writer.close();

    }
}
