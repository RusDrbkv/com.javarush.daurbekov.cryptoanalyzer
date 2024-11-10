package service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

// Класс для шифрования текста
public class Cypher {

    // Метод для шифрования текста с указанным ключом
    public void encrypt(String inputFile, String outputFile, int key) {
        processFile(inputFile, outputFile, key);
    }

    // Общий метод для обработки файла (шифрование/расшифровка)
    private void processFile(String inputFile, String outputFile, int key) {
        try (BufferedReader reader = FileUtil.openReader(inputFile);
             BufferedWriter writer = FileUtil.openWriter(outputFile)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = TextProcessor.shiftText(line, key); // Шифруем строку
                writer.write(encryptedLine);
                writer.newLine(); // Пишем результат в новый файл
            }
            System.out.println("Текст успешно зашифрован и сохранён в " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }
}
