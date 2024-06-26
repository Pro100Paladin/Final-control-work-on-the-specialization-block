package management;

import java.util.Scanner;

public interface AnimalRegisterInterface {
    void addNewAnimal(Scanner scanner);
    void showAnimalCommands(Scanner scanner);
    void trainNewCommand(Scanner scanner);
    void listAnimalsByBirthDate();
    void showAnimalCount();
}
