package se.kth.assignment1;

import java.util.ArrayList;
import java.util.List;

public class LIC {

    static double lengt_between_points(Point a, Point b)
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
    static List<Point> points_inbetween(Point a, Point b, Point[] arr) //  Checks if there exists any points in the list c inbetween two points a and b.
    {
        double x_a = a.getX();
        double y_a = a.getY();
        double x_b = b.getX();
        double y_b = b.getY();
        Point c;

        double dist_a_c = 0;
        double dist_b_c = 0;
        double dist_a_b = lengt_between_points(a,b);
        List<Point> res = new ArrayList<Point>();

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

    public static boolean cond0(Parameters Parameters, Points Points) {

        double dis = 0;

        Point cur_point;
        Point next_point;

        for(int i = 0; i < Points.size(); i++)
        {

            cur_point = Points.get(i);

            for(int j = 0; j < Points.size(); j++)
            {
                next_point = Points.get(j);
                dis = lengt_between_points(cur_point,next_point);

                if(dis > Parameters.LENGTH1)
                {
                    return false;
                }

            }
        }
        return true;
    }

    public static boolean cond1() {

        return true;
    }

    public static boolean cond2() {

        return true;
    }

    public static boolean cond3() {

        return true;
    }

    public static boolean cond4() {

        return true;
    }

    public static boolean cond5() {

        return true;
    }

    public static boolean cond6() {

        return true;
    }

    public static boolean cond7(Parameters Parameters, Points Points) {

        if(Points.size() < 3)
        {
            return false;
        }

        Point a1;
        Point a2;
        List<Point> points_between;
        Point b1;
        Point b2;
        double dis;
        boolean res = false;



        for(int i = 0; i < Points.size() - 1; i++)
        {
            a1 = Points.get(i); // Get one data point p1

            for(int l = 0; l < Points.size(); l++)
            {
                if(Points.equals(a1)) // avoid next data point being the same as p1
                {
                    l++;
                }

                a2 = Points.get(l); // get second data point p2
                points_between = points_inbetween(a1,a2,Points.get_arr()); // get list of points between p1,p2

                if(points_between.size() == Parameters.KPTS)
                {

                    for(int j = 0; j < points_between.size(); j++)
                    {
                        b1 = points_between.get(j); // get point from inbetween list

                        for(int k = 0; k < points_between.size(); k++)
                        {
                            if(points_between.get(k).equals(b1))
                            {
                                k++;
                            }
                            b2 = points_between.get(k); // get second point from inbetween list
                            dis = lengt_between_points(b1,b2);
                            if(dis <= Parameters.LENGTH1 && !b1.equals(b2))
                            {
                                break;
                            }
                            if(k == points_between.size() - 1); // if k reaches size - 1 then it means we have found a set
                            {
                                return true;
                            }
                        }


                    }
                }
            }


        }
        return false;
    }

    public static boolean cond8() {

        return true;
    }

    public static boolean cond9() {

        return true;
    }

    public static boolean cond10() {

        return true;
    }

    public static boolean cond11() {

        return true;
    }

    public static boolean cond12(Parameters Parameters, Points Points) {

        if(Points.size() < 3)
        {
            return false;
        }

        Point a1;
        Point a2;
        List<Point> points_between1;
        Point b1;
        Point b2;
        double dis;
        boolean res1 = false;



        for(int i = 0; i < Points.size() - 1; i++)
        {
            if(res1)
            {
                break;
            }
            a1 = Points.get(i);

            for(int l = 0; l < Points.size(); l++)
            {
                if(Points.get(l).equals(a1))
                {
                    l++;
                }

                a2 = Points.get(l);
                points_between1 = points_inbetween(a1,a2,Points.get_arr());

                if(points_between1.size() == Parameters.KPTS)
                {
                    for(int j = 0; j < points_between1.size(); j++)
                    {
                        b1 = points_between1.get(j);

                        for(int k = 0; k < points_between1.size(); k++)
                        {
                            b2 = points_between1.get(k);
                            dis = lengt_between_points(b1,b2);
                            if(dis <= Parameters.LENGTH1 && !b1.equals(b2))
                            {
                                res1 = false;
                                break;
                            }

                            if(k == points_between1.size() - 1);
                            {
                                res1 = true;
                            }
                        }
                    }
                }
            }


        }

        boolean res2 = false;


        for(int i = 0; i < Points.size() - 1; i++)
        {
            if(res2)
            {
                break;
            }
            a1 = Points.get(i);

            for(int l = 0; l < Points.size(); l++)
            {
                if(Points.get(l).equals(a1))
                {
                    l++;
                }
                a2 = Points.get(l);
                points_between1 = points_inbetween(a1,a2,Points.get_arr());

                if(points_between1.size() == Parameters.KPTS)
                {
                    for(int j = 0; j < points_between1.size(); j++)
                    {
                        b1 = points_between1.get(j);

                        for(int k = 0; k < points_between1.size(); k++)
                        {
                            b2 = points_between1.get(k);
                            dis = lengt_between_points(b1,b2);
                            if(dis >= Parameters.LENGTH2 && !b1.equals(b2))
                            {
                                res2 = false;
                                break;
                            }
                            if(k == points_between1.size() - 1);
                            {
                                res2 = true;
                            }
                        }
                    }
                }
            }


        }

        return res1 && res2;
    }

    public static boolean cond13(Parameters Parameters, Points Points) {

        if(Points.size() < 5)
        {
            return false;
        }

        Point a1;
        Point a2;
        List<Point> points_between_a1_a2 = null;
        List<Point> points_between_a1_b1 = null;
        List<Point> points_between_a2_b1 = null;
        Point b1;
        double dis_p1_p2;
        double dis_p1_p3;
        double dis_p2_p3;
        double longest_dist1;
        double longest_dist2;
        boolean res1 = false;
        boolean res2 = false;




        for(int i = 0; i < Points.size() - 1; i++)
        {
            a1 = Points.get(i);

            for(int l = 0; l < Points.size(); l++)
            {
                if(Points.get(l).equals(a1))
                {
                    l++;
                }

                a2 = Points.get(l);
                points_between_a1_a2 = points_inbetween(a1,a2,Points.get_arr());

                if(points_between_a1_a2.size() == Parameters.APTS)// Check if points between v1,v2
                {
                    for(int j = 0; j < Points.size(); j++)
                    {

                        if(Points.get(j).equals(a1) || Points.get(j).equals(a2)) // check that we get a new unique point
                        {
                            j++;
                        }
                        if(Points.get(j).equals(a1) || Points.get(j).equals(a2)) // do this twice so we make sure to avoid a1 and a2
                        {
                            j++;
                        }
                        b1 = Points.get(j); // Get new point h1

                        points_between_a1_b1 = points_inbetween(a1,b1,Points.get_arr()); // get points between a1 and b1
                        points_between_a2_b1 = points_inbetween(a2,b1,Points.get_arr()); // get points between a2 and b1


                        if(points_between_a1_b1.size() == Parameters.BPTS)
                        {
                            dis_p1_p2 = lengt_between_points(a1,a2);
                            dis_p1_p3 = lengt_between_points(a1,b1);
                            dis_p2_p3 = lengt_between_points(a2,b1);
                            longest_dist1 = Math.max(dis_p1_p2,dis_p1_p3);
                            longest_dist2 = Math.max(longest_dist1,dis_p2_p3);

                            if(longest_dist2 > Parameters.RADIUS1 + Parameters.RADIUS1)
                            {
                                res1 = true;
                            }
                        }

                        if(points_between_a2_b1.size() == Parameters.BPTS)
                        {
                            dis_p1_p2 = lengt_between_points(a1,a2);
                            dis_p1_p3 = lengt_between_points(a1,b1);
                            dis_p2_p3 = lengt_between_points(a2,b1);
                            longest_dist1 = Math.max(dis_p1_p2,dis_p1_p3);
                            longest_dist2 = Math.max(longest_dist1,dis_p2_p3);

                            if(longest_dist2 > Parameters.RADIUS1 + Parameters.RADIUS1)
                            {
                                res1 = true;
                            }
                        }
                    }
                }


            }

        }

        for(int i = 0; i < Points.size() - 1; i++)
        {
            a1 = Points.get(i);

            for(int l = 0; l < Points.size(); l++)
            {
                if(Points.get(l).equals(a1))
                {
                    l++;
                }

                a2 = Points.get(l);
                points_between_a1_a2 = points_inbetween(a1,a2,Points.get_arr());

                if(points_between_a1_a2.size() == Parameters.APTS)// Check if points between v1,v2
                {
                    for(int j = 0; j < Points.size(); j++)
                    {

                        if(Points.get(j).equals(a1) || Points.get(j).equals(a2)) // check that we get a new unique point
                        {
                            j++;
                        }
                        if(Points.get(j).equals(a1) || Points.get(j).equals(a2)) // do this twice so we make sure to avoid v1 and v2
                        {
                            j++;
                        }
                        b1 = Points.get(j); // Get new point h1

                        points_between_a1_b1 = points_inbetween(a1,b1,Points.get_arr()); // get points between h1 and v1
                        points_between_a2_b1 = points_inbetween(a2,b1,Points.get_arr()); // get points between h1 and v2


                        if(points_between_a1_b1.size() == Parameters.BPTS)
                        {
                            dis_p1_p2 = lengt_between_points(a1,a2);
                            dis_p1_p3 = lengt_between_points(a1,b1);
                            dis_p2_p3 = lengt_between_points(a2,b1);
                            longest_dist1 = Math.max(dis_p1_p2,dis_p1_p3);
                            longest_dist2 = Math.max(longest_dist1,dis_p2_p3);

                            if(longest_dist2 <= Parameters.RADIUS2 + Parameters.RADIUS2)
                            {
                                res2 = true;
                            }
                        }

                        if(points_between_a2_b1.size() == Parameters.BPTS)
                        {
                            dis_p1_p2 = lengt_between_points(a1,a2);
                            dis_p1_p3 = lengt_between_points(a1,b1);
                            dis_p2_p3 = lengt_between_points(a2,b1);
                            longest_dist1 = Math.max(dis_p1_p2,dis_p1_p3);
                            longest_dist2 = Math.max(longest_dist1,dis_p2_p3);

                            if(longest_dist2 <= Parameters.RADIUS2 + Parameters.RADIUS2)
                            {
                                res2 = true;
                            }
                        }
                    }
                }


            }

        }
        return res1 && res2;
    }

    public static boolean cond14() {

        return true;
    }
}
