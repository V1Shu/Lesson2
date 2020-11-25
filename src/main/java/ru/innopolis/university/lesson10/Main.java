package ru.innopolis.university.lesson10;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    /**
     * array for code, readied from console
     */
    private static final ArrayList<String> CODE_ARRAY = new ArrayList<>();

    public static void main(String[] args){
        readCodeFromConsole();

        File file = enterCodeToSomeClassFile();

        compileSomeClass(file);

        Class<?> someClass = loadSomeClass();

        Object obj = null;
        try {
            obj = someClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.info("Can't create instance of SomeClass");
        }

        Worker someClassTest = (Worker) obj;

        try {
            Method someMethod = someClass.getDeclaredMethod("doWork");
            someMethod.invoke(someClassTest);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            LOGGER.info("Can't call method from SomeClass");
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
            LOGGER.info("SomeClass not found");
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
        File file = new File(getPathToSomeClass());
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
            LOGGER.info("Can't write file SomeClass.java");
        }
        return file;
    }

    private static String getPathToSomeClass() {
        return Main.class.getClassLoader().getResource("path").getPath().replace("path","") +
                "ru\\innopolis\\university\\lesson10\\model\\SomeClass.java";
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
}
