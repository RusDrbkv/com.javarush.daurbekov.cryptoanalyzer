package service;
import java.io.*;
import java.nio.charset.StandardCharsets;

// Утилитный класс для работы с файлами
public class FileUtil {
    public static BufferedReader openReader(String filePath) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
    }
    public static BufferedWriter openWriter(String filePath) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8));
    }
}
