package dev.cheercode;

import java.io.IOException;

interface FileListWriter extends AutoCloseable {
    void writeHeader(String path, int depth) throws IOException;

    void writeEntry(String entry, int depth) throws IOException;

    @Override
    void close() throws IOException;
}
