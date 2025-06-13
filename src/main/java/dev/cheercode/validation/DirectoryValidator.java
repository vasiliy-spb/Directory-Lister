package dev.cheercode.validation;

import java.io.IOException;

public interface DirectoryValidator {
    void validate(String path) throws IOException;
}
