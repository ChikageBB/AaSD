package convexHull;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JarvisMarch {

    public List<Point> march(Collection<Point> points){
        List<Point> hull = new ArrayList<>();

        Point startingPoint = GraphUtils.getMinY(points);
        hull.add(startingPoint);

        Point prevVertex = startingPoint;

        while (true){
            Point candidatePoint = null;

            for (Point point: points){
                if (point == prevVertex) continue;

                if (candidatePoint == null){
                    candidatePoint = point;
                    continue;
                }

                int ccw = GraphUtils.ccw(prevVertex, candidatePoint, point);


                if (ccw == 0 && GraphUtils.dist(prevVertex, candidatePoint) < GraphUtils.dist(prevVertex, point)){
                    candidatePoint = point;
                }else if (ccw < 0){
                    candidatePoint = point;
                }
            }
            if (candidatePoint == startingPoint) break;

            hull.add(candidatePoint);
            prevVertex = candidatePoint;
        }
        return hull;
    }

    public static void main(String[] args) throws IOException {
        for (int k = 1; k < 1001; k++){
            Path path = Path.of("src/main/java/convexHull/Data/data" + k);
            List<String> lines = Files.readAllLines(path);

            List<Point> points = new ArrayList<>();

            for (String str: lines){
                String[] arr = str.split(" ");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                points.add(new Point(x, y));
            }

            System.out.println("The number of points in the set : " + points.size() + " ");
            JarvisMarch hullJ = new JarvisMarch();

            long start = System.nanoTime();

            List<Point> hull = hullJ.march(points);

            long finish = System.nanoTime();

            System.out.println("JarvisMarch : " + hull);
            System.out.println("The number of point in the hull : " + hull.size());
            System.out.println("-------------------------------------------");
            System.out.println("Time : " + ((finish - start) / 1000) + "\n");


        }
    }


}