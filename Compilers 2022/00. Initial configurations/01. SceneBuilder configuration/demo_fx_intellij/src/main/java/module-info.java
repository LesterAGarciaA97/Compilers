module com.lgarcia.demo_fx_intellij {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lgarcia.demo_fx_intellij to javafx.fxml;
    exports com.lgarcia.demo_fx_intellij;
}