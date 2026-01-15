
package com.br.mesademedicao.util;

import java.io.OutputStream;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class ConsoleOutputStream extends OutputStream {

    private final TextArea console;

    public ConsoleOutputStream(TextArea console) {
        this.console = console;
    }

    @Override
    public void write(int b) {
        Platform.runLater(() -> {
            console.appendText(String.valueOf((char) b));
        });
    }
}