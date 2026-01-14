
package com.br.mesademedicao.controller;

import com.br.mesademedicao.entity.Configuracao;
import com.br.mesademedicao.service.ConfiguracaoDrive;
import com.br.mesademedicao.service.Impl.OperacaoManualImpl;
import com.br.mesademedicao.service.OperacaoManual;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    
    
    private OperacaoManual operacao = new OperacaoManualImpl();
    private TratamentoDeVariaveis TratamentoDeVariavel;
    private TratamentoDeVariaveis tratamento = new TratamentoDeVariaveis();

    @FXML
     void AbrirTelaConf(MouseEvent event) {

        try {
           Parent root = FXMLLoader.load(getClass().getResource("/com/br/mesademedicao/view/TelaConf.fxml"));
           Stage stage = (Stage) Btn_Manual.getScene().getWindow();
           stage.setScene(new Scene(root));
       } catch (IOException e) {
           System.err.println("Erro ao abrir TelaConf.fxml");
           e.printStackTrace();
       }
   }

   @FXML
   void AbrirTelaLista(MouseEvent event) {

        try {
           Parent root = FXMLLoader.load(getClass().getResource("/com/br/mesademedicao/view/TelaLista.fxml"));
           Stage stage = (Stage) Btn_Manual.getScene().getWindow();
           stage.setScene(new Scene(root));
       } catch (IOException e) {
           System.err.println("Erro ao abrir TelaLista.fxml");
           e.printStackTrace();
       }
   }

   @FXML
   void AbrirTelaManual(MouseEvent event) {

      try {
           Parent root = FXMLLoader.load(getClass().getResource("/com/br/mesademedicao/view/TelaManual.fxml"));
           Stage stage = (Stage) Btn_Manual.getScene().getWindow();
           stage.setScene(new Scene(root));
       } catch (IOException e) {
           System.err.println("Erro ao abrir TelaManual.fxml");
           e.printStackTrace();
       }
    }

   @FXML
    void Medir(ActionEvent event) {
        
        try {
               
            
            if (ImputMedida.getText() == null || ImputMedida.getText().trim().isEmpty()) {
                tratamento.mostrarErro(Alert.AlertType.NONE, "Campo Obrigatório", "Por favor, digite o tamanho a medir!" );
            return; 
        }   
            double valMedida = Double.parseDouble(ImputMedida.getText());
            operacao.AtvMedida(valMedida);
        } catch (Exception e) {
            throw new IllegalArgumentException(e + "Digite apenas números válidos!");
        }
    }

    @FXML
    void Mov_Direita(MouseEvent event) {
        
        try {
            String textoVelocidade = ImputVelocidade.getText();

            if (textoVelocidade == null || textoVelocidade.trim().isEmpty()) {
                tratamento.mostrarErro(Alert.AlertType.WARNING, "Campo Obrigatório", "Por favor, digite a velocidade!");
                return;
            }
            Integer velocidade = Integer.parseInt(textoVelocidade);
            operacao.operacaoJogDir(velocidade);

        } catch (NumberFormatException e) {
            tratamento.mostrarErro(Alert.AlertType.ERROR, "Erro de Formato", "A velocidade deve ser um número inteiro!");
        } catch (Exception e) {
            tratamento.mostrarErro(Alert.AlertType.ERROR, "Erro", "Falha ao mover para Direita: " + e.getMessage());
        }
    }

    @FXML
     void Mov_Esquerda(MouseEvent event) {
         
         try {
             String textoVelocidade = ImputVelocidade.getText();
             
            if (textoVelocidade == null || textoVelocidade.trim().isEmpty()) {
                tratamento.mostrarErro(Alert.AlertType.WARNING, "Campo Obrigatório", "Por favor, digite a velocidade!");
                return;
            }
            Integer velocidade = Integer.parseInt(textoVelocidade);
            operacao.operacaoJogEsq(velocidade);

         } catch (NumberFormatException e) {
             tratamento.mostrarErro(Alert.AlertType.ERROR, "Erro de Formato", "A velocidade deve ser um número inteiro!");
         } catch (Exception e) {
             tratamento.mostrarErro(Alert.AlertType.ERROR, "Erro", "Falha ao mover para Esquerda: " + e.getMessage());
         }
     }

    @FXML
    void Referenciamento(ActionEvent event) {
        
        try {
            operacao.referenciar();
        } catch (Exception e) {
            throw new IllegalArgumentException( e + "Falha ao referenciar!");
        }
    }

    @FXML
    void Stop_Mov(MouseEvent event) {
        
        try {
            operacao.Stop_mov();
        } catch (Exception e) {
            throw new IllegalArgumentException( e + "Falha ao Parar o Motor!");
        }
    }  
    
    @FXML
    void Btn_Freio(ActionEvent event) {
        
        try {
            operacao.ativarFreio();
        } catch (Exception e) {
            throw new IllegalArgumentException( e + "Falha no freio!");
        }
    }
}
