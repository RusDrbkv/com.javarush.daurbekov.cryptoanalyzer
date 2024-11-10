package service;
import java.io.*;

// Утилитный класс для работы с файлами
public class FileUtil {

    // Метод для открытия файла на чтение
    public static BufferedReader openReader(String filePath) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
    }

    // Метод для открытия файла на запись
    public static BufferedWriter openWriter(String filePath) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
    }
}