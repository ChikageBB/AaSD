package convexHull;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class GrahamScan {

    /**
     * сортировка по углу
     *
     *
     * @param points
     * @param ref равен minYPoint - начальная точка
     */

    private void sortByAngle(List<Point> points, Point ref){
        Collections.sort(points, (b, c) -> {

            /**
             * точку ref добавляем в hull
             */

            if (b == ref) return -1; // comparator, если -1, то точка b точно меньше точки c, сортируем
            if (c == ref) return 1;  // comparator, если 1, то точка с точно меньше точки b, сортируем

            int ccw = GraphUtils.ccw(ref, b, c);



            if (ccw == 0){
                if (Double.compare(b.x, c.x) == 0){
                    return b.y < c.y ? -1 : 1;
                }else{
                    return b.x < c.x ? -1 : 1;
                }
            }else{
                return ccw * -1;
            }
        });
    }

    public List<Point> scan(List<Point> points){
        Deque<Point> deque = new ArrayDeque<>();

        Point minYPoint = GraphUtils.getMinY(points);
        sortByAngle(points, minYPoint);

        deque.push(points.get(0));
        deque.push(points.get(1));

        for (int i = 2; i < points.size(); ++i){
            Point next = points.get(i);
            Point p = deque.pop();


            // убираем коллинеарные и те точки, которые дают отрицательную площадь
            while (deque.peek() != null && GraphUtils.ccw(deque.peek(), p, next) <= 0){
                p = deque.pop();
            }

            deque.push(p);
            deque.push(points.get(i));
        }
        // в некоторых случаях последняя точка может быть коллинеарной
        Point p = deque.pop();
        if (GraphUtils.ccw(deque.peek(), p, minYPoint) > 0){
            deque.push(p);
        }

        return new ArrayList<>(deque);

    }

    public static void main(String[] args) throws IOException {
        for (int k = 1; k < 1001; ++k){
            Path path = Path.of("src/main/java/convexHull/Data/data" + k);
            List<String> lines = Files.readAllLines(path);

            List<Point> points =new ArrayList<>();

            for (String line: lines){
                String[] str = line.split(" ");
                points.add(new Point(Double.parseDouble(str[0]), Double.parseDouble(str[1])));
            }


            System.out.println("The number of points in the set: " + points.size());

            GrahamScan hullG = new GrahamScan();

            long start = System.nanoTime();

            List<Point> hull = hullG.scan(points);

            long finish = System.nanoTime();

            System.out.println("Graham scan : "  + hull);
            System.out.println("The number of points in the hull : " + hull.size());
            System.out.println("-------------------------------------------------");
            System.out.println("The time: " + (finish - start) / 1000 + "\n");
        }
    }
}
