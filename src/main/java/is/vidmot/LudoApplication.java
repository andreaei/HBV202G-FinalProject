package is.vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/******************************************************************************
 *  Nafn    : Andrea Eiríksdóttir
 *  T-póstur: ane28@hi.is
 *  Lýsing  : Hnappur sem sýnir texta þegar notandi smellir á hann  *
 *
 *
 *****************************************************************************/
public class LudoApplication extends javafx.application.Application {
    /**
     * Ræsir appið
     *
     * @param stage glugginn
     * @throws Exception undnantekning sem verður ef villla
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Smíða loader fyrir notendaviðmótið sem er geymt í skránni ludo-view.fxml
        // Gætið þess að .fxml skráin sé undir resources/is/vidmot
           FXMLLoader fxmlLoader = new FXMLLoader(LudoApplication.class.getResource("/is/vidmot/CSS/ludo-view.fxml"));
        // Smíða senuna með notendaviðmótinu sem er núna lesið inn af resources
        Scene scene = new Scene(fxmlLoader.load(), 540, 745);
        // Setja titilinn á gluggann
        stage.setTitle("Halló heimur");
        // Tengja senuna við glugggann
        stage.setScene(scene);
        // Birta gluggann
        stage.show();
    }

    /**
     * Aðalforritið sem ræsir appið
     *
     * @param args ónotað
     */
    public static void main(String[] args) {
        // Ræsa forritið
        launch();
    }
}
