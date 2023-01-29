/**
 * assignment1
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        double LENGTH1 = 0;
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

    /**
     *
     * @param a data point a
     * @param b data point b
     * @return lenght between a and b
     */
    double lengt_between_points(POINT a, POINT b)
    {

        double x_a = a.getX();
        double y_a = a.getY();
        double x_b = b.getX();
        double y_b = b.getY();

        double dis_x = Math.abs(x_a - x_b);
        double dis_y = Math.abs(y_a - y_b);
        double tot_dis = Math.sqrt(Math.pow(dis_x,2) + Math.pow(dis_y,2)); // d=√((x2 – x1)² + (y2 – y1)²). formula

        return tot_dis;
    }

    /**
     *
     * @param a data point a
     * @param b data point b
     * @param arr array of data points
     * @return array of datapoints that lie between a and b
     */
    List<POINT> points_inbetween(POINT a, POINT b, POINT[] arr) //  Checks if there exists any points in the list c inbetween two points a and b.
    {
        double x_a = a.getX();
        double y_a = a.getY();
        double x_b = b.getX();
        double y_b = b.getY();
        POINT c;

        double dist_a_c = 0;
        double dist_b_c = 0;
        double dist_a_b = lengt_between_points(a,b);
        List<POINT> res = new ArrayList<POINT>();

        for(int i = 0; i < arr.length; i++)
        {
            c = arr[i];

            if(c.equals(a) || c.equals(b))
            {
                break;
            }

            dist_a_c = lengt_between_points(a,c);
            dist_b_c = lengt_between_points(b,c);

            if(dist_a_c + dist_b_c == dist_a_b)
            {
                res.add(c);
            }

        }
        return res;
    }

    public boolean calc_CMV(int cond) // Return true or false depending on if condition checks out
    {
        PARAMETERS Parameters = new PARAMETERS();
        Points Points = new Points(Globals.NUMPOINTS);

        switch (cond){
            case 0: // Kinda tested


                double dis = 0;

                POINT cur_point;
                POINT next_point;

                for(int i = 0; i < Globals.NUMPOINTS; i++)
                {

                    cur_point = Points.POINTS[i];

                    for(int j = 0; j < Globals.NUMPOINTS; j++)
                    {
                        next_point = Points.POINTS[j];
                        dis = lengt_between_points(cur_point,next_point);

                        if(dis > Parameters.LENGTH1)
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

            case 7: // Untested

                if(Globals.NUMPOINTS < 3)
                {
                    return false;
                }

                POINT p1;
                POINT p2;
                List<POINT> points_between;
                POINT k1;
                POINT k2;
                double dis1;



                for(int i = 0; i < Globals.NUMPOINTS - 1; i++)
                {
                    p1 = Points.POINTS[i];
                    p2 = Points.POINTS[i+1];
                    points_between = points_inbetween(p1,p2,Points.POINTS);

                    if(points_between.size() == Parameters.K_PTS)
                    {
                        for(int j = 0; j < points_between.size(); j++)
                        {
                            k1 = points_between.get(j);

                                    for(int k = 0; k < points_between.size(); k++)
                                    {
                                        k2 = points_between.get(k);
                                        dis1 = lengt_between_points(k1,k2);
                                        if(dis1 <= Parameters.LENGTH1 && !k1.equals(k2))
                                        {
                                            return false;
                                        }
                                    }
                        }
                    }

                }
                return true;


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
        System.out.println(assignment1.calc_CMV(7));


    }
}