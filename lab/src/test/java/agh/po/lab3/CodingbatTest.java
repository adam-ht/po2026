package agh.po.lab3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        assertEquals(3, codingBat.countEvens(new int[]{2, 2, 2}));
        assertEquals(0, codingBat.countEvens(new int[]{1, 3, 5}));
    }

    @Test
    public void firstHalfTest() {
        assertEquals("Woo", codingBat.firstHalf("WooHoo"));
        assertEquals("Hello", codingBat.firstHalf("HelloThere"));
        assertEquals("abc", codingBat.firstHalf("abcdef"));
    }

    @Test
    public void wordLenTest() {
        String[] input = {"a", "bb", "a", "bb"};
        String[] input2 = {"a", "bb", "a", "bb", "c", "csaw"};
        String[] input3 = {"a", "bb", "a", "bb", "c", "csaw", "saw"};

        Map<String, Integer> correct = new HashMap<>();
        correct.put("a", 1);
        correct.put("bb", 2);

        Map<String, Integer> correct2 = new HashMap<>();
        correct2.put("a", 1);
        correct2.put("bb", 2);
        correct2.put("c", 1);
        correct2.put("csaw", 4);

        Map<String, Integer> correct3 = new HashMap<>();
        correct3.put("a", 1);
        correct3.put("bb", 2);
        correct3.put("c", 1);
        correct3.put("csaw", 4);
        correct3.put("saw", 3);

        assertEquals(correct, codingBat.wordLen(input));
        assertEquals(correct2, codingBat.wordLen(input2));
        assertEquals(correct3, codingBat.wordLen(input3));
    }

    @Test
    public void mapABTest() {
        assertEquals("aabb", codingBat.mapAB(new HashMap<String, String>() {{
            put("a", "aa");
            put("b", "bb");
        }}).get("ab"));
        assertEquals("ccbabbssa", codingBat.mapAB(new HashMap<String, String>() {{
            put("a", "ccba");
            put("b", "bbssa");
            put("c", "cc");
        }}).get("ab"));
        assertEquals("seatibiza", codingBat.mapAB(new HashMap<String, String>() {{
            put("a", "seat");
            put("b", "ibiza");
            put("c", "6l");
        }}).get("ab"));
    }
}