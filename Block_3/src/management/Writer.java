package management;

import animals.Animals;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static management.AnimalRegister.animalRegister;

public class Writer {


    public static void save() throws MyException {
        try {
            FileWriter writer = new FileWriter("Block_3/src/output");
            for (Animals str : animalRegister) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            throw new MyException("Ошибка в процессе записи в файл");
        }
    }



    public static void read() throws IOException {

        FileReader reader = new FileReader("Block_3/src/output");
        for (Animals str : animalRegister){
            reader.read(CharBuffer.wrap((CharSequence) AnimalRegister.animalRegister));
        }
        System.out.println(AnimalRegister.animalRegister);
    }
}
