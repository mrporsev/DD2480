package se.kth.assignment1;

/**
 * Point class represents an x,y coordinate.
 */
public class Point {
    double x;
    double y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x-coordinate of point
     */
    public double getX()
    {
        return this.x;
    }

    /**
     * @return y-coordinate of point
     */
    public double getY()
    {
        return this.y;
    }
}
