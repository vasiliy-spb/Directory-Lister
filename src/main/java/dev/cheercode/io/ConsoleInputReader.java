package dev.cheercode.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements InputReader {
    private final BufferedReader reader;

    public ConsoleInputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readPath() throws IOException {
        System.out.println("Введите путь к директории:");
        return reader.readLine();
    }

    @Override
    public int readDepth() throws IOException {
        System.out.println("Введите глубину обхода (0 - только текущая директория):");
        return Integer.parseInt(reader.readLine());
    }

    @Override
    public String readOutputFilename() throws IOException {
        System.out.println("Введите имя конечного файла для сохранения списка:");
        return reader.readLine() + ".txt";
    }
}
