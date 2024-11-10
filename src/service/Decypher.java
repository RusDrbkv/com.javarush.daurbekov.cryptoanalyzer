package service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

// Класс для расшифровки текста
public class Decypher {

    // Метод для расшифровки текста с указанным ключом
    public void decrypt(String inputFile, String outputFile, int key) {
        processFile(inputFile, outputFile, -key); // Для расшифровки используем отрицательное значение ключа
    }

    // Общий метод для обработки файла (шифрование/расшифровка)
    private void processFile(String inputFile, String outputFile, int key) {
        try (BufferedReader reader = FileUtil.openReader(inputFile);
             BufferedWriter writer = FileUtil.openWriter(outputFile)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = TextProcessor.shiftText(line, key); // Расшифровываем строку
                writer.write(decryptedLine);
                writer.newLine(); // Пишем результат в новый файл
            }
            System.out.println("Текст успешно расшифрован и сохранён в " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }
}