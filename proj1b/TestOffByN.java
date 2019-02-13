import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    CharacterComparator offBy3 = new OffByN(3);
    CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void TestOffByN() {
        assertTrue(offBy3.equalChars('a', 'd'));
        assertFalse(offBy3.equalChars('a', 'c'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertFalse(offBy5.equalChars('z', 'x'));
    }
}
