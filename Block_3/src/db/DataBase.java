package db;

import animals.Animals;

import java.io.*;
import java.util.ArrayList;


public class DataBase {

    private static ArrayList<Animals> animalRegistry = new ArrayList<>();

    static {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Block_3/src/db/animal.txt", true))) {
            outputStream.writeObject(getAnimalRegistry());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Block_3/src/db/animal.txt"))) {
            animalRegistry = (ArrayList<Animals>) inputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Animals> getAnimalRegistry() {
        return animalRegistry;
    }

    public static void saveList() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Block_3/src/db/animal.txt"))) {
            outputStream.writeObject(getAnimalRegistry());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
