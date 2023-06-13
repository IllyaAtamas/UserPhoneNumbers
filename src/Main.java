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


public class Main {
    public static void main(String[] args) {
        PhoneNumbersValidator.validatePhoneNumbers("filePhoneNumbers.txt");
        JSONConverter.convertToJSON("file.txt", "user.json");
        WordFrequencyCounter.countWordFrequency("words.txt");
    }
}