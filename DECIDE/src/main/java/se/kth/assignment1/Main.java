package se.kth.assignment1;

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

        //CMV cmv = new CMV(parameters);
        //PUM pum = new PUM(LCM, cmv);
        //FUV fuv = new FUV(pum, PUV);

        //Return LAUNCH ("Yes", "No"), CMV, PUM, FUV
    }
    /**
     * This function does this
     * @param args argument is this
     */
    public static void main(String[] args) {

        Parameters parameters = new Parameters();
        int numpoints = 10;
        Points points = new Points(numpoints);
        int[][] LCM = new int[15][15];
        boolean[] PUV = new boolean[15];

        decide(numpoints, points, parameters, LCM, PUV);
    }
}
