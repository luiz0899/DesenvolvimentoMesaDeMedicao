package com.br.mesademedicao.controller;

import com.br.mesademedicao.entity.Configuracao;
import com.br.mesademedicao.service.ConfiguracaoDrive;
import com.br.mesademedicao.service.Impl.ConfiguracaoDriveImpl;
import java.io.IOException;
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

public class TelaConfController  {

    @FXML
    private Button Btn_Conf;

    @FXML
    private Button Btn_Manual;

    @FXML
    private TextField TextRefPiCalculo;

    @FXML
    private TextField TextDiametroRoda;

    @FXML
    private TextField TextMicroSterp;

    @FXML
    private TextField TextPassoFuso;

    @FXML
    private TextField TextPassosPorRevolucao;

    @FXML
    private TextField TextRpm;

    @FXML
    private Button btn_List;
    
    private Configuracao configuracao;
    private TratamentoDeVariaveis tratamento;
    private ConfiguracaoDrive configuracaoDrive;
    
    @FXML
    public void initialize() {
        
        configuracaoDrive = new ConfiguracaoDriveImpl();
        
        Configuracao cfg = configuracaoDrive.carregarConfig();
            TextRpm.setText(cfg.getRpm().toString());
            TextPassosPorRevolucao.setText(cfg.getPassosPorRevolucao().toString());
            TextMicroSterp.setText(cfg.getMicrostepping().toString());
            TextPassoFuso.setText(cfg.getPassoFuso().toString());
            TextDiametroRoda.setText(cfg.getDiametroRoda().toString());
            TextRefPiCalculo.setText(cfg.getRefPiCalculo().toString());
    }
    
    @FXML
    void AbrirTelaConf(MouseEvent event) {
        
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/br/mesademedicao/view/TelaConf.fxml"));
            Stage stage = (Stage) Btn_Manual.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            System.err.println("Erro ao abrir TelaManual.fxml");
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
    void BtnSalvarVariavel(ActionEvent event) {
        try {
            tratamento = new TratamentoDeVariaveis();
            configuracaoDrive = new ConfiguracaoDriveImpl();
            
            configuracao = new Configuracao(
                tratamento.getInt(TextPassosPorRevolucao, "Passos por Revolução"),
                tratamento.getInt(TextMicroSterp, "Microstepping"),
                tratamento.getInt(TextRpm, "RPM"),
                tratamento.getDouble(TextPassoFuso, "Passo do Fuso"),
                tratamento.getDouble(TextDiametroRoda, "Diâmetro da Roda"),
                tratamento.getDouble(TextRefPiCalculo, "Referência Pi")
            );

            configuracaoDrive.salvarConfig(configuracao);

            tratamento.mostrarSucesso("Variáveis salvas com sucesso!");

        } catch (IllegalArgumentException e) {
            tratamento.mostrarErro(Alert.AlertType.ERROR,"Erro!",e.getMessage());
        }
    }







}
