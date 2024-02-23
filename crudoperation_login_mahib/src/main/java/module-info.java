module com.example.crudoperation_login_mahib {
    requires javafx.controls;
    requires javafx.fxml;
            
                                requires com.almasb.fxgl.all;
    
    opens com.example.crudoperation_login_mahib to javafx.fxml;
    exports com.example.crudoperation_login_mahib;
}