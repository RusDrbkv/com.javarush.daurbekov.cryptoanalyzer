import service.BruteForceDecypher;
import service.Cypher;
import service.Decypher;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Основное мею программы
        while (true) {
            System.out.println("Выберите режим работы:");
            System.out.println("1. Шифрование текста");
            System.out.println("2. Расшифровка текста с помощью ключа");
            System.out.println("3. Расшифровка текста с помощью brute force");
            System.out.println("0. Выход");

            int choice = scanner.nextInt(); // Читаем выбор пользователя

            // Обработка выбора пользователя
            switch (choice) {
                case 1:
                    System.out.println("Введите путь к файлу с текстом:");
                    String inputFile = scanner.next();
                    System.out.println("Введите путь к файлу для записи зашифрованного текста:");
                    String outputFile = scanner.next();
                    System.out.println("Введите ключ шифрования (число):");
                    int key = scanner.nextInt();

                    Cypher cypher = new Cypher(); // Создаем объект шифрования
                    cypher.encrypt(inputFile, outputFile, key); // Шифруем текст
                    break;

                case 2:
                    System.out.println("Введите путь к файлу с зашифрованным текстом:");
                    String encryptedFile = scanner.next();
                    System.out.println("Введите путь к файлу для записи расшифрованного текста:");
                    String decryptedOutputFile = scanner.next();
                    System.out.println("Введите ключ расшифровки (число):");
                    int decryptKey = scanner.nextInt();

                    Decypher decypher = new Decypher(); // Создаем объект расшифровки
                    decypher.decrypt(encryptedFile, decryptedOutputFile, decryptKey); // Расшифровка текста
                    break;

                case 3:
                    System.out.println("Введите путь к файлу с зашифрованным текстом:");
                    String bruteFile = scanner.next();
                    System.out.println("Введите путь к файлу для записи результатов brute force:");
                    String bruteOutputFile = scanner.next();

                    BruteForceDecypher bruteForceDecypher = new BruteForceDecypher(); // Создаем объект для brute force
                    bruteForceDecypher.decryptByBruteForce(bruteFile, bruteOutputFile); // Расшифровываем текст методом brute force
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");

            }
        }
    }
}
