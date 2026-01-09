module com.br.mesademedicao {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;

    opens com.br.mesademedicao.assets.img to javafx.graphics;

    opens com.br.mesademedicao.view to javafx.fxml;
    opens com.br.mesademedicao.controller to javafx.fxml;
    
    opens com.br.mesademedicao to javafx.fxml;
    exports com.br.mesademedicao;
}
