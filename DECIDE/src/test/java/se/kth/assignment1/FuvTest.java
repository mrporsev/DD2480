package se.kth.assignment1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class FuvTest {
    private boolean[][] pum = new boolean[15][15];
    private boolean[] puv = new boolean[15];
    private boolean[] pumRows = new boolean[15];

    @BeforeEach
    void setUp() {
        Random rd = new Random();
        for (int i = 0; i < 14; i++) {
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
        Fuv fuv = new Fuv(new Pum(new int[15][15], new Cmv()), puv);
        boolean[] FUV = fuv.setFuv(pum, puv);

        for (int i = 0; i < 15; i++) {
            if (i % 2 == 1) assertTrue(FUV[i]);
            else assertEquals(pumRows[i], FUV[i]);
        }
    }
}
