package dev.cheercode;

import java.io.IOException;

interface DirectoryValidator {
    void validate(String path) throws IOException;
}
