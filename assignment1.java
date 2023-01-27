/**
 * assignment1
 */
public class assignment1 {

    public class PARAMETERS
    {
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

    public static boolean calc_CMV(PARAMETERS Parameters, int cond) // Return true or false depending on if condition checks out
    {
        switch (cond){
            case 0:

            case 1:

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

    public static int[] CMV(PARAMETERS Parameters)
    {
        int[] CMV = new int[15];

        for(int i = 0; i < 15; i++)
        {
            CMV[i] = calc_CMV(Parameters,i);
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
    public static void decide(int NUMPOINTS, int [][] POINTS, PARAMETERS Parameters, int[][] LCM, int[] PUV)
    {

        /*
        Preliminary plan of how it should work
        first calculate CMV then PUM and then FUV and if FUV is approved send launch approve

        boolean launch = false;

        int[] CMV = CMV(PARAMETERS Parameters);
        int[][] PUM = PUM(CMV,LCM);
        int[] FUV = FUV(PUM);


        if(FUV)
        {
            launch = true;
        }

         */




    }
    public static void main(String[] args) {


        // here the decide function should be run
        // decide()
    }
}