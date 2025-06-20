package dev.cheercode.core;

import dev.cheercode.io.FileListWriter;
import dev.cheercode.io.InputReader;
import dev.cheercode.io.TextFileListWriter;
import dev.cheercode.validation.DirectoryValidator;

import java.io.File;
import java.io.IOException;

public class DirectoryLister {
    private final InputReader inputReader;
    private final DirectoryValidator validator;

    public DirectoryLister(InputReader inputReader, DirectoryValidator validator) {
        this.inputReader = inputReader;
        this.validator = validator;
    }

    public void execute() throws IOException {
        String path = inputReader.readPath();
        int depth = inputReader.readDepth();
        String outputFileName = inputReader.readOutputFilename();
        String outputFile = path + '/' + outputFileName;

        validator.validate(path);

        try (FileListWriter writer = new TextFileListWriter(outputFile)) {
            writer.writeHeader(path, depth);
            listFilesAndDirs(new File(path), 0, depth, writer, outputFileName);
            System.out.println("Список успешно сохранен в файл: " + outputFile);
        }
    }

    private void listFilesAndDirs(File dir, int currentDepth, int maxDepth, FileListWriter writer, String outputFileName) throws IOException {
        if (currentDepth > maxDepth) {
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.getName().equals(outputFileName)) {
                continue;
            }
            String entry = file.isDirectory() ? "[D] " + file.getName() : "[F] " + file.getName();
            writer.writeEntry(entry, currentDepth);

            if (file.isDirectory()) {
                listFilesAndDirs(file, currentDepth + 1, maxDepth, writer, "");
            }
        }
    }
}
