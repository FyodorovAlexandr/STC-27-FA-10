package ru.fyodorov.lesson10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * MyClassLoader загружает класс
 */
public class MyClassLoader extends ClassLoader {

    /**
     * Метод позволяет загрузить класс
     * @param name имя загружаемого класса
     * @return возвращаем экземпляр class
     */
    @Override
    public Class<?> findClass(String name) {
        byte[] bytes = new byte[0];
        try{
            bytes = Files.readAllBytes(Paths.get("SomeClass.class"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(null, bytes, 0, bytes.length);
    }
}
