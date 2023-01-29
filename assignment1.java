/**
 * assignment1
 */
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;


public class assignment1 {

    public class POINT   // One point class
    {

        POINT(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
        double x;
        double y;

        double getX()
        {
            return this.x;
        }

        double getY()
        {
            return this.y;
        }
    }

    public class Points
    {
        public Points(int size) // Constructs Points array with random numbers
        {
            Random rand = new Random();
            double upperbound = 10.0;
            double double_random = rand.nextDouble(upperbound);
            this.POINTS = new POINT[size];
            for(int i = 0; i < size; i++)
            {
                POINT point = new POINT(double_random,double_random);
                this.POINTS[i] = point;
                double_random = rand.nextDouble(upperbound);

            }
        }

        public Points(int size, double val) // Constructs Points array with val as coordinates
        {
            for(int i = 0; i < size; i++)
            {
                this.POINTS = new POINT[size];
                POINT point = new POINT(val,val);
                this.POINTS[i] = point;
            }

        }

        POINT[] getPOINTS()
        {
            return this.POINTS;
        }



        POINT[] POINTS;
    }
    public class Globals   // Global class that stores global variables
    {

        public static int NUMPOINTS = 10;



    }

    public class PARAMETERS
    {
        double LENGTH1 = 15;
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

    public boolean calc_CMV(int cond) // Return true or false depending on if condition checks out
    {
        PARAMETERS Parameters = new PARAMETERS();
        Points Points = new Points(Globals.NUMPOINTS);

        switch (cond){
            case 0:

                double cur_x = 0;
                double cur_y = 0;
                double comp_x = 0;
                double comp_y = 0;
                double dis_x = 0;
                double dis_y = 0;
                double tot_dis = 0;


                for(int i = 0; i < Globals.NUMPOINTS; i++)
                {
                    cur_x = Points.POINTS[i].getX();
                    cur_y = Points.POINTS[i].getY();

                    for(int j = 0; j < Globals.NUMPOINTS; j++)
                    {
                        comp_x = Points.POINTS[j].getX();
                        comp_y = Points.POINTS[j].getY();
                        dis_x = Math.abs(cur_x - comp_x);
                        dis_y = Math.abs(cur_y - comp_y);
                        tot_dis = Math.sqrt(Math.pow(dis_x,2) + Math.pow(dis_y,2)); // d=√((x2 – x1)² + (y2 – y1)²). formula

                        if(tot_dis > Parameters.LENGTH1)
                        {
                            return false;
                        }

                    }
                }
                return true;

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

        return false;
    }

    public boolean[] CMV(PARAMETERS Parameters)
    {
        boolean[] CMV = new boolean[15];

        for(int i = 0; i < 15; i++)
        {
            CMV[i] = calc_CMV(i);
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


        assignment1 assignment1 = new assignment1();


    }
}