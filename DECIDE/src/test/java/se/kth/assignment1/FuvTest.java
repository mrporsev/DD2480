package se.kth.assignment1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class FuvTest {
    private boolean[][] pum = new boolean[15][15];
    private boolean[] puv = new boolean[15];
    private boolean[] pumRows = new boolean[15];

    @BeforeEach
    void setUp() {
        Random rd = new Random();
        for (int i = 0; i < 15; i++) {
            pumRows[i] = true;
            for (int j = 0; j <= i; j++) {
                pum[i][j] = rd.nextBoolean();
                pumRows[i] = pumRows[i] && pum[i][j];
            }
            puv[i] = ((i % 2) == 0);
        }
    }

    @AfterEach
    void tearDown() {
        pum = null;
        puv = null;
        pumRows = null;
    }

    @Test
    void setFuv() {
        Fuv fuv = new Fuv(new Pum(new int[15][15], new Cmv(new LIC(), new Parameters(), new Points(0))), puv);
        boolean[] FUV = fuv.setFuv(pum, puv);

        if (0 % 2 == 1) assertTrue(FUV[0]);
        else assertEquals(pumRows[0], FUV[0]);
        if (1 % 2 == 1) assertTrue(FUV[1]);
        else assertEquals(pumRows[1], FUV[1]);
        if (2 % 2 == 1) assertTrue(FUV[2]);
        else assertEquals(pumRows[2], FUV[2]);
        if (3 % 2 == 1) assertTrue(FUV[3]);
        else assertEquals(pumRows[3], FUV[3]);
        if (4 % 2 == 1) assertTrue(FUV[4]);
        else assertEquals(pumRows[4], FUV[4]);
        if (5 % 2 == 1) assertTrue(FUV[5]);
        else assertEquals(pumRows[5], FUV[5]);
        if (6 % 2 == 1) assertTrue(FUV[6]);
        else assertEquals(pumRows[6], FUV[6]);
        if (7 % 2 == 1) assertTrue(FUV[7]);
        else assertEquals(pumRows[7], FUV[7]);
        if (8 % 2 == 1) assertTrue(FUV[8]);
        else assertEquals(pumRows[8], FUV[8]);
        if (9 % 2 == 1) assertTrue(FUV[9]);
        else assertEquals(pumRows[9], FUV[9]);
        if (10 % 2 == 1) assertTrue(FUV[10]);
        else assertEquals(pumRows[10], FUV[10]);
        if (11 % 2 == 1) assertTrue(FUV[11]);
        else assertEquals(pumRows[11], FUV[11]);
        if (12 % 2 == 1) assertTrue(FUV[12]);
        else assertEquals(pumRows[12], FUV[12]);
        if (13 % 2 == 1) assertTrue(FUV[13]);
        else assertEquals(pumRows[13], FUV[13]);
        if (14 % 2 == 1) assertTrue(FUV[14]);
        else assertEquals(pumRows[14], FUV[14]);
    }
}
