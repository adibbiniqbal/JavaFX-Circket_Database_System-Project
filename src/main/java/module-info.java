module fx.cricketdatabase {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens fx.cricketdatabase to javafx.fxml;
    exports fx.cricketdatabase;
}