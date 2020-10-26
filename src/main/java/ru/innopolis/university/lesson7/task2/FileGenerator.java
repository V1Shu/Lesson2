package ru.innopolis.university.lesson7.task2;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FileGenerator {
    static final Random RANDOM = new Random();

    public static void getFiles(String path, int n, int size, String[] words, int probability) {
        for (int file = 0; file < n; file++) {
            try(DataOutputStream dataOutputStream = new DataOutputStream(
                    new FileOutputStream(path + "\\output" + file + ".txt"))) {
                for (int paragraph = 0; paragraph < size; paragraph++) {
                    dataOutputStream.writeUTF(generateParagraph());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String generateParagraph() {
        StringBuilder paragraph = new StringBuilder();
        int sentencesInParagraph = RANDOM.nextInt(20) + 1;
        for (int sentence =0; sentence < sentencesInParagraph; sentence++) {
            paragraph.append(generateSentence());
            if (sentence != sentencesInParagraph) {
                paragraph.append("\n");
            }
        }
        return paragraph.toString();
    }

    private static StringBuilder generateSentence() {
        StringBuilder sentence = new StringBuilder();
        int wordsInSentence = (RANDOM.nextInt(15) + 1);
        List<Character> endSymbols = Arrays.asList('.', '!', '?');
        for (int word = 0; word < wordsInSentence; word++) {
            if (word == 0) {

            } else if (word == wordsInSentence) {
                sentence.append(endSymbols.get(RANDOM.nextInt(2)));
            } else {

                if (RANDOM.nextInt(10) < 3) {
                    sentence.append(',');
                }
            }
            sentence.append(" ");
        }
        return sentence;
    }
}
