module com.example.noor_bank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.noor_bank to javafx.fxml;
    exports com.example.noor_bank;
}