module com.colorslide {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.colorslide to javafx.fxml;
    exports com.colorslide;
}
