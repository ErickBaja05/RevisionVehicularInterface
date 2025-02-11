package Controladores;

import java.io.*;


public class CustomObjectOutputStream extends ObjectOutputStream {
    public CustomObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // No escribir el encabezado para evitar corrupción del archivo
        reset();
    }
}