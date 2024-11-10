package service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

// Класс для расшифровки с помощью brute-force (перебор всех ключей)
public class BruteForceDecypher {

    // Метод для расшифровки текста с использованием brute-force
    public void decryptByBruteForce(String inputFile, String outputFile) {
        try (BufferedReader reader = FileUtil.openReader(inputFile);
             BufferedWriter writer = FileUtil.openWriter(outputFile)) {

            String encryptedText = reader.readLine(); // Читаем первую строку зашифрованного текста
            for (int key = 1; key <= 32; key++) { // Пробуем все возможные ключи от 1 до 32
                String decryptedText = TextProcessor.shiftText(encryptedText, -key); // Расшифровываем с помощью текущего ключа
                writer.write("Ключ " + key + ": " + decryptedText); // Записываем результат в файл
                writer.newLine();
            }
            System.out.println("Результаты brute force сохранены в " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }
}

