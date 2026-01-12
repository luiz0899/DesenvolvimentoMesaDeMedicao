package com.br.mesademedicao.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TelaConfController  {

@FXML
    private Button Btn_Conf;

    @FXML
    private Button Btn_Manual;

    @FXML
    private Button btn_List;

        

    @FXML
    void AbrirTelaConf(MouseEvent event) {
        
         try {
            Parent root = FXMLLoader.load(
                getClass().getResource("/com/br/mesademedicao/view/TelaConf.fxml")
            );

            // pega o Stage atual
            Stage stage = (Stage) Btn_Manual.getScene().getWindow();

            // troca a cena
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            System.err.println("Erro ao abrir TelaManual.fxml");
            e.printStackTrace();
        }

    }

    @FXML
    void AbrirTelaLista(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(
                getClass().getResource("/com/br/mesademedicao/view/TelaLista.fxml")
            );

            // pega o Stage atual
            Stage stage = (Stage) Btn_Manual.getScene().getWindow();

            // troca a cena
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            System.err.println("Erro ao abrir TelaLista.fxml");
            e.printStackTrace();
        }

    }

    @FXML
    void AbrirTelaManual(MouseEvent event) {
        
       try {
            Parent root = FXMLLoader.load(
                getClass().getResource("/com/br/mesademedicao/view/TelaManual.fxml")
            );

            // pega o Stage atual
            Stage stage = (Stage) Btn_Manual.getScene().getWindow();

            // troca a cena
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            System.err.println("Erro ao abrir TelaManual.fxml");
            e.printStackTrace();
        }
    
        
    }

}
