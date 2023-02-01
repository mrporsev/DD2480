package se.kth.assignment1;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class FuvTest {

    /**
     * Testing setFuv() method
     */
    @Test
    void setFuv() {

        boolean[][] pum = new boolean[15][15];
        boolean[] puv = new boolean[15];
        boolean[] pumRows = new boolean[15];

        //Creating a random PUM and a PUV which alternate between true and false
        Random rd = new Random();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j <= i; j++) {
                pum[i][j] = rd.nextBoolean();
                pum[j][i] = pum[i][j];
            }
            puv[i] = ((i % 2) == 0);

        }

        //Computing manually the FUV if all entries of the PUV were set to true
        for (int i = 0; i < 15; i++) {
            pumRows[i] = true;
            for (int j = 0; j < 15; j++) {
                pumRows[i] = pumRows[i] && pum[i][j];
            }
        }


        //Getting the FUV computed by the setFuv() method
        Fuv fuv = new Fuv(new Pum(new int[15][15], new Cmv(new LIC(), new Parameters(), new Points(0))), puv);
        boolean[] FUV = fuv.setFuv(pum, puv);


        assertEquals(pumRows[0], FUV[0]);
        assertTrue(FUV[1]);
        assertEquals(pumRows[2], FUV[2]);
        assertTrue(FUV[3]);
        assertEquals(pumRows[4], FUV[4]);
        assertTrue(FUV[5]);
        assertEquals(pumRows[6], FUV[6]);
        assertTrue(FUV[7]);
        assertEquals(pumRows[8], FUV[8]);
        assertTrue(FUV[9]);
        assertEquals(pumRows[10], FUV[10]);
        assertTrue(FUV[11]);
        assertEquals(pumRows[12], FUV[12]);
        assertTrue(FUV[13]);
        assertEquals(pumRows[14], FUV[14]);
        
    }
}
