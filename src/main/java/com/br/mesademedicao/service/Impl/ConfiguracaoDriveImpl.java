package com.br.mesademedicao.service.Impl;

import com.br.mesademedicao.entity.Configuracao;
import com.br.mesademedicao.service.ConfiguracaoDrive;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ConfiguracaoDriveImpl implements ConfiguracaoDrive{
    
    private static final String ARQUIVO = "config.properties";

    @Override
    public void salvarConfig(Configuracao cfg) {
        try {
            Properties prop = new Properties();

            prop.setProperty("RPM", cfg.getRpm().toString());
            prop.setProperty("passosPorRevolucao", cfg.getPassosPorRevolucao().toString());
            prop.setProperty("microstepping", cfg.getMicrostepping().toString());
            prop.setProperty("passoFuso", cfg.getPassoFuso().toString());
            prop.setProperty("diametroRoda", cfg.getDiametroRoda().toString());
            prop.setProperty("refPiCalculo", cfg.getRefPiCalculo().toString());
            prop.setProperty("portaComunicao", cfg.getNomePorta().toString());
            prop.setProperty("baudRate", cfg.getBaudRate().toString());

            FileOutputStream out = new FileOutputStream("config.properties");
            prop.store(out, "Configurações da Máquina");
            out.close();

        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao salvar configurações");
        }
    }

    @Override
    public Configuracao carregarConfig() {
        try {
            File file = new File(ARQUIVO);
            Properties prop = new Properties();
            FileInputStream in = new FileInputStream(file);
            prop.load(in);
            in.close();

            return new Configuracao(
                Integer.parseInt(prop.getProperty("passosPorRevolucao")),
                Integer.parseInt(prop.getProperty("microstepping")),
                Integer.parseInt(prop.getProperty("RPM")),
                Double.parseDouble(prop.getProperty("passoFuso")),
                Double.parseDouble(prop.getProperty("diametroRoda")),
                Double.parseDouble(prop.getProperty("refPiCalculo")),
                prop.getProperty("portaComunicao"),
                Integer.parseInt(prop.getProperty("baudRate"))
            );

        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao carregar configurações");
        }
    }

   
}
