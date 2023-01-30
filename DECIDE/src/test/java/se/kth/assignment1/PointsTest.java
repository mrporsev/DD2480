package se.kth.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointsTest {
    private Points points;
    private Point point1;
    private Point point2;
    @BeforeEach
    void setUp() {
        points = new Points(2);
        point1 = new Point(1,1);
        point2 = new Point(2,2);
    }

    @AfterEach
    void tearDown() {
        points = null;
        point1 = null;
        point2 = null;
    }

    @Test
    void add() {
        points.add(point1);
        assertEquals(1, points.size());
        assertTrue(points.contains(point1));
    }

    @Test
    void get() {
        points.add(point1);
        assertEquals(point1, points.get(0));
    }

    @Test
    void size() {
        points.add(point1);
        points.add(point2);
        assertEquals(2, points.size());
    }

    @Test
    void removeByPoint() {
        points.add(point1);
        points.add(point2);
        points.remove(0);
        assertEquals(1, points.size());
        assertTrue(points.contains(point2));
        assertFalse(points.contains(point1));
    }

    @Test
    void removeByIndex() {
        points.add(point1);
        points.add(point2);
        points.remove(point1);
        assertEquals(1, points.size());
        assertTrue(points.contains(point2));
        assertFalse(points.contains(point1));
    }

    @Test
    void contains() {
        points.add(point1);
        assertTrue(points.contains(point1));
        assertFalse(points.contains(point2));
    }

    @Test
    void clear(){
        points.add(point1);
        points.clear();
        assertEquals(0, points.size());
    }
}