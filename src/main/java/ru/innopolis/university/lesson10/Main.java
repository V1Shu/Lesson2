package ru.innopolis.university.lesson10;

import ru.innopolis.university.lesson10.model.MyClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import static ru.innopolis.university.lesson7.task2.service.ServiceMethods.getOSName;

public class Main {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static ArrayList<String> CODE_ARRAY = new ArrayList<>();
    private static File workerFile = null;

    public static void main(String[] args) {
        findFileWorker(new File(System.getProperty("user.dir")));
        readWorkerFile();

        File file = fillSomeClassFile();

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
        //ru.innopolis.university.lesson10.SomeClass someClassTest = (ru.innopolis.university.lesson10.SomeClass) obj;

        try {
            Method someMethod = someClass.getDeclaredMethod("doWork");
            //someMethod.invoke(someClassTest);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static Class<?> loadSomeClass() {
        MyClassLoader classLoader = new MyClassLoader();

        Class<?> someClass = null;
        try {
            someClass = Class.forName("ru.innopolis.university.lesson10.SomeClass", true, classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return someClass;
    }

    private static void compileSomeClass(File file) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, file.getPath());
    }

    private static File fillSomeClassFile() {
        File file = new File(workerFile.getParent() + getSomeClassFileName());
        file.getParentFile().mkdirs();
        try (OutputStreamWriter dataOutputStream = new OutputStreamWriter(
                new FileOutputStream(file), StandardCharsets.UTF_8)) {
            file.createNewFile();
            dataOutputStream.write("package ru.innopolis.university.lesson10;");
            dataOutputStream.write("public class SomeClass {");
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

    private static String getSomeClassFileName() {
        String someClassName = "SomeClass.java";
        if (getOSName().startsWith("Windows")) {
            someClassName = "\\" + someClassName;
        } else {
            someClassName = "/" + someClassName;
        }
        return someClassName;
    }

    private static void readWorkerFile() {
        String str = "";
        try (DataInputStream dataInputStream = new DataInputStream(
                new FileInputStream(workerFile))) {
            boolean readMethodWork = false;
            while (dataInputStream.available() > 0) {
                str = dataInputStream.readLine();
                if (str.contains("doWork")) {
                    readMethodWork = true;
                    continue;
                } else if (str.contains("};")) {
                    readMethodWork = false;
                }
                if (readMethodWork) {
                    CODE_ARRAY.add(str);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
