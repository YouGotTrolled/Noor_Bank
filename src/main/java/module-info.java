module com.example.noor_bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.noor_bank to javafx.fxml;
    exports com.example.noor_bank;
}