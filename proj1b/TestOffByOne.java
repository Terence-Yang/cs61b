import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        assertFalse(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('c', 'a'));
        assertFalse(offByOne.equalChars('A', 'A'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('B', 'A'));
        assertFalse(offByOne.equalChars('A', 'C'));
        assertFalse(offByOne.equalChars('C', 'A'));
        assertTrue(offByOne.equalChars('%', '&'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('$', '&'));
        assertFalse(offByOne.equalChars('&', '$'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('a', '%'));
        assertFalse(offByOne.equalChars('A', '%'));
    }
}
