package se.kth.assignment1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PumTest {


    /**
     * Testing setPum() method
     */
    @Test
    void setPum() {
        int[][] LCM = new int[15][15];
        boolean[] CMV = new boolean[15];

        //Creating a LCM and CMV
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j <= i; j++) {
                LCM[i][j] = i % 3;
                LCM[j][i] = LCM[i][j];
            }
            CMV[i] = ((i % 2) == 0);
        }

        Pum PUM = new Pum(LCM, new Cmv(new LIC(), new Parameters(), new Points(0)));
        boolean[][] pum = PUM.setPum(LCM, CMV);

        assertTrue(pum[0][0]);
        assertFalse(pum[0][1]);
        assertTrue(pum[0][2]);
        assertTrue(pum[0][4]);
        assertTrue(pum[3][3]);
    }

}
