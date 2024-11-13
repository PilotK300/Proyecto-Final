package com.example.controlador.utils;

import java.io.File;

public class OwnFile {
    private final File file;

    public OwnFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }
}
