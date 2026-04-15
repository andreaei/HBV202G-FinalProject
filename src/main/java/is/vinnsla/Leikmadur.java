package is.vinnsla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Leikmadur {

    private final SimpleIntegerProperty reitur = new SimpleIntegerProperty(-1);
    private final SimpleStringProperty nafn = new SimpleStringProperty();


    public Leikmadur(String nafn){
        this.nafn.setValue(nafn);
    }

    /**
     * Færir peð leikmanns um i sæti en þó aldrei fram yfir max
     * @author Andrea Eiríksdóttir
     * @param i sæti sem á að færa peðið fram um
     * @param max hæsta sæti
     */
    public void faera(int i, int max) {
        int nyttGildi = Math.min(reitur.get() + i, max);
        reitur.setValue(nyttGildi);
    }

    /**
     * Setur reitisgildið sem upphafsreitinn
     * @author Andrea Eiríksdóttir
     *
     */
    public void aUpphafsReit(){
       int nyttGildi = -1;
       reitur.setValue(nyttGildi);
    }

    public String getNafn(){
        return nafn.get();
    }

    public int getReitur(){
        return reitur.get();
    }

    public SimpleIntegerProperty reiturProperty(){
        return reitur;
    }
}
