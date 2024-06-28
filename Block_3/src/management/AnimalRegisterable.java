package management;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface AnimalRegisterable {
    void addNewAnimal(Scanner scanner) throws FileNotFoundException;
    void showAnimalCommands(Scanner scanner);
    void trainNewCommand(Scanner scanner);
    void listAnimalsByBirthDate();
    void showAnimalCount();
}
