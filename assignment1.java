
/**
 * assignment1
 */

import java.lang.Math;

public class assignment1 {

    public class PARAMETERS {
        double LENGTH1;
        double RADIUS1;
        double EPSILON;
        double AREA1;
        int Q_PTS;
        int QUADS;
        double DIST;
        int N_PTS;
        int K_PTS;
        int A_PTS;
        int B_PTS;
        int C_PTS;
        int D_PTS;
        int E_PTS;
        int F_PTS;
        int G_PTS;
        double RADIUS2;
        double LENGTH2;
        double AREA2;
    }

    public static boolean calc_CMV(PARAMETERS Parameters, int cond) // Return true or false depending on if condition
                                                                    // checks out
    {
        switch (cond) {
            case 0:

            case 1:
                // There exists at least one set of three consecutive data points that cannot
                // all be contained
                // within or on a circle of radius RADIUS1.
                // (0 ≤ RADIUS1)
                // The same as saying that the distance between a point and every other can't be
                // bigger than the diameter?

                double diameter = 2 * RADIUS1;
                int[] pointA;
                int[] pointB;
                int[] pointC;

                for (int i = 0; i < listOfCoordinates.length - 2; i++) {

                    pointA = listOfCoordinates[i];
                    pointB = listOfCoordinates[i + 1];
                    pointC = listOfCoordinates[i + 2];

                    // Length between x-coordinates
                    int xDistanceA1 = Math.abs(pointA[0] - pointB[0]);
                    int xDistanceA2 = Math.abs(pointA[0] - pointC[0]);

                    int xDistanceB1 = Math.abs(pointB[0] - pointA[0]);
                    int xDistanceB2 = Math.abs(pointB[0] - pointC[0]);

                    int xDistanceC1 = Math.abs(pointC[0] - pointA[0]);
                    int xDistanceC2 = Math.abs(pointC[0] - pointB[0]);

                    // Length between y-coordinates
                    int yDistanceA1 = Math.abs(pointA[1] - pointB[1]);
                    int yDistanceA2 = Math.abs(pointA[1] - pointC[1]);

                    int yDistanceB1 = Math.abs(pointB[1] - pointA[1]);
                    int yDistanceB2 = Math.abs(pointB[1] - pointC[1]);

                    int yDistanceC1 = Math.abs(pointC[1] - pointA[1]);
                    int yDistanceC2 = Math.abs(pointC[1] - pointB[1]);

                    // The length between the points
                    double distanceA1 = Math.sqrt((xDistanceA1 * xDistanceA1) + (yDistanceA1 * yDistanceA1));
                    double distanceA2 = Math.sqrt((xDistanceA2 * xDistanceA2) + (yDistanceA2 * yDistanceA2));

                    double distanceB1 = Math.sqrt((xDistanceB1 * xDistanceB1) + (yDistanceB1 * yDistanceB1));
                    double distanceB2 = Math.sqrt((xDistanceB2 * xDistanceB2) + (yDistanceB2 * yDistanceB2));

                    double distanceC1 = Math.sqrt((xDistanceC1 * xDistanceC1) + (yDistanceC1 * yDistanceC1));
                    double distanceC2 = Math.sqrt((xDistanceC2 * xDistanceC2) + (yDistanceC2 * yDistanceC2));

                    if ((distanceA1 > diameter) || (distanceA2 > diameter) || (distanceB1 > diameter)
                            || (distanceB2 > diameter || (distanceC1 > diameter) || (distanceC2 > diameter))) {
                        return false;
                    } else {
                        return true;
                    }

                }

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

            case 8:

            case 9:

            case 10:

            case 11:

            case 12:

            case 13:

            case 14:

        }

    }

    public static int[] CMV(PARAMETERS Parameters) {
        int[] CMV = new int[15];

        for (int i = 0; i < 15; i++) {
            CMV[i] = calc_CMV(Parameters, i);
        }

        return CMV;
    }

    public static int[][] PUM(int[] CVM, int[][] LCM) // PRELIMINARY
    {
        int[][] PUM = new int[0][0];
        return PUM;
    }

    public static int[] FUV(int[][] PUM) // PRELIMINARY
    {
        int[] FUV = new int[0];
        return FUV;
    }

    public static void decide(int NUMPOINTS, int[][] POINTS, PARAMETERS Parameters, int[][] LCM, int[] PUV) {

        /*
         * Preliminary plan of how it should work
         * first calculate CMV then PUM and then FUV and if FUV is approved send launch
         * approve
         * 
         * boolean launch = false;
         * 
         * int[] CMV = CMV(PARAMETERS Parameters);
         * int[][] PUM = PUM(CMV,LCM);
         * int[] FUV = FUV(PUM);
         * 
         * 
         * if(FUV)
         * {
         * launch = true;
         * }
         * 
         */

    }

    public static void main(String[] args) {

        // here the decide function should be run
        // decide()
    }
}