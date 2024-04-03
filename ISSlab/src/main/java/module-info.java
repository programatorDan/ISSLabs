module com.example.isslab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.isslab to javafx.fxml;
    exports com.example.isslab;
    exports com.example.isslab.controller;
}