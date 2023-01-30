package se.kth.assignment1;

/**
 * Preliminary Unlocking Matrix
 */
public class Pum {



    private boolean[][] pum = new boolean[15][15];

    /**
     * @param LCM Logical Connector Matrix
     *            15x15 int Matrix with the following mapping
     *            0 -> Not used
     *            1 -> and
     *            2 -> or
     * @param CMV Conditions Met Vector
     */
    public Pum(int[][] LCM, Cmv CMV) {
        boolean[] cmv = CMV.get();
        setPum(LCM, cmv);
    }

    /**
     * @return Preliminary Unlocking Matrix
     */
    public boolean[][] getPum() {
        return pum;
    }

    /**
     * @param i
     * @param j
     * @return field [i][j] of Preliminary Unlocking Matrix
     */
    public boolean getElem(int i, int j) {
        return pum[i][j];
    }

    private void setPum(int[][] LCM, boolean[] cmv) {
        for (int i = 0; i < 15 ; i++) {
            for (int j = 0; j <= i; j++) {
                switch (LCM[i][j]) {
                    case 0 : pum[i][j] = true;break;
                    case 1 : pum[i][j] = cmv[i] && cmv[j];break;
                    case 2 : pum[i][j] = cmv[i] || cmv[j];break;
                }
                pum[i][j] = pum[j][i];
            }
        }
    }
}
