
package com.br.mesademedicao.controller;

import com.br.mesademedicao.entity.Controle;
import com.br.mesademedicao.service.OperacaoManual;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class TelaManualController {

    @FXML
    private Button Btn_Conf;

    @FXML
    private Button Btn_Freio;

    @FXML
    private Button Btn_List;

    @FXML
    private Button Btn_Manual;

    @FXML
    private Button Btn_Medir;

    @FXML
    private Button Btn_Mov_Esq;

    @FXML
    private Button Btn_Ref;

    @FXML
    private TextField ImputMedida;

    @FXML
    private TextField ImputVelocidade;

    @FXML
    private ButtonBar Menu;
    
    private OperacaoManual operacao; 
    private Double Medida; 
 

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
               System.err.println("Erro ao abrir TelaConf.fxml");
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

    @FXML
    void Medir(ActionEvent event) {
        
    }

    @FXML
    void Mov_Direita(ActionEvent event) {  
        
       /* 
        controle.setMovDir(true);
        controle.setVelocidade(1000);
        operacao.operacaoJogDir(controle.isMovDir(),controle.getVelocidade() );
        */
    }

    @FXML
    void Mov_Esquerda(ActionEvent event) {
        
        Controle controle = new Controle(true,1000);  
        operacao.operacaoJogEsq(controle.isMovEsq(),controle.getVelocidade() );
         
    }

    @FXML
    void Referenciamento(ActionEvent event) {
     
        
    }  
}
