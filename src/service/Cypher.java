package service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Cypher {
    public void encrypt(String inputFile, String outputFile, int key) {
        try (BufferedReader reader = FileUtil.openReader(inputFile);
             BufferedWriter writer = FileUtil.openWriter(outputFile)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = shiftText(line, key); // Шифруем каждую строку
                writer.write(encryptedLine); // Записываем зашифрованную строку в файл
                writer.newLine(); // Переход на новую строку
            }
            System.out.println("Текст успешно зашифрован и сохранён в " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }

    // Метод для сдвига текста по алфавиту
    private String shiftText(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            char shiftedChar = shiftCharacter(ch, key );
            result.append(shiftedChar);
        }
        return result.toString();
    }

    // Метод для сдвига отдельного символа
    private char shiftCharacter(char ch, int key) {
        // Предполагаем, что алфавит русский и содержит пробел
        String alphabet = "абвгдезийклмнопрстуфхцчшщъыьэюя .,";
        int index = alphabet.indexOf(ch); // Находим индекс символа в алфавите

        if (index == -1) return ch; // Если символ не найден, возвращаем его без изменений

        // Сдвигаем символ с учетом кольцевого перехода
        int newIndex = (index + key) % alphabet.length();
        return alphabet.charAt(newIndex); // Возвращаем новый сдвинутый символ
    }
}
