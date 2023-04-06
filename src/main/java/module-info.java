module com.example.task14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task14 to javafx.fxml;
    exports com.example.task14;
}