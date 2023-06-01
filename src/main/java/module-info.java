module com.example.pontifavorv0 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pontifavorv0 to javafx.fxml;
    exports com.example.pontifavorv0;
}