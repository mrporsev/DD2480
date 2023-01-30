package se.kth.assignment1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class PumTest {
    int[][] LCM = new int[15][15];
    boolean[] CMV = new boolean[15];

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j <= i; j++) {
                LCM[i][j] = i % 3;
                LCM[j][i] = LCM[i][j];
            }
            CMV[i] = ((i % 2) == 0);
        }
    }

    @AfterEach
    void tearDown() {
        LCM = null;
        CMV = null;
    }

    @Test
    void setPum() {

    }

}
