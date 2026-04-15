package is.vinnsla;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Ludo {

    public enum Astand{
        I_GANGI,
        LOKID
    }

    private Leikmadur[] leikmenn;
    private Leikmadur leikmadur;
    private Leikmadur sidastiKastari;
    private Leikmadur sigurvegari;
    private ArrayList<Reitur> leid;
    private Teningur teningur;
    private int kasta;

    private int nuverandiLeikmadurIndex = 0;

    private final SimpleObjectProperty<Astand> astand =
            new SimpleObjectProperty<Astand>(Astand.I_GANGI);

    private final SimpleObjectProperty<Leikmadur> nuverandiLeikmadur =
            new SimpleObjectProperty<>();

    /**
     * Uppsetningin á Ludo
     * @author Andrea Eiríksdóttir
     */
    public Ludo() {
        leikmenn = new Leikmadur[2];
        leikmenn[0] = new Leikmadur("Gulur");
        leikmenn[1] = new Leikmadur("Blár");

        nuverandiLeikmadur.set(leikmenn[0]);

        leid = new ArrayList<>();
        leid.add(new Reitur(5, 0, Reitur.Audkenni.BYRJUN));
        for (int i = 4; i > 0; i--) {
            leid.add(new Reitur(i, 0, Reitur.Audkenni.VENJULEGUR));
        }
        for( int i = 0; i < 5; i++){
            leid.add(new Reitur(0, i, Reitur.Audkenni.VENJULEGUR));
        }
        leid.add(new Reitur(0, 5, Reitur.Audkenni.MARK));

        teningur = new Teningur();

    }

    /**
     * Ein upferð í spilinu. Fylgist með því hvort einhver hafi sigrað og
     * hvort leikmaður hafi lent á reiti hins, sem þá þarf að fara á
     * upphafsreit
     * @author Andrea Eiríksdóttir
     * @return true ef leiknum er lokið, annars false
     */
    public boolean leikaLeik() {

        if (astand.get() == Astand.LOKID) {
            return true;
        }

        Leikmadur leikmadur = leikmenn[nuverandiLeikmadurIndex];

        sidastiKastari = leikmadur;

        teningur.kasta();
        kasta = teningur.getKast();

        int nyReitur = leikmadur.getReitur() + kasta;

        for (Leikmadur annar : leikmenn) {
            if (annar != leikmadur && annar.getReitur() == nyReitur) {
                annar.aUpphafsReit();
            }
        }

        leikmadur.faera(kasta, leid.size() - 1);

        if (leikmadur.getReitur() >= leid.size() - 1) {
            astand.set(Astand.LOKID);
            nuverandiLeikmadur.set(leikmadur);  // svo sigurvegari birtist rétt
            return true;
        }

        nuverandiLeikmadurIndex =
                (nuverandiLeikmadurIndex + 1) % leikmenn.length;

        nuverandiLeikmadur.set(leikmenn[nuverandiLeikmadurIndex]);

        return false;
    }

    /**
     * Setur leikinn aftur í upphafsstöðu, tilbúinn að hefja nýjan leik
     * @author Andrea Eiríksdóttir
     */
    public void nyrLeikur() {

        for (Leikmadur l : leikmenn) {
            l.faera(-l.getReitur(), -1); //
        }

        nuverandiLeikmadurIndex = 0;
        nuverandiLeikmadur.set(leikmenn[0]);
        astand.set(Astand.I_GANGI);
        sigurvegari = null;
    }

    public ArrayList<Reitur> getLeid() {
        return leid;
    }

    public int getKasta(){
        return kasta;
    }

    public Leikmadur getSidastiKastari() {
        return sidastiKastari;
    }


    public Leikmadur getLeikmadur(int index) {
        return leikmenn[index];
    }

    public SimpleObjectProperty<Astand> astandProperty() {
        return astand;
    }

    public SimpleObjectProperty<Leikmadur> nuverandiLeikmadurProperty() {
        return nuverandiLeikmadur;
    }

}


