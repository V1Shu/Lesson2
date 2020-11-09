package ru.innopolis.university.lesson7.task2.model;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static ru.innopolis.university.lesson7.task2.service.ServiceMethods.getOSName;
import static ru.innopolis.university.lesson7.task2.service.ServiceMethods.randomWord;

/**
 * Generate some count of file with random sentences
 * @author v.shulepov
 */
public class FileGenerator {
    private static final Random RANDOM = new Random();

    private FileGenerator() {}

    /**
     * Generate text files
     * @param path direction for created files
     * @param n count of files
     * @param size count of paragraphs
     * @param words array of String, which may using in sentence
     * @param probability chance to using word from array words
     * @throws IOException exception with file
     */
    public static void getFiles(String path, int n, int size, String[] words, int probability) throws IOException {
        for (int fileCount = 1; fileCount <= n; fileCount++) {
            String pathName;
            if (getOSName().startsWith("Windows")) {
                pathName = path + "\\output" + fileCount + ".txt";
            } else {
                pathName = path + "/output" + fileCount + ".txt";
            }
            File file = new File(pathName);
            file.getParentFile().mkdirs();
            file.createNewFile();
            try(DataOutputStream dataOutputStream = new DataOutputStream(
                    new FileOutputStream(file))) {
                for (int paragraph = 0; paragraph <= RANDOM.nextInt(20) + 1; paragraph++) {
                    dataOutputStream.writeUTF(generateParagraph(words, probability));
                }
                try (FileChannel outChan = new FileOutputStream(file, true).getChannel()) {
                    outChan.truncate(size);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * generate paragraph with random count of sentences (up to 20)
     * @param words array of String
     * @param probability chance to using word from array words
     * @return paragraph of random sentences
     */
    private static String generateParagraph(String[] words, int probability) {
        StringBuilder paragraph = new StringBuilder();
        int sentencesInParagraph = RANDOM.nextInt(20);
        for (int sentence = 0; sentence <= sentencesInParagraph; sentence++) {
            paragraph.append(generateSentence(words, probability));
            if (sentence != sentencesInParagraph) {
                paragraph.append("\n\n");
            }
        }
        return paragraph.toString();
    }

    /**
     * Generate sentence with random words
     * @param words array of String
     * @param probability chance to using word from array words
     * @return random generate sentence
     */
    private static StringBuilder generateSentence(String[] words, int probability) {
        StringBuilder sentence = new StringBuilder();
        int wordsInSentence = (RANDOM.nextInt(15) + 1);
        List<Character> endSymbols = Arrays.asList('.', '!', '?');
        for (int word = 0; word <= wordsInSentence; word++) {
            if (word == (wordsInSentence)) {
                sentence.append(endSymbols.get(RANDOM.nextInt(3)));
            } else {
                String nextWord = (RANDOM.nextInt(probability) == 0) ?
                        words[RANDOM.nextInt(words.length - 1)]
                        : randomWord();
                        sentence.append(nextWord);
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
