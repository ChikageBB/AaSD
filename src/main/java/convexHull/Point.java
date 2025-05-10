package convexHull;

public class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point){
            Point p = (Point) obj;
            return p.x == this.x && p.y == this.y;
        }
        else{
            return false;
        }
    }
}
