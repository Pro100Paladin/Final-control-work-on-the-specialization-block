package management;

import animals.Animals;
import animals.*;
import db.DataBase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static db.DataBase.getAnimalRegistry;

public class AnimalRegister implements AnimalRegisterInterface {

    @Override
    public void addNewAnimal(Scanner scanner) {
        System.out.println("\u001b[34m" + "Выберите тип животного:");
        System.out.println("\u001b[35m" + "1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Хомяк");
        System.out.println("4. Лошадь");
        System.out.println("5. Верблюд");
        System.out.println("6. Осел" + "\u001b[0m");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (dd-MM-yyyy): ");
        String birthDateStr = scanner.nextLine();
        Date birthDate;
        try {
            birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(birthDateStr);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты.");
            return;
        }
            Animals animal;
            switch (number) {
                case 1:
                    animal = new Dog(name, birthDate);
                    break;
                case 2:
                    animal = new Cat(name, birthDate);
                    break;
                case 3:
                    animal = new Hamster(name, birthDate);
                    break;
                case 4:
                    animal = new Horse(name, birthDate);
                    break;
                case 5:
                    animal = new Camel(name, birthDate);
                    break;
                case 6:
                    animal = new Donkey(name, birthDate);
                    break;
                default:
                    System.out.println("Неверный выбор.");
                    return;
            }

            getAnimalRegistry().add(animal);
            System.out.println("Животное добавлено.");
        }


    @Override
    public void showAnimalCommands(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animals animal = findAnimalByName(name);
        if (animal != null) {
            System.out.println("Команды, которые может выполнять " + animal.getType() + " - " + animal.getName() + ":");
            for (String command : animal.getCommands()) {
                System.out.println("- " + command);
            }
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    @Override
    public void trainNewCommand(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animals animal = findAnimalByName(name);
        if (animal != null) {
            System.out.print("Введите новую команду для " + animal.getName() + ": ");
            String command = scanner.nextLine();
            animal.addCommand(command);
            System.out.println("Команда добавлена.");
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    @Override
    public void listAnimalsByBirthDate() {
        getAnimalRegistry().sort(new Comparator<Animals>() {
            @Override
            public int compare(Animals a1, Animals a2) {
                return a1.getBerthDay().compareTo(a2.getBerthDay());
            }
        });

        System.out.println("Список животных по дате рождения:");
        for (Animals animal : getAnimalRegistry()) {
            System.out.println(animal.getType() + " - " + animal.getName() + " - " + new SimpleDateFormat("dd-MM-yyyy").format(animal.getBerthDay()));
        }
    }

    @Override
    public void showAnimalCount() {
        int size = DataBase.getAnimalRegistry().size();
        System.out.println("Общее количество животных: " + size);
    }

    private static Animals findAnimalByName(String name) {
        for (Animals animal : getAnimalRegistry()) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}