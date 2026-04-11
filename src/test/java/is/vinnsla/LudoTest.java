package is.vinnsla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LudoTest {

    private Ludo ludo;

    @BeforeEach
    void setUp() {
        ludo = new Ludo();
    }

    @Test
    void testConstructor() {
        assertNotNull(ludo);
        assertNotNull(ludo.getLeikmadur(0));
        assertNotNull(ludo.getLeikmadur(1));
        assertEquals(Ludo.Astand.I_GANGI, ludo.astandProperty().get());
        assertEquals(-1, ludo.getLeikmadur(0).getReitur());
        assertEquals(-1, ludo.getLeikmadur(1).getReitur());
    }

    @Test
    void testLeikaLeik() {
        assertFalse(ludo.leikaLeik());
        assertNotNull(ludo.getSidastiKastari());
        assertTrue(ludo.getKasta() >= 1 && ludo.getKasta() <= 6);
    }

    @Test
    void testNyrLeikur() {
        ludo.leikaLeik();
        ludo.nyrLeikur();
        assertEquals(Ludo.Astand.I_GANGI, ludo.astandProperty().get());
        assertEquals(-1, ludo.getLeikmadur(0).getReitur());
        assertEquals(-1, ludo.getLeikmadur(1).getReitur());
    }

    @Test
    void testLeikaLeikChangesSomePlayerPosition() {
        int oldPosition0 = ludo.getLeikmadur(0).getReitur();
        int oldPosition1 = ludo.getLeikmadur(1).getReitur();

        ludo.leikaLeik();

        int newPosition0 = ludo.getLeikmadur(0).getReitur();
        int newPosition1 = ludo.getLeikmadur(1).getReitur();

        boolean somePlayerMoved =
                oldPosition0 != newPosition0 || oldPosition1 != newPosition1;

        assertTrue(somePlayerMoved);
    }

    @Test
    void testNewGameResetsGameState() {
        ludo.leikaLeik();
        ludo.nyrLeikur();

        assertEquals(Ludo.Astand.I_GANGI, ludo.astandProperty().get());
        assertEquals(-1, ludo.getLeikmadur(0).getReitur());
        assertEquals(-1, ludo.getLeikmadur(1).getReitur());}
}
