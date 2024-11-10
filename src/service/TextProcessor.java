package service;

// Класс для обработки текста (шифрование/расшифровка)
public class TextProcessor {

    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя .,";

    // Метод для сдвига текста на заданное количество позиций
    public static String shiftText(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            result.append(shiftCharacter(ch, key));
        }
        return result.toString();
    }

    // Метод для сдвига одного символа
    private static char shiftCharacter(char ch, int key) {
        int index = ALPHABET.indexOf(ch);
        if (index == -1) return ch; // Если символ не найден в алфавите, возвращаем его без изменений

        int newIndex = (index + key + ALPHABET.length()) % ALPHABET.length(); // Сдвиг с учетом длины алфавита
        return ALPHABET.charAt(newIndex);
    }
}
