package convexHull;

import java.util.Collection;
import java.util.Iterator;

public class GraphUtils {

    public static Point getMinY(Collection<Point> points){

        Iterator<Point> it = points.iterator();
        Point min = it.next();

        while (it.hasNext()){
            Point p = it.next();
            if (p.y <= min.y){
                if (p.y < min.y){
                    min = p;
                }else if (p.x < min.x){ // выбираем самую левую точку
                    min = p;
                }
            }
        }
        return min;
    }

    /**
     *
     * @param a
     * @param b
     * @param c
     * Формула ориентированной площади параллелограмма
     * через три точки на плоскости (псевдоскалярное произведение / векторное произведение на плоскости)
     *
     * p(x1, x2), q(x2, y2), r(x3, y3)
     * | x2 - x1, y2 - y1 |
     * | x3 - x1, y3 - y1 |
     *  = (x2 - x1)(y3 - y1) - (y2 - y1)(x3 - x1)
     *
     *     если псевдоскалярное произведение < 0, то вектор b повернут по часовой стрелке относительно а
     *     если псевдоскалярное произведение > 0, то вектор b повернут против часовой стрелки относительно а
     * @return 1 если в точке b есть поворот против часовой стрелки, -1 если по часовой, 0 если коллинеарны
     */


    public static int ccw(Point a, Point b, Point c){

        double area =  (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);

        if (area < 0) return -1;

        if (area > 0) return 1;

        return 0;
    }


    public static double dist(Point a, Point b){
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}
