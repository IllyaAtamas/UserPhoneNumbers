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


public class JSONConverter {
    public static void convertToJSON(String inputFileName, String outputFileName) {
        List<Map<String, Object>> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(inputFileName))) {
            String[] headers = scanner.nextLine().split(" ");

            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(" ");
                Map<String, Object> user = new LinkedHashMap<>();

                for (int i = 0; i < headers.length; i++) {
                    user.put(headers[i], values[i]);
                }

                users.add(user);
            }
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }

        try (FileWriter writer = new FileWriter(outputFileName)) {
            writer.write("[\n");

            for (int i = 0; i < users.size(); i++) {
                Map<String, Object> user = users.get(i);
                writer.write("    {\n");
                int j = 0;
                for (String key : user.keySet()) {
                    writer.write("        \"" + key + "\": \"" + user.get(key) + "\"");
                    if (j < user.size() - 1) {
                        writer.write(",");
                    }
                    writer.write("\n");
                    j++;
                }
                writer.write("    }");

                if (i < users.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }

            writer.write("]");
        } catch (IOException e) {
            System.err.println("Помилка при записі у файл: " + e.getMessage());
        }
    }
}