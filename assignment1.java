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


    public static int[] CMV()
    {
        int[] CMV;



        return CMV;
    }

    public static int[][] PUM(int[] CVM, int[][] LCM)
    {
        int[][] PUM;
        return PUM;
    }

    public static int[] FUV(int[][] PUM)
    {
        int[] FUV;
        return FUV;
    }
    public static void decide(int NUMPOINTS, int [][] POINTS, PARAMETERS Parameters, int[][] LCM, int[] PUV)
    {

        boolean launch = false;

        int[] CMV = CMV();
        int[][] PUM = PUM(CMV,LCM);
        int[] FUV = FUV(PUM);


        if(FUV)
        {
            launch = true;
        }


    }
    public static void main(String[] args) {


        decide()
    }
}