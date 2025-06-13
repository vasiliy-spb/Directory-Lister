package dev.cheercode;

import java.io.*;
import java.nio.file.*;

public class DirectoryLister {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введите путь к директории: ");
            String directoryPath = reader.readLine();

            System.out.println("Введите глубину обхода (0 - только текущая директория): ");
            int depth = Integer.parseInt(reader.readLine());

            System.out.println("Введите имя конечного файла для сохранения списка: ");
            String outputFileName = reader.readLine() + ".txt";

            File directory = new File(directoryPath);
            if (!directory.exists() || !directory.isDirectory()) {
                System.err.println("Указанный путь не существует или не является директорией");
                return;
            }

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFileName))) {
                writer.write("Список файлов и папок в директории: " + directoryPath + "\n");
                writer.write("Глубина обхода: " + depth + "\n\n");

                listFilesAndDirs(directory, 0, depth, writer);

                System.out.println("Список успешно сохранен в файл: " + outputFileName);
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: глубина обхода должна быть числом");
        } catch (IOException e) {
            System.err.println("Произошла ошибка ввода/вывода: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии потока ввода: " + e.getMessage());
            }
        }
    }

    private static void listFilesAndDirs(File dir, int currentDepth, int maxDepth, BufferedWriter writer)
            throws IOException {
        if (currentDepth > maxDepth) {
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            // Добавляем отступы в зависимости от глубины
            writer.write("  ".repeat(currentDepth));

            if (file.isDirectory()) {
                writer.write("[D] " + file.getName() + "\n");
                listFilesAndDirs(file, currentDepth + 1, maxDepth, writer);
            } else {
                writer.write("[F] " + file.getName() + "\n");
            }
        }
    }
}
