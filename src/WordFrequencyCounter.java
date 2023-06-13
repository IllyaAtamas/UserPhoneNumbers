import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordFrequencyCounter {
    public static void countWordFrequency(String fileName) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }

        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}