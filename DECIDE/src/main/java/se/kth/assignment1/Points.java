package se.kth.assignment1;

/**
 * Points is an array of Point object (x,y) coordinates
 */
public class Points {
    private Point[] points;
    private int size;
    private int capacity;
    public Points(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.points = new Point[capacity];
    }

    /**
     * Add a point to the Points object
     * @param p point
     */
    public void add(Point p) {
        if (size == capacity) {
            capacity *= 2;
            Point[] newPoints = new Point[capacity];
            for (int i = 0; i < size; i++) {
                newPoints[i] = points[i];
            }
            points = newPoints;
        }
        points[size++] = p;
    }

    /**
     * Get specific point using index
     * @param index of point in the Points array
     * @return the point
     */
    public Point get(int index) {
        return points[index];
    }

    /**
     * @return the size of the Points object (array)
     */
    public int size() {
        return size;
    }
    public void clear() {
        size = 0;
    }

    /**
     * Remove a point from the Points object (array) using index
     * @param index of point
     */
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            points[i] = points[i + 1];
        }
        size--;
    }

    /**
     * Remove a point from the Points object (array) using the Point object
     * @param p point
     */
    public void remove(Point p) {
        for (int i = 0; i < size; i++) {
            if (points[i].equals(p)) {
                remove(i);
                return;
            }
        }
    }

    /**
     * Checks if Point p exists in the Points object (array)
     * @param p point that we want to check
     * @return true or false depending on if it contains the point or not
     */
    public boolean contains(Point p) {
        for (int i = 0; i < size; i++) {
            if (points[i].equals(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Print out all the points
     */
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(points[i]);
        }
    }
}
