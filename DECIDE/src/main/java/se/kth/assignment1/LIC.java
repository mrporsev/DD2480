package se.kth.assignment1;

public class LIC {

    public static boolean cond0() {

        return true;
    }

    public static boolean cond1(Points points, Parameters parameters) {
        /*
         * There exists at least one set of three consecutive data points that cannot
         * all be contained
         * within or on a circle of radius RADIUS1.
         * (0 ≤ RADIUS1)
         * The same as saying that the distance between a point and every other can't be
         * bigger than the diameter?
         */

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
                return false;
            }
        }
        return false;
    }

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

    public static boolean cond3(Points points, Parameters parameters) {
        /*
         * There exists at least one set of three consecutive data points that are the
         * vertices of a triangle
         * with area greater than AREA1.
         * (0 ≤ AREA1)
         */

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

    public static boolean cond7() {

        return true;
    }

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
            pointC = points.get(i + parameters.BPTS); // and + A_PTS here? Otherwise, they can pick the same
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
            pointC = points.get(i + parameters.DPTS);

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

        for (int i = 0; i < points.size() - 3 - parameters.EPTS - parameters.FPTS; i++) {

            pointA = points.get(i);
            pointB = points.get(i + parameters.EPTS); // MAYBE +1 also? Same question as case 8&9)
            pointC = points.get(i + parameters.FPTS);

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

    public static boolean cond12() {

        return true;
    }

    public static boolean cond13() {

        return true;
    }

    public static boolean cond14() {

        return true;
    }
}
