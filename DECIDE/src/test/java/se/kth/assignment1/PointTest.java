package se.kth.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointTest {
    private Point point;
    @BeforeEach
    void setUp() {
        point = new Point(1.0, 2.0);
    }

    @AfterEach
    void tearDown() {
        point = null;
    }

    @Test
    void getX() {
        assertEquals(1.0, point.getX());
    }

    @Test
    void getY() {
        assertEquals(2.0, point.getY());
    }
}