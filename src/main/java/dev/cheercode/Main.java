package dev.cheercode;

import dev.cheercode.core.DirectoryLister;
import dev.cheercode.io.ConsoleInputReader;
import dev.cheercode.io.InputReader;
import dev.cheercode.validation.DirectoryValidator;
import dev.cheercode.validation.SimpleDirectoryValidator;

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
