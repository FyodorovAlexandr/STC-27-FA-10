package ru.fyodorov.lesson10;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Fyodorov Alexandr
 * @code Main
 * Программа позволяет построчно считать код с консоли,
 * скомпилировать в рантайме файл SomeClass.class,
 * подгрузить в программу с помощью кастомного загрузчика
 * и выполнить метод
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isEmpty = false;
        List<String> list = new ArrayList<>();

        System.out.println("Введите код метода doWork\n" +
                "Для загрузки кода нажмите Enter в пустой строке");

        while (!isEmpty) {
            String str = scanner.nextLine();
            if (!str.equals("")) {
                list.add(str);
            } else {
                isEmpty = true;
            }
        }

        /**
         * Создаем класс
         */
        MyClassCreator myClassCreator = new MyClassCreator();
        myClassCreator.createMyClass("SomeClass.java", list);

        /**
         * Компилируем класс
         */
        MyClassCompiler myClassCompiler = new MyClassCompiler();
        myClassCompiler.compileMyClass("SomeClass.java");

        /**
         * Загружаем класс
         */
        Class<?> someClass = new MyClassLoader().findClass("SomeClass");

        /**
         * Создаем объект загруженного класса
         */
        Object object = null;
        try {
            object = someClass.getDeclaredConstructors()[0].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /**
         * Выполняем метод
         */
        Worker worker = (Worker) object;
        assert worker != null;
        worker.doWork();
    }
}


