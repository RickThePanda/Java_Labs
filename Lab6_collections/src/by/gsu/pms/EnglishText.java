package by.gsu.pms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class EnglishText {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src\\in.txt");

        Scanner scanner = new Scanner(file);
        HashSet<String> text = new HashSet<>();

        while (scanner.hasNext()){
            text.add(scanner.next().toLowerCase());

        }

        for (String word: text) {
            System.out.println(word);
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("src\\out.txt"));
            for (String word: text) {
                writer.write(
                        word + "\n"
                );
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
