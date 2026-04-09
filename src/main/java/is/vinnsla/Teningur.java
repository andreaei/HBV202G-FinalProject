package is.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

/******************************************************************************
 *  Nafn    : Andrea Eiríksdóttir
 *  T-póstur: ane28@hi.is
 *
 *  Lýsing  : Lýsing
 *
 *
 *****************************************************************************/
public class Teningur {

    private static final int MAX = 6;
    private final IntegerProperty tala = new SimpleIntegerProperty(MAX);
    private final Random rand = new Random();

    /**
     * Kastar teningi þannig að fundin sé tala af handahófi á bilinu
     * 1 til MAX+1
     * @author Andrea Eiríksdóttir
     */
    public void kasta(){
        int kast = rand.nextInt(MAX) + 1;
        tala.setValue(kast);
    }

    public int getKast(){
        return tala.get();
    }

}

