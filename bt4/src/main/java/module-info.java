module com.example.bt4 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.bt4 to javafx.fxml;
    exports com.example.bt4;
}