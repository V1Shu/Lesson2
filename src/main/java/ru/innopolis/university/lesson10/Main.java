package ru.innopolis.university.lesson10;

import ru.innopolis.university.lesson10.model.MyClassLoader;
import ru.innopolis.university.lesson10.model.Worker;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author v.shulepov
 */
public class Main {
    private final static Scanner SCANNER = new Scanner(System.in);
    /**
     * array for code, readied from console
     */
    private final static ArrayList<String> CODE_ARRAY = new ArrayList<>();
    private static File workerFile = null;

    public static void main(String[] args) {
        findFileWorker(new File(System.getProperty("user.dir")));
        readCodeFromConsole();

        File file = enterCodeToSomeClassFile();

        compileSomeClass(file);

        Class<?> someClass = loadSomeClass();

        Object obj = null;
        try {
            obj = someClass.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Worker someClassTest = (Worker) obj;

        try {
            Method someMethod = someClass.getDeclaredMethod("doWork");
            someMethod.invoke(someClassTest);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * load new SomeClass by loader
     * @return class SomeClass
     */
    private static Class<?> loadSomeClass() {
        MyClassLoader classLoader = new MyClassLoader();

        Class<?> someClass = null;
        try {
            someClass = Class.forName("ru.innopolis.university.lesson10.model.SomeClass", true, classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return someClass;
    }

    /**
     * compile file SomeClass.java to SomeClass.class
     * @param file file SomeClass.java
     */
    private static void compileSomeClass(File file) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, file.getPath());
    }

    /**
     * write code to file SomeClass.java
     * @return file with code
     */
    private static File enterCodeToSomeClassFile() {
        File file = new File(workerFile.getParent() + getSomeClassFileName());
        file.getParentFile().mkdirs();
        try (OutputStreamWriter dataOutputStream = new OutputStreamWriter(
                new FileOutputStream(file), StandardCharsets.UTF_8)) {
            file.createNewFile();
            dataOutputStream.write("package ru.innopolis.university.lesson10.model;");
            dataOutputStream.write("import ru.innopolis.university.lesson10.model.Worker;");
            dataOutputStream.write("public class SomeClass implements Worker {");
            dataOutputStream.write("public void doWork() {");
            for (String codeStr : CODE_ARRAY) {
                dataOutputStream.write(codeStr);
            }
            dataOutputStream.write("}");
            dataOutputStream.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * get name of class with separator
     * @return file name
     */
    private static String getSomeClassFileName() {
        return java.io.File.separator + "SomeClass.java";
    }

    /**
     * read code from console
     */
    private static void readCodeFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String inputLine = "";
        do {
            inputLine = scanner.nextLine();
            if (!"".equals(inputLine)) {
                CODE_ARRAY.add(inputLine);
            }
        } while("".equals(inputLine));
    }

    /**
     * find file Worker.java
     * @param dir directory to search file
     */
    private static void findFileWorker(File dir) {
        for (File fileInDir : dir.listFiles()) {
            if (fileInDir.isDirectory()) {
                findFileWorker(fileInDir);
            } else {
                if (fileInDir.getName().startsWith("Worker") && fileInDir.getName().endsWith("java")) {
                    workerFile = fileInDir;
                }
            }
        }
    }
}
