package dev.cheercode.validation;

import java.io.File;
import java.io.IOException;

public class SimpleDirectoryValidator implements DirectoryValidator {
    @Override
    public void validate(String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IOException("The specified path does not exist or is not a directory");
        }
    }
}
