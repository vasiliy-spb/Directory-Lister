package dev.cheercode.io;

import java.io.IOException;

public interface InputReader {
    String readPath() throws IOException;

    int readDepth() throws IOException;

    String readOutputFilename() throws IOException;
}
