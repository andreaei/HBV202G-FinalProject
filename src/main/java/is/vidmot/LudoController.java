package is.vidmot;

import is.vinnsla.Leikmadur;
import is.vinnsla.Ludo;
import is.vinnsla.Reitur;
import is.vinnsla.Teningur;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/******************************************************************************
 *  Nafn    : Andrea Eiríksdóttir
 *  T-póstur: ane28@hi.is
 *  Lýsing  : Hnappur sem sýnir texta þegar notandi smellir á hann  *
 *
 *****************************************************************************/
public class LudoController {

    @FXML
    private Label fxSkilabod1; // Viðmótshlutur sem geymir hver eigi að gera næst
    @FXML
    private Label fxSkilabod2; // Viðmótshlutur sem geymir stöðu leikjarins
    @FXML
    private Button fxNyrLeikur; // Takki sem hefur nýjan leik
    @FXML
    private Button fxTeningur; //Takki fyrir teing
    @FXML
    private GridPane fxBord; //Viðmótshlutur fyrir spilaborðið

    private final Map<Reitur, StackPane> vidmotLeid = new HashMap<>();

    private Ludo ludo;

    /**
     * handler fyrir að spila spilið. Teningi er kastað og staða leikmanns
     * svo uppfærð í samræmi við það. Einnig er uppfært hver skuli gera næst
     * og texti er birtur um það hvaða tölu spilarinn fékk á kasti sínu
     * @author Andrea Eiríksdóttir
     * @param event
     */
    @FXML
    private void onLeikaLeik(ActionEvent event) {
        ludo.leikaLeik();
    }

    /**
     * handler til þess að hefja nýjan leik. Spilarar fara aftur út af borðinu
     * tilbúnir að spila næsta leik
     * @author Andrea Eiríksdóttir
     * @param event
     */
    @FXML
    private void onNyrLeikur(ActionEvent event) {
        ludo.nyrLeikur();
    }

    //Upphafsástand viðmóts
    public void initialize() throws IOException {
        ludo = new Ludo();

        buaTilLeid();
        bindaLeikmenn();
        bindaHnappa();
        bindaSkilabod();

        }

    /**
     * Býr til leiðina á lúdóborðinu
     * @author Andrea Eiríksdóttir
     */
    private void buaTilLeid(){

        List<Reitur> leid = ludo.getLeid();

        for (Reitur r : leid) {

            StackPane s = new StackPane();
            s.getStyleClass().add("reitur");

            fxBord.add(s, r.getDalkur(), r.getRod());

            vidmotLeid.put(r, s);
        }
    }

    /**
     * bindur stöðu peðanna við viðmótið. Færir áfram eftir hvert kast og
     * setur svo á upphafsreit eða tekur af borði
     * @author Andrea Eiríksdóttir
     */
    private void bindaLeikmenn() {

        for (int i = 0; i < 2; i++) {

            Leikmadur leikmadur = ludo.getLeikmadur(i);

            leikmadur.reiturProperty().addListener((obs, gamalt, nytt) -> {

                if (gamalt != null && gamalt.intValue() >= 0) {
                    StackPane gamliStack = vidmotLeid.get(ludo.getLeid().get(gamalt.intValue()));
                    gamliStack.getChildren().clear();
                }

                if ( nytt != null && nytt.intValue() >= 0) {
                    StackPane nyiStack = vidmotLeid.get(ludo.getLeid().get(nytt.intValue()));
                    String slod;

                    if (leikmadur.getNafn().equals("Gulur")) {
                        slod = "/is/vidmot/CSS/myndir/gulur.jpg";
                    } else{
                        slod = "/is/vidmot/CSS/myndir/blar.jpg";
                    }

                    ImageView img = new ImageView(
                            new Image(getClass().getResourceAsStream(slod))
                    );

                    img.setFitWidth(70);
                    img.setFitHeight(70);

                    nyiStack.getChildren().add(img);
                }
            });

        }
    }


    /**
     * bindur hnappana við viðmótið. Uppfærir teninginn við hvert kast
     * @author Andrea Eiríksdóttir
     */
    private void bindaHnappa() {


        BooleanBinding erIGangi =
                ludo.astandProperty().isEqualTo(Ludo.Astand.I_GANGI);

        fxTeningur.disableProperty().bind(erIGangi.not());
        fxNyrLeikur.disableProperty().bind(erIGangi);

        fxTeningur.setOnAction(event -> {
            ludo.leikaLeik();
            int kast = ludo.getKasta(); // 1-6

            String slod = "/is/vidmot/CSS/myndir/Dice" + kast + ".jpg";
            Image img = new Image(getClass().getResourceAsStream(slod));

            ImageView imgView = new ImageView(img);
            imgView.setFitWidth(50);
            imgView.setFitHeight(50);
            imgView.setPreserveRatio(true);

            fxTeningur.setGraphic(imgView);
        });
    }

    /**
     * bindur skilaboðaboxin við viðmótið. Uppfærir textann eftir því hvað sé í
     * gangi - segir hver er að gera, hvaða tölu spilari kastaði, gefur prompt að hefja
     * nýjan leik og að ýta á teninginn.
     * @author Andrea Eiríksdóttir
     *
     */
    private void bindaSkilabod() {

        BooleanBinding erIGangi =
                ludo.astandProperty().isEqualTo(Ludo.Astand.I_GANGI);

        fxSkilabod1.textProperty().bind(
                Bindings.createStringBinding(
                        () -> {
                            Leikmadur leikmadur = ludo.nuverandiLeikmadurProperty().get();
                            if (ludo.astandProperty().get() == Ludo.Astand.I_GANGI) {
                                return leikmadur.getNafn() + " gerir";
                            } else {

                                return "Sigurvegari: " + leikmadur.getNafn();
                            }
                        },
                        ludo.nuverandiLeikmadurProperty(),
                        ludo.astandProperty()
                )
        );

        ludo.astandProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == Ludo.Astand.LOKID) {
                fxSkilabod1.setText("Sigurvegari: " + ludo.nuverandiLeikmadurProperty().get().getNafn());
            }
        });

        fxSkilabod2.textProperty().bind(
                Bindings.createStringBinding(
                        () -> {
                            if (ludo.astandProperty().get() == Ludo.Astand.LOKID) {
                                return "Ýttu á Nýr leikur til að hefja nýjan leik";
                            }

                            if (ludo.getKasta() == 0) {
                                return "Ýttu á tening til að kasta";
                            }

                            return ludo.getSidastiKastari().getNafn()
                                    + " kastaði "
                                    + ludo.getKasta();
                        },
                        ludo.nuverandiLeikmadurProperty(),
                        ludo.astandProperty()
                )
        );
    }
}


