package se.kth.assignment1;

import java.util.Arrays;

public class Main {

    /**
     * Decide function skeleton
     * @param numpoints The number of planar data points.
     * @param points Array containing the coordinates of data points.
     * @param parameters Object holding parameters for LIC's.
     * @param LCM Logical Connector Matrix.
     * @param PUV Preliminary Unlocking Vector
     */
    public static void decide(int numpoints, Points points, Parameters parameters, int[][] LCM, boolean[] PUV) {

        Cmv cmv = new Cmv(new LIC(), parameters, points);
        Pum pum = new Pum(LCM, cmv);
        Fuv fuv = new Fuv(pum, PUV);

        boolean decision = true;
        for (int i = 0; i < 15; i++) {
            decision = decision && fuv.getElem(i);
        }

        System.out.println(decision ? "Yes" : "No");
    }
    /**
     * This function does this
     * @param args argument is this
     */
    public static void main(String[] args) {

        Parameters parameters = new Parameters(
                3,
                0.0,
                1.0,
                2.0,
                6,
                5,
                3,
                3,
                1,
                0,
                3,
                5,
                0,
                0,
                5,
                0,
                5,
                1.0,
                1.9
        );
        int numpoints = 7;
        Points points = new Points(numpoints);
        points.add(new Point(0,0));
        points.add(new Point(10,10));
        points.add(new Point(1,1));
        points.add(new Point(2,2));
        points.add(new Point(1.1,1.1));
        points.add(new Point(2,2));
        points.add(new Point(3,0));

        int[][] LCM = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j <= i ; j++) {
                LCM[i][j] = (i == 0 || i == 2 || i == 12 || j == 0 || j == 2 || j == 12) ? 2 : 0;
                LCM[j][i] = LCM[i][j];
            }
        }
        boolean[] PUV = new boolean[] {true, false, true, false, false, false, false, false, false, false, false, false, true, false, false};

        decide(numpoints, points, parameters, LCM, PUV);
    }
}
