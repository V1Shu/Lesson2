package ru.innopolis.university.lesson7.task2.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static ru.innopolis.university.lesson7.task2.service.ServiceMethods.randomWord;

public class FileGenerator {
    private static final Random RANDOM = new Random();
    private static final List<String> wordArray = new ArrayList<>();

    public static void getFiles(String path, int n, int size, String[] words, int probability) throws IOException {
        for (int fileCount = 0; fileCount < n; fileCount++) {
            File file = new File(path + "\\output" + fileCount + ".txt");
            file.getParentFile().mkdirs();
            file.createNewFile();
            try(DataOutputStream dataOutputStream = new DataOutputStream(
                    new FileOutputStream(file))) {
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
        int sentencesInParagraph = RANDOM.nextInt(20);
        for (int sentence = 0; sentence <= sentencesInParagraph; sentence++) {
            paragraph.append(generateSentence());
            if (sentence != sentencesInParagraph) {
                paragraph.append("\n\n");
            }
        }
        return paragraph.toString();
    }

    private static StringBuilder generateSentence() {
        StringBuilder sentence = new StringBuilder();
        int wordsInSentence = (RANDOM.nextInt(15) + 1);
        List<Character> endSymbols = Arrays.asList('.', '!', '?');
        for (int word = 0; word <= wordsInSentence; word++) {
            if (word == (wordsInSentence)) {
                sentence.append(endSymbols.get(RANDOM.nextInt(3)));
            } else {
                sentence.append(randomWord());
                if (RANDOM.nextInt(10) < 2 && word != (wordsInSentence - 1)) {
                    sentence.append(',');
                }
                if (word != wordsInSentence - 1) {
                    sentence.append(" ");
                }
            }
        }
        sentence.setCharAt(0, Character.toUpperCase(sentence.charAt(0)));
        return sentence;
    }


}
