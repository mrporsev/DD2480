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

        Parameters parameters = new Parameters();
        int numpoints = 10;
        Points points = new Points(numpoints);
        int[][] LCM = new int[15][15];
        boolean[] PUV = new boolean[15];

        decide(numpoints, points, parameters, LCM, PUV);
    }
}
