package se.kth.assignment1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class FuvTest {
    private boolean[][] pum = new boolean[15][15];

    @BeforeEach
    void setUp() {
        Random rd = new Random();
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                pum[i][j] = rd.nextBoolean();
            }
        }
    }

    @AfterEach
    void tearDown() {
    }
}
