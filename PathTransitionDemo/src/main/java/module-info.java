module es.ieslosmontecillos.pathtransitiondemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.crypto;


    opens es.ieslosmontecillos.pathtransitiondemo to javafx.fxml;
    exports es.ieslosmontecillos.pathtransitiondemo;
}