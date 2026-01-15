package com.br.mesademedicao;

import com.br.mesademedicao.entity.Configuracao;
import com.br.mesademedicao.service.ConfiguracaoDrive;
import com.br.mesademedicao.service.Impl.ConfiguracaoDriveImpl;
import com.br.mesademedicao.util.ConexaoArduino;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    private static Scene scene;
    private ConfiguracaoDrive configuracaoDrive = new ConfiguracaoDriveImpl();

 

    @Override
    public void start(Stage stage) throws IOException {
        
        //Gera a Conexão com arduino
        ConexaoArduino app = ConexaoArduino.getInstancia();
        Configuracao cfg = configuracaoDrive.carregarConfig();
        app.conectar(cfg.getNomePorta(),cfg.getBaudRate());

        scene = new Scene(loadFXML("/com/br/mesademedicao/view/TelaInicial"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}