package is.vinnsla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeikmadurTest {

    private Leikmadur leikmadur;

    @BeforeEach
    void setUp() {
        leikmadur = new Leikmadur("Test Leikmadur");
    }

    @Test
    void testConstructor() {
        assertNotNull(leikmadur);
        assertEquals("Test Leikmadur", leikmadur.getNafn());
        assertEquals(-1, leikmadur.getReitur());
    }

    @Test
    void testFaeraFromStart() {
        leikmadur.faera(3, 10);
        assertEquals(2, leikmadur.getReitur()); // -1 + 3 = 2
    }

    @Test
    void testFaeraFromMiddle() {
        leikmadur.faera(3, 10); // Move to position 2
        leikmadur.faera(5, 10);
        assertEquals(7, leikmadur.getReitur()); // 2 + 5 = 7
    }

    @Test
    void testFaeraCappedAtMax() {
        leikmadur.faera(3, 10); // Move to position 2
        leikmadur.faera(5, 10); // Move to position 7
        leikmadur.faera(5, 10);
        assertEquals(10, leikmadur.getReitur()); // 7 + 5 = 12, capped at 10
    }

    @Test
    void testAUpphafsReit() {
        leikmadur.faera(5, 10);
        assertEquals(4, leikmadur.getReitur()); // -1 + 5 = 4

        leikmadur.aUpphafsReit();
        assertEquals(-1, leikmadur.getReitur());
    }

    @Test
    void testReiturProperty() {
        assertNotNull(leikmadur.reiturProperty());
        assertEquals(-1, leikmadur.reiturProperty().get());
    }

    @Test
    void testFaeraWithZeroSteps() {
        leikmadur.faera(0, 10);
        assertEquals(-1, leikmadur.getReitur()); // Should remain at start
    }

    @Test
    void testFaeraToMaxBoundary() {
        leikmadur.faera(11, 10); // -1 + 11 = 10 (exactly max)
        assertEquals(10, leikmadur.getReitur());
    }

    @Test
    void testFaeraBeyondMaxBoundary() {
        leikmadur.faera(15, 10); // -1 + 15 = 14 (beyond max)
        assertEquals(10, leikmadur.getReitur()); // Should be capped at max
    }
}
