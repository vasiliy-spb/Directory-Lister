package dev.cheercode;

import java.io.IOException;

interface InputReader {
    String readPath() throws IOException;

    int readDepth() throws IOException;

    String readOutputFilename() throws IOException;
}
