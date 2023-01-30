package se.kth.assignment1;

import java.util.ArrayList;
import java.util.List;

public class LIC {

    /**
     * @param a datapoint a
     * @param b datapoint
     * @return distance between a and b
     */
    static double lengt_between_points(Point a, Point b) {

        double x_a = a.getX();
        double y_a = a.getY();
        double x_b = b.getX();
        double y_b = b.getY();

        double dis_x = Math.abs(x_a - x_b);
        double dis_y = Math.abs(y_a - y_b);
        double tot_dis = Math.sqrt(Math.pow(dis_x, 2) + Math.pow(dis_y, 2)); // d=√((x2 – x1)² + (y2 – y1)²). formula

        return tot_dis;
    }

    /**
     *
     * @param a   data point a
     * @param b   data point b
     * @param arr array of data points
     * @return array of datapoints that lie between a and b
     */
    static List<Point> points_inbetween(Point a, Point b, Point[] arr) // Checks if there exists any points in the list
                                                                       // c inbetween two points a and b.
    {
        double x_a = a.getX();
        double y_a = a.getY();
        double x_b = b.getX();
        double y_b = b.getY();
        Point c;

        double dist_a_c = 0;
        double dist_b_c = 0;
        double dist_a_b = lengt_between_points(a, b);
        List<Point> res = new ArrayList<Point>();

        for (int i = 0; i < arr.length; i++) {
            c = arr[i];

            if (c.equals(a) || c.equals(b)) {
                break;
            }

            dist_a_c = lengt_between_points(a, c);
            dist_b_c = lengt_between_points(b, c);

            if (dist_a_c + dist_b_c == dist_a_b) {
                res.add(c);
            }

        }
        return res;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond0(Parameters Parameters, Points Points) {

        double dis = 0;

        Point cur_point;
        Point next_point;

        for (int i = 0; i < Points.size(); i++) {

            cur_point = Points.get(i);

            for (int j = 0; j < Points.size(); j++) {
                next_point = Points.get(j);
                dis = lengt_between_points(cur_point, next_point);

                if (dis > Parameters.LENGTH1) {
                    return false;
                }

            }
        }
        return true;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond1(Points points, Parameters parameters) {
        /*
         * There exists at least one set of three consecutive data points that cannot
         * all be contained
         * within or on a circle of radius RADIUS1.
         * (0 ≤ RADIUS1)
         * The same as saying that the distance between a point and every other can't be
         * bigger than the diameter?
         */
        if (parameters.RADIUS1 < 0) {
            return false;
        }

        double diameter = 2 * parameters.RADIUS1;
        Point pointA;
        Point pointB;
        Point pointC;

        for (int i = 0; i < points.size() - 2; i++) {

            pointA = points.get(i);
            pointB = points.get(i + 1);
            pointC = points.get(i + 2);

            // Distance between x-coordinates
            double xDistanceAB = Math.abs(pointA.getX() - pointB.getX());
            double xDistanceBC = Math.abs(pointB.getX() - pointC.getX());
            double xDistanceCA = Math.abs(pointC.getX() - pointA.getX());

            // Distance between y-coordinates
            double yDistanceAB = Math.abs(pointA.getY() - pointB.getY());
            double yDistanceBC = Math.abs(pointB.getY() - pointC.getY());
            double yDistanceCA = Math.abs(pointC.getY() - pointA.getY());

            // Distance between the points
            double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB));
            double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC));
            double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA));

            // If the length between some of the points are greater than the diameter, they
            // can't be within the radius
            if ((distanceAB > diameter) || (distanceBC > diameter) || (distanceCA > diameter)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond2(Points points, Parameters parameters) {
        /*
         * There exists at least one set of three consecutive data points which form an
         * angle such that:
         * angle < (PI−EPSILON)
         * or
         * angle > (PI+EPSILON)
         * The second of the three consecutive points is always the vertex of the angle.
         * If either the first point or the last point (or both) coincides with the
         * vertex,
         * the angle is undefined and the LIC is not satisfied by those three points.
         * (0 ≤ EPSILON < PI)
         */
        if (parameters.EPSILON < 0 || parameters.EPSILON >= Math.PI) {
            return false;
        }

        Point pointA;
        Point pointB;
        Point pointC;

        for (int i = 0; i < points.size() - 2; i++) {

            pointA = points.get(i);
            pointB = points.get(i + 1); // The vertex
            pointC = points.get(i + 2);

            // Distance between x-coordinates
            double xDistanceAB = Math.abs(pointA.getX() - pointB.getX());
            double xDistanceBC = Math.abs(pointB.getX() - pointC.getX());
            double xDistanceCA = Math.abs(pointC.getX() - pointA.getX());

            // Distance between y-coordinates
            double yDistanceAB = Math.abs(pointA.getY() - pointB.getY());
            double yDistanceBC = Math.abs(pointB.getY() - pointC.getY());
            double yDistanceCA = Math.abs(pointC.getY() - pointA.getY());

            // Distance between the points
            double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB)); // A - B
            double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC)); // B - C
            double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA)); // C - A

            // The angle of the second point (B)
            double angle = Math
                    .acos(((distanceAB * distanceAB) + (distanceBC * distanceBC) + (distanceCA * distanceCA))
                            / (2 * distanceAB * distanceBC));

            if ((angle < (Math.PI - parameters.EPSILON)) || (angle > (Math.PI + parameters.EPSILON))) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond3(Points points, Parameters parameters) {
        /*
         * There exists at least one set of three consecutive data points that are the
         * vertices of a triangle
         * with area greater than AREA1.
         * (0 ≤ AREA1)
         */
        if (parameters.AREA1 < 0) {
            return false;
        }

        Point pointA;
        Point pointB;
        Point pointC;

        for (int i = 0; i < points.size() - 2; i++) {

            pointA = points.get(i);
            pointB = points.get(i + 1);
            pointC = points.get(i + 2);

            // Distance between x-coordinates
            double xDistanceAB = Math.abs(pointA.getX() - pointB.getX());
            double xDistanceBC = Math.abs(pointB.getX() - pointC.getX());
            double xDistanceCA = Math.abs(pointC.getX() - pointA.getX());

            // Distance between y-coordinates
            double yDistanceAB = Math.abs(pointA.getY() - pointB.getY());
            double yDistanceBC = Math.abs(pointB.getY() - pointC.getY());
            double yDistanceCA = Math.abs(pointC.getY() - pointA.getY());

            // Distance between the points
            double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB));
            double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC));
            double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA));

            // Heron's formula
            double s = (distanceAB + distanceBC + distanceCA) / 2;
            double area = Math.sqrt(s * (s - distanceAB) * (s - distanceBC) * (s - distanceCA));

            if (area > parameters.AREA1) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond4(Points points, Parameters parameters) {
        /*
         * There exists at least one set of Q_PTS consecutive data points that lie in
         * more than QUADS quadrants. Where there is ambiguity as to which quadrant
         * contains a given point, priority of decision will be by quadrant number,
         * i.e., I, II, III, IV.
         * For example, the data point (0,0) is in quadrant I, the point (-l,0) is in
         * quadrant II,
         * the point (0,-l) is in quadrant III, the point (0,1) is in quadrant I and the
         * point (1,0)
         * is in quadrant I.
         * (2 ≤ Q_PTS ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3)
         */
        if (parameters.QPTS < 2 || parameters.QPTS > points.size()) {
            return false;
        }
        if (parameters.QUADS < 1 || parameters.QUADS > 3) {
            return false;
        }

        for (int i = 0; i < points.size() - parameters.QPTS; i++) {

            boolean[] existsInQuadrant = { false, false, false, false };

            for (int qthPoint = 0; qthPoint < parameters.QPTS; qthPoint++) {

                Point xCoordinateQthPoint = points.get(i + qthPoint);
                Point yCoordinateQthPoint = points.get(i + qthPoint);

                // First quadrant (x >= 0 and y >= 0)
                if ((xCoordinateQthPoint.getX() >= 0) && (yCoordinateQthPoint.getY() >= 0)) {
                    existsInQuadrant[0] = true;
                }

                // Second quadrant (x < 0 and y >= 0)
                else if ((xCoordinateQthPoint.getX() >= 0) && (yCoordinateQthPoint.getY() >= 0)) {
                    existsInQuadrant[1] = true;
                }

                // Third quadrant (x <= 0 and y < 0)
                else if ((xCoordinateQthPoint.getX() <= 0) && (yCoordinateQthPoint.getY() >= 0)) {
                    existsInQuadrant[2] = true;
                }

                // Fourth quadrant (x >= 0 and y < 0)
                else if ((xCoordinateQthPoint.getX() >= 0) && (yCoordinateQthPoint.getY() >= 0)) {
                    existsInQuadrant[3] = true;
                }
            }

            int numberOfPointsInQuadrants = 0;

            // Checks number of data points existing in quadrants
            for (int j = 0; i < existsInQuadrant.length; j++) {

                if (existsInQuadrant[j] == true) {
                    numberOfPointsInQuadrants++;
                }
            }

            // If the number of existing data points are greater than QUADS, return true
            if (numberOfPointsInQuadrants > parameters.QUADS) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond5(Points points, Parameters parameters) {
        /*
         * There exists at least one set of two consecutive data points, (X[i],Y[i]) and
         * (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1)
         */

        Point pointA;
        Point pointB;

        for (int i = 0; i < points.size() - 1; i++) {

            pointA = points.get(i);
            pointB = points.get(i + 1);

            if ((pointA.getX() - pointB.getX()) < 0) { // Since i = j-1 --> j = i+1
                return true;
            }
        }
        return false;
    }

    public static boolean cond6() {

        return true;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond7(Parameters Parameters, Points Points) {

        if (Points.size() < 3) {
            return false;
        }

        Point a1;
        Point a2;
        List<Point> points_between;
        Point b1;
        Point b2;
        double dis;
        boolean res = false;

        for (int i = 0; i < Points.size() - 1; i++) {
            a1 = Points.get(i); // Get one data point p1

            for (int l = 0; l < Points.size(); l++) {
                if (Points.equals(a1)) // avoid next data point being the same as p1
                {
                    l++;
                }

                a2 = Points.get(l); // get second data point p2
                points_between = points_inbetween(a1, a2, Points.get_arr()); // get list of points between p1,p2

                if (points_between.size() == Parameters.KPTS) {

                    for (int j = 0; j < points_between.size(); j++) {
                        b1 = points_between.get(j); // get point from inbetween list

                        for (int k = 0; k < points_between.size(); k++) {
                            if (points_between.get(k).equals(b1)) {
                                k++;
                            }
                            b2 = points_between.get(k); // get second point from inbetween list
                            dis = lengt_between_points(b1, b2);
                            if (dis <= Parameters.LENGTH1 && !b1.equals(b2)) {
                                break;
                            }
                            if (k == points_between.size() - 1)
                                ; // if k reaches size - 1 then it means we have found a set
                            {
                                return true;
                            }
                        }

                    }
                }
            }

        }
        return false;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond8(Points points, Parameters parameters) {
        /*
         * There exists at least one set of three data points separated by exactly A_PTS
         * and B_PTS consecutive intervening points, respectively, that cannot be
         * contained within or on a circle of radius RADIUS1. The condition is not met
         * when NUMPOINTS < 5.
         * 1 ≤ A_PTS, 1 ≤ B_PTS
         * A_PTS + B_PTS ≤ (NUMPOINTS−3)
         */

        if (points.size() < 5) {
            return false;
        }
        if (parameters.APTS < 1 || parameters.BPTS < 1
                || parameters.APTS + parameters.BPTS < points.size() - 3) {
            return false;
        }

        double diameter = 2 * parameters.RADIUS1;
        Point pointA;
        Point pointB;
        Point pointC;

        for (int i = 0; i < points.size() - 3 - parameters.APTS - parameters.BPTS; i++) {

            pointA = points.get(i);
            pointB = points.get(i + parameters.APTS); // Maybe have to take +1 too if A_PTS and B_PTS are 1?
            pointC = points.get(i + parameters.APTS + parameters.BPTS); // and + A_PTS here? Otherwise, they can pick
                                                                        // the same
            // point?

            // Distance between x-coordinates
            double xDistanceAB = Math.abs(pointA.getX() - pointB.getX());
            double xDistanceBC = Math.abs(pointB.getX() - pointC.getX());
            double xDistanceCA = Math.abs(pointC.getX() - pointA.getX());

            // Distance between y-coordinates
            Double yDistanceAB = Math.abs(pointA.getY() - pointB.getY());
            double yDistanceBC = Math.abs(pointB.getY() - pointC.getY());
            double yDistanceCA = Math.abs(pointC.getY() - pointA.getY());

            // Distance between the points
            double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB));
            double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC));
            double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA));

            // If the length between some of the points are greater than the diameter, they
            // can't be within the radius
            if ((distanceAB > diameter) || (distanceBC > diameter) || (distanceCA > diameter)) {
                return false;
            }
        }
        return false;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond9(Points points, Parameters parameters) {
        /*
         * There exists at least one set of three data points separated by exactly C_PTS
         * and D_PTS consecutive intervening points, respectively, that form an angle
         * such that:
         * angle < (PI−EPSILON)
         * or
         * angle > (PI+EPSILON)
         * The second point of the set of three points is always the vertex of the
         * angle. If either the first point or the last point (or both) coincide with
         * the vertex, the angle is undefined and the LIC is not satisfied by those
         * three points. When NUMPOINTS < 5, the condition is not met.
         * 1 ≤ C PTS, 1 ≤ D PTS
         * C_PTS + D_PTS ≤ NUMPOINTS−3
         */

        if (points.size() < 5) {
            return false;
        }
        if (parameters.CPTS < 1 || parameters.DPTS < 1
                || parameters.CPTS + parameters.DPTS < points.size() - 3) {
            return false;
        }

        Point pointA;
        Point pointB;
        Point pointC;

        for (int i = 0; i < points.size() - 3 - parameters.CPTS - parameters.DPTS; i++) {

            pointA = points.get(i);
            pointB = points.get(i + parameters.CPTS); // The vertex (MAYBE +1 also? Same question as case 8)
            pointC = points.get(i + parameters.CPTS + parameters.DPTS);

            // Distance between x-coordinates
            double xDistanceAB = Math.abs(pointA.getX() - pointB.getX());
            double xDistanceBC = Math.abs(pointB.getX() - pointC.getX());
            double xDistanceCA = Math.abs(pointC.getX() - pointA.getX());

            // Distance between y-coordinates
            double yDistanceAB = Math.abs(pointA.getY() - pointB.getY());
            double yDistanceBC = Math.abs(pointB.getY() - pointC.getY());
            double yDistanceCA = Math.abs(pointC.getY() - pointA.getY());

            // Distance between the points
            double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB)); // A - B
            double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC)); // B - C
            double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA)); // C - A

            // The angle of the second point (B)
            double angle = Math
                    .acos(((distanceAB * distanceAB) + (distanceBC * distanceBC) + (distanceCA * distanceCA))
                            / (2 * distanceAB * distanceBC));

            if ((angle < (Math.PI - parameters.EPSILON)) || (angle > (Math.PI + parameters.EPSILON))) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond10(Points points, Parameters parameters) {
        /*
         * There exists at least one set of three data points separated by exactly E_PTS
         * and F_PTS consecutive intervening points, respectively, that are the vertices
         * of a triangle with area greater than AREA1. The condition is not met when
         * NUMPOINTS < 5.
         * 1 ≤ E_PTS, 1 ≤ F_PTS
         * E_PTS + F_PTS ≤ NUMPOINTS−3
         */

        if (points.size() < 5) {
            return false;
        }
        if (parameters.EPTS < 1 || parameters.FPTS < 1
                || parameters.EPTS + parameters.FPTS < points.size() - 3) {
            return false;
        }

        Point pointA;
        Point pointB;
        Point pointC;

        for (int i = 0; i < points.size() - 2 - parameters.EPTS - parameters.FPTS; i++) {

            pointA = points.get(i);
            pointB = points.get(i + parameters.EPTS);
            pointC = points.get(i + parameters.EPTS + parameters.FPTS);

            // Distance between x-coordinates
            double xDistanceAB = Math.abs(pointA.getX() - pointB.getX());
            double xDistanceBC = Math.abs(pointB.getX() - pointC.getX());
            double xDistanceCA = Math.abs(pointC.getX() - pointA.getX());

            // Distance between y-coordinates
            double yDistanceAB = Math.abs(pointA.getY() - pointB.getY());
            double yDistanceBC = Math.abs(pointB.getY() - pointC.getY());
            double yDistanceCA = Math.abs(pointC.getY() - pointA.getY());

            // Distance between the points
            double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB));
            double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC));
            double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA));

            // Heron's formula
            double s = (distanceAB + distanceBC + distanceCA) / 2;
            double area = Math.sqrt(s * (s - distanceAB) * (s - distanceBC) * (s - distanceCA));

            if (area > parameters.AREA1) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond11(Points points, Parameters parameters) {
        /*
         * There exists at least one set of two data points, (X[i],Y[i]) and
         * (X[j],Y[j]), separated by exactly G PTS consecutive intervening points, such
         * that X[j] - X[i] < 0. (where i < j ) The condition is not met when
         * NUMPOINTS < 3.
         * 1 ≤ G PTS ≤ NUMPOINTS−2
         */
        if (points.size() < 3) {
            return false;
        }
        if (parameters.GPTS < 1 || parameters.GPTS < points.size() - 2) {
            return false;
        }

        Point pointA;
        Point pointB;

        for (int i = 0; i < points.size() - 1 - parameters.GPTS; i++) {

            pointA = points.get(i);
            pointB = points.get(i + parameters.GPTS);

            if ((pointA.getX() - pointB.getX()) < 0) { // Since i = j-1 --> j = i+1 (Maybe +1 as above?)
                return true;
            }
        }
        return false;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond12(Parameters Parameters, Points Points) {

        if (Points.size() < 3) {
            return false;
        }

        Point a1;
        Point a2;
        List<Point> points_between1;
        Point b1;
        Point b2;
        double dis;
        boolean res1 = false;

        for (int i = 0; i < Points.size() - 1; i++) {
            if (res1) {
                break;
            }
            a1 = Points.get(i);

            for (int l = 0; l < Points.size(); l++) {
                if (Points.get(l).equals(a1)) {
                    l++;
                }

                a2 = Points.get(l);
                points_between1 = points_inbetween(a1, a2, Points.get_arr());

                if (points_between1.size() == Parameters.KPTS) {
                    for (int j = 0; j < points_between1.size(); j++) {
                        b1 = points_between1.get(j);

                        for (int k = 0; k < points_between1.size(); k++) {
                            b2 = points_between1.get(k);
                            dis = lengt_between_points(b1, b2);
                            if (dis <= Parameters.LENGTH1 && !b1.equals(b2)) {
                                res1 = false;
                                break;
                            }

                            if (k == points_between1.size() - 1)
                                ;
                            {
                                res1 = true;
                            }
                        }
                    }
                }
            }

        }

        boolean res2 = false;

        for (int i = 0; i < Points.size() - 1; i++) {
            if (res2) {
                break;
            }
            a1 = Points.get(i);

            for (int l = 0; l < Points.size(); l++) {
                if (Points.get(l).equals(a1)) {
                    l++;
                }
                a2 = Points.get(l);
                points_between1 = points_inbetween(a1, a2, Points.get_arr());

                if (points_between1.size() == Parameters.KPTS) {
                    for (int j = 0; j < points_between1.size(); j++) {
                        b1 = points_between1.get(j);

                        for (int k = 0; k < points_between1.size(); k++) {
                            b2 = points_between1.get(k);
                            dis = lengt_between_points(b1, b2);
                            if (dis >= Parameters.LENGTH2 && !b1.equals(b2)) {
                                res2 = false;
                                break;
                            }
                            if (k == points_between1.size() - 1)
                                ;
                            {
                                res2 = true;
                            }
                        }
                    }
                }
            }

        }

        return res1 && res2;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond13(Parameters parameters, Points points) {
        /*
         * There exists at least one set of three data points, separated by exactly
         * A_PTS and B_PTS consecutive intervening points, respectively, that cannot be
         * contained within or on a circle of radius RADIUS1. In addition, there exists
         * at least one set of three data points (which can be the same or different
         * from the three data points just mentioned) separated by exactly A_PTS
         * and B_PTS consecutive intervening points, respectively, that can be contained
         * in or on a circle of radius RADIUS2. Both parts must be true for the LIC to
         * be true. The condition is not met when NUMPOINTS < 5.
         * 0 ≤ RADIUS2
         */

        if (points.size() < 5) {
            return false;
        }
        if (0 <= parameters.RADIUS2) {
            return false;
        }

        double diameterOne = 2 * parameters.RADIUS1;
        double diameterTwo = 2 * parameters.RADIUS2;
        Point pointA;
        Point pointB;
        Point pointC;
        boolean radiusOneCheck = false;
        boolean radiusTwoCheck = false;

        for (int i = 0; i < points.size() - 2 - parameters.APTS - parameters.EPTS; i++) {

            pointA = points.get(i);
            pointB = points.get(i + parameters.APTS);
            pointC = points.get(i + parameters.APTS + parameters.EPTS);

            // Distance between x-coordinates
            double xDistanceAB = Math.abs(pointA.getX() - pointB.getX());
            double xDistanceBC = Math.abs(pointB.getX() - pointC.getX());
            double xDistanceCA = Math.abs(pointC.getX() - pointA.getX());

            // Distance between y-coordinates
            double yDistanceAB = Math.abs(pointA.getY() - pointB.getY());
            double yDistanceBC = Math.abs(pointB.getY() - pointC.getY());
            double yDistanceCA = Math.abs(pointC.getY() - pointA.getY());

            // Distance between the points
            double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB));
            double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC));
            double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA));

            // If the length between some of the points are greater than the diameter, they
            // can't be within the radius
            if ((distanceAB > diameterOne) || (distanceBC > diameterOne) || (distanceCA > diameterOne)) {
                radiusOneCheck = true;
            }
            if ((distanceAB > diameterTwo) || (distanceBC > diameterTwo) || (distanceCA > diameterTwo)) {
                radiusTwoCheck = true;
            }

            if (radiusOneCheck && radiusTwoCheck) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param Parameters parameters
     * @param Points     list of datapoints
     * @return true or false depending on if condition checks out
     */
    public static boolean cond14(Points points, Parameters parameters) {
        /*
         * There exists at least one set of three data points, separated by exactly
         * E_PTS and F_PTS consecutive intervening points, respectively, that are the
         * vertices of a triangle with area greater than AREA1. In addition, there exist
         * three data points (which can be the same or different from the three data
         * points just mentioned) separated by exactly E_PTS and F_PTS consecutive
         * intervening points, respectively, that are the vertices of a triangle with
         * area less than AREA2. Both parts must be true for the LIC to be true. The
         * condition is not met when
         * NUMPOINTS < 5.
         * 0 ≤ AREA2
         */

        if (points.size() < 5) {
            return false;
        }
        if (parameters.AREA2 >= 0) {
            return false;
        }

        Point pointA;
        Point pointB;
        Point pointC;
        boolean firstAreaCheck = false;
        boolean secondAreaCheck = false;

        for (int i = 0; i < points.size() - 2 - parameters.EPTS - parameters.FPTS; i++) {

            pointA = points.get(i);
            pointB = points.get(i + parameters.EPTS);
            pointC = points.get(i + parameters.EPTS + parameters.FPTS);

            // Distance between x-coordinates
            double xDistanceAB = Math.abs(pointA.getX() - pointB.getX());
            double xDistanceBC = Math.abs(pointB.getX() - pointC.getX());
            double xDistanceCA = Math.abs(pointC.getX() - pointA.getX());

            // Distance between y-coordinates
            double yDistanceAB = Math.abs(pointA.getY() - pointB.getY());
            double yDistanceBC = Math.abs(pointB.getY() - pointC.getY());
            double yDistanceCA = Math.abs(pointC.getY() - pointA.getY());

            // Distance between the points
            double distanceAB = Math.sqrt((xDistanceAB * xDistanceAB) + (yDistanceAB * yDistanceAB));
            double distanceBC = Math.sqrt((xDistanceBC * xDistanceBC) + (yDistanceBC * yDistanceBC));
            double distanceCA = Math.sqrt((xDistanceCA * xDistanceCA) + (yDistanceCA * yDistanceCA));

            // Heron's formula
            double s = (distanceAB + distanceBC + distanceCA) / 2;
            double area = Math.sqrt(s * (s - distanceAB) * (s - distanceBC) * (s - distanceCA));

            if (area > parameters.AREA1) {
                firstAreaCheck = true;
            }
            if (area > parameters.AREA2) {
                secondAreaCheck = true;
            }
            if (firstAreaCheck && secondAreaCheck) {
                return true;
            }
        }
        return false;
    }
}
