import service.BruteForceDecypher;
import service.Cypher;
import service.Decypher;
import service.Validator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // Создаем сканер для ввода с клавиатуры
        Scanner scanner = new Scanner(System.in);
        // Создаем объект для валидации ввода
        Validator validator = new Validator();

        // Основной цикл программы
        while (true) {
            System.out.println("Выберите режим работы:");
            System.out.println("1. Шифрование текста");
            System.out.println("2. Расшифровка текста с помощью ключа");
            System.out.println("3. Расшифровка текста с помощью brute force");
            System.out.println("0. Выход");

            // Читаем выбор пользователя, используя метод валидации
            int choice = validator.getValidMenuChoice(scanner);

            // Обработка выбора пользователя
            switch (choice) {
                case 1:
                    // Шифрование
                    System.out.println("Введите путь к файлу с текстом:");
                    String inputFile = scanner.next();
                    System.out.println("Введите путь к файлу для записи зашифрованного текста:");
                    String outputFile = scanner.next();
                    System.out.println("Введите ключ шифрования (число):");
                    int key = scanner.nextInt();

                    // Создаем объект для шифрования и выполняем операцию
                    Cypher cypher = new Cypher();
                    cypher.encrypt(inputFile, outputFile, key);
                    break;

                case 2:
                    // Расшифровка с ключом
                    System.out.println("Введите путь к файлу с зашифрованным текстом:");
                    String encryptedFile = scanner.next();
                    System.out.println("Введите путь к файлу для записи расшифрованного текста:");
                    String decryptedOutputFile = scanner.next();
                    System.out.println("Введите ключ расшифровки (число):");
                    int decryptKey = scanner.nextInt();

                    // Создаем объект для расшифровки и выполняем операцию
                    Decypher decypher = new Decypher();
                    decypher.decrypt(encryptedFile, decryptedOutputFile, decryptKey);
                    break;

                case 3:
                    // Brute-force расшифровка
                    System.out.println("Введите путь к файлу с зашифрованным текстом:");
                    String bruteFile = scanner.next();
                    System.out.println("Введите путь к файлу для записи результатов brute force:");
                    String bruteOutputFile = scanner.next();

                    // Создаем объект для brute-force расшифровки и выполняем операцию
                    BruteForceDecypher bruteForceDecypher = new BruteForceDecypher();
                    bruteForceDecypher.decryptByBruteForce(bruteFile, bruteOutputFile);
                    break;

                case 0:
                    // Выход из программы
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    // Неверный выбор
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}
