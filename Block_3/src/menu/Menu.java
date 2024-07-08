package menu;

import management.AnimalRegister;

import java.util.Scanner;



public class Menu {


    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        AnimalRegister reg = new AnimalRegister();

        System.out.println("\u001b[34m" + "Реестр домашних животных V1.0");
        System.out.println("\u001b[32m" + "----------------------------------------------");

        boolean exit = false;
        while (!exit) {

            System.out.println("\u001b[35m\nМеню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Список команд животного");
            System.out.println("3. Обучение новым командам");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Показать общее количество животных");
            System.out.println("6. Выход");
            System.out.print("\u001b[34m" +"Выберите пункт меню: " + "\u001b[0m");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reg.addNewAnimal(scanner);
                    break;
                case 2:
                    reg.showAnimalCommands(scanner);
                    break;
                case 3:
                    reg.trainNewCommand(scanner);
                    break;
                case 4:
                    reg.listAnimalsByBirthDate();
                    break;
                case 5:
                    reg.showAnimalCount();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }
}


