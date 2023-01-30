package se.kth.assignment1;

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

    public static boolean cond7() {

        return true;
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

    public static boolean cond12() {

        return true;
    }

    public static boolean cond13() {

        return true;
    }

    public static boolean cond14() {

        return true;
    }
}
