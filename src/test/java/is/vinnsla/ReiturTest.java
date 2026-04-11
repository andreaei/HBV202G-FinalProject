package is.vinnsla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReiturTest {

    private Reitur byrjunReitur;
    private Reitur venjulegurReitur;
    private Reitur markReitur;

    @BeforeEach
    void setUp() {
        byrjunReitur = new Reitur(5, 0, Reitur.Audkenni.BYRJUN);
        venjulegurReitur = new Reitur(2, 3, Reitur.Audkenni.VENJULEGUR);
        markReitur = new Reitur(0, 5, Reitur.Audkenni.MARK);
    }

    @Test
    void testConstructor() {
        assertNotNull(byrjunReitur);
        assertNotNull(venjulegurReitur);
        assertNotNull(markReitur);
    }

    @Test
    void testGetRod() {
        assertEquals(5, byrjunReitur.getRod());
        assertEquals(2, venjulegurReitur.getRod());
        assertEquals(0, markReitur.getRod());
    }

    @Test
    void testGetDalkur() {
        assertEquals(0, byrjunReitur.getDalkur());
        assertEquals(3, venjulegurReitur.getDalkur());
        assertEquals(5, markReitur.getDalkur());
    }
}
