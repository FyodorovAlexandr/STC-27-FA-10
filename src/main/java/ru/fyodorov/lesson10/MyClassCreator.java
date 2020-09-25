package ru.fyodorov.lesson10;

import java.io.*;
import java.util.*;

/**
 * MyClassCreator позволяет создать файл класса, с добавлением метода
 */
public class MyClassCreator {

    public void createMyClass(String fileName, List<String> list) {
        File file = new File("");
        String path = null;
        try {
            path = file.getCanonicalPath() + File.separator + fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> code = new ArrayList<>();
        code.add(this.getClass().getPackage() + ";\n");
        code.add("public class SomeClass implements Worker {");
        code.add("    public void doWork() {");

        assert path != null;
        try(FileWriter fileWriter = new FileWriter(path, false)){
            for(String str : list){
                code.add("        " + str);
            }
            code.add("    }");
            code.add("}");
            fileWriter.write(String.join(System.lineSeparator(), code));
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = new File(path);
        if(file.exists() && file.isFile()){
            System.out.println("Файл " + fileName + " создан");
            System.out.println("Код добавлен в метод");
        }
    }
}
