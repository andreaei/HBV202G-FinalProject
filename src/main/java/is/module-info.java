/******************************************************************************
 *  Nafn    : Andrea Eiríksdóttir
 *  T-póstur: ane28@hi.is
 *  Lýsing  : Hnappur sem sýnir texta þegar notandi smellir á hann  *
 *
 *****************************************************************************/
module Ludo {
    requires javafx.fxml;
    requires javafx.controls;
    opens is.vidmot to javafx.fxml;

    exports is.vidmot;
}
