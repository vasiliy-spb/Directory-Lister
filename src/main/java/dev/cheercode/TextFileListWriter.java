package dev.cheercode;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextFileListWriter implements FileListWriter {
    private final BufferedWriter writer;

    public TextFileListWriter(String filename) throws IOException {
        this.writer = Files.newBufferedWriter(Paths.get(filename));
    }

    @Override
    public void writeHeader(String path, int depth) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = LocalDateTime.now().format(formatter);

        writer.write("Список файлов и папок в директории: " + path + "\n");
        writer.write("Дата: " + currentDateTime + "\n");
        writer.write("Глубина обхода: " + depth + "\n\n");
    }

    @Override
    public void writeEntry(String entry, int depth) throws IOException {
        writer.write("  ".repeat(depth) + entry + "\n");
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
