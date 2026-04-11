package is.vinnsla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeningurTest {

    private Teningur teningur;

    @BeforeEach
    void setUp() {
        teningur = new Teningur();
    }

    @Test
    void testKasta() {
        teningur.kasta();
        int kast = teningur.getKast();
        assertTrue(kast >= 1 && kast <= 6);
    }

    @Test
    void testMultipleKast() {
        for (int i = 0; i < 100; i++) {
            teningur.kasta();
            int kast = teningur.getKast();
            assertTrue(kast >= 1 && kast <= 6, "Kast should be between 1 and 6, got: " + kast);
        }
    }

    @Test
    void testInitialState() {
        assertEquals(6, teningur.getKast()); // Default initial value
    }
}
