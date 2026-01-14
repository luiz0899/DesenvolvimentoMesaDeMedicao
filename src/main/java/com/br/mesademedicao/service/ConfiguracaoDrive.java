
package com.br.mesademedicao.service;

import com.br.mesademedicao.entity.Configuracao;


public interface ConfiguracaoDrive {
    public void salvarConfig(Configuracao cfg);
    
    public Configuracao carregarConfig();
}
