package service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decypher {
    public void decrypt(String inputFile, String outputFile, int key) {
        try (BufferedReader reader = FileUtil.openReader(inputFile);
             BufferedWriter writer = FileUtil.openWriter(outputFile)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = shiftText(line, -key); // Расшифровываем каждую строку
                writer.write(decryptedLine); // Записываем расшифрованную строку в файл
                writer.newLine();
            }
            System.out.println("Текст успешно расшифрован и сохранён в " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }

    // Метод для сдвига текста по алфавиту
    protected String shiftText(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            char shiftedChar = shiftCharacter(ch, key); // Сдвигаем каждый символ
            result.append(shiftedChar);
        }
        return result.toString();
    }

    // Метод для сдвига отдельного символа
    private char shiftCharacter(char ch, int key) {
        String alphabet = "абвгдезийклмнопрстуфхцчшщъыьэюя .,";
        int index = alphabet.indexOf(ch); // Находим индекс символа в алфавите

        if (index == -1) return ch;

        // Сдвигаем символ с учетом кольцевого перехода
        int newIndex = (index + key + alphabet.length()) % alphabet.length(); // Если символ не найден, возвращаем его без изменений
        return alphabet.charAt(newIndex);
    }
}
