package ru.innopolis.university.lesson10.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Loader for new SomeClass
 * @author v.shulepov
 */
public class MyClassLoader extends ClassLoader {
    private static final Logger LOGGER = LogManager.getLogger(MyClassLoader.class);

    @Override
    protected Class<?> findClass(String name) {
        File classFile = new File(name + ".class");
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
                        new FileInputStream(classFile))) {
            byte[] content = new byte[(int) classFile.length()];
            Class<?> someClass = null;
            while (bufferedInputStream.read(content) > 0) {
                someClass = defineClass(name, content, 0, content.length);
            }
            return someClass;
        } catch (IOException e) {
            LOGGER.info("Что-то пошло не так");
            return null;
        }
    }
}
