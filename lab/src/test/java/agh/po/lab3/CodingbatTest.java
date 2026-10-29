package agh.po.lab3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodingbatTest {
    Codingbat codingBat = new Codingbat();

    @Test
    public void loneTeenTest() {
        assertEquals(true, codingBat.loneTeen(13, 99));
        assertEquals(true, codingBat.loneTeen(21, 19));
        assertEquals(false, codingBat.loneTeen(13, 13));
    }

    @Test
    public void startHiTest() {
        assertEquals(true, codingBat.startHi("hi there"));
        assertEquals(true, codingBat.startHi("hi"));
        assertEquals(false, codingBat.startHi("hello hi"));
    }

    @Test
    public void countEvensTest() {
        assertEquals(2, codingBat.countEvens(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void firstHalfTest() {
        assertEquals("Woo", codingBat.firstHalf("WooHoo"));
        assertEquals("Hello", codingBat.firstHalf("HelloThere"));
        assertEquals("abc", codingBat.firstHalf("abcdef"));
    }
}