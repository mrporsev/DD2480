package se.kth.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void decide() {
        Parameters parameters = new Parameters(
                1,
                0.0,
                1.0,
                9.0,
                6,
                5,
                10,
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
        int numpoints = 8;
        Points points = new Points(numpoints);
        points.add(new Point(0,0));
        points.add(new Point(10,10));
        points.add(new Point(1,1));
        points.add(new Point(2,2));
        points.add(new Point(1.1,1.1));
        points.add(new Point(2,2));
        points.add(new Point(3,0));
        points.add(new Point(0,3));

        int[][] LCM = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j <= i ; j++) {
                LCM[i][j] = (i == 0 || i == 2 || i == 12 || j == 0 || j == 2 || j == 12) ? 2 : 1;
                LCM[j][i] = LCM[i][j];
            }
        }
        boolean[] PUV = new boolean[] {true, false, true, true, false, false, true, true, false, false, false, false, true, true, false};

        Main.decide(numpoints, points, parameters, LCM, PUV);
    }
}