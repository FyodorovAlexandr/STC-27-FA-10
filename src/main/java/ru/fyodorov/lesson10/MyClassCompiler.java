package ru.fyodorov.lesson10;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * MyClassCompiler позволяет скомпилировать класс
 */
public class MyClassCompiler {

    /**
     * Метод compileMyClass компилирует класс
     * @param className имя файла
     */
    public void compileMyClass(String className) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, className);
        if (result == 0) {
            System.out.println("Класс +" +className+ " скомпилирован");
        }
    }
}
