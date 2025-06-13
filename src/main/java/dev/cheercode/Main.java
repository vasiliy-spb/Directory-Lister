package dev.cheercode;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            InputReader inputReader = new ConsoleInputReader();
            DirectoryValidator validator = new SimpleDirectoryValidator();

            DirectoryLister lister = new DirectoryLister(inputReader, validator);
            lister.execute();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
