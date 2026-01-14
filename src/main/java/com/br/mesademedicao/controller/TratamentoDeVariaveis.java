package com.br.mesademedicao.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TratamentoDeVariaveis {
    
     public int getInt(TextField field, String nomeCampo) {
        try {
            String txt = field.getText().trim();

            if (txt.isEmpty())
                throw new IllegalArgumentException(nomeCampo + " está vazio");

            return Integer.parseInt(txt);
        } catch (Exception e) {
            throw new IllegalArgumentException("Valor inválido em " + nomeCampo);
        }
    }
    
    public double getDouble(TextField field, String nomeCampo) {
        try {
            String txt = field.getText().trim().replace(",", ".");

            if (txt.isEmpty())
                throw new IllegalArgumentException(nomeCampo + " está vazio");

            return Double.parseDouble(txt);
        } catch (Exception e) {
            throw new IllegalArgumentException("Valor inválido em " + nomeCampo);
        }
    }
       
    public void mostrarErro(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText("Erro de validação");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public void mostrarSucesso(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
    
}
