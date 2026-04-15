module Ludo {
    requires javafx.fxml;
    requires javafx.controls;
    opens is.vidmot to javafx.fxml;

    exports is.vidmot;
}
