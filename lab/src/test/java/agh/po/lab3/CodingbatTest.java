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
        Map<String, Integer> correct = new HashMap<>();
        correct.put("a", 1);
        correct.put("bb", 2);

        Map<String, Integer> world = new HashMap<>();
        assertEquals(correct, codingBat.wordLen(input));
    }

    @Test
    public void mapABTest() {
        assertEquals("aabb", codingBat.mapAB(new HashMap<String, String>() {{
            put("a", "aa");
            put("b", "bb");
        }}).get("ab"));
    }
}