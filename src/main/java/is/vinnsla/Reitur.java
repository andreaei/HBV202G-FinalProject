package is.vinnsla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Reitur {

    public enum Audkenni{
        BYRJUN,
        MARK,
        VENJULEGUR
    }

    private final SimpleIntegerProperty rod = new SimpleIntegerProperty();
    private final SimpleIntegerProperty dalkur = new SimpleIntegerProperty();
    private final SimpleObjectProperty<Audkenni> audkenni
            = new SimpleObjectProperty<>(Audkenni.VENJULEGUR);

    /**
     *Gefur reiti auðkenni sitt og staðsetningu
     * @author Andrea Eiríksdóttir
     * @param rod
     * @param dalkur
     * @param audkenni
     */
    public Reitur(int rod, int dalkur, Audkenni audkenni){
        this.rod.setValue(rod);
        this.dalkur.setValue(dalkur);
        this.audkenni.setValue(audkenni);
    }

    public int getRod(){
        return rod.get();
    }

    public int getDalkur(){
        return dalkur.get();
    }

}
