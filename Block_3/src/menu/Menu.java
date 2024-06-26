package menu;

import java.util.Scanner;



public class Menu {


    public static void menu() {
        Scanner userText = new Scanner(System.in);
        int userTextMenu;
        do {
            System.out.println("\u001B[34m" + "Реестр домашних животных v1.0");
            System.out.println("\u001B[32m" + "----------------------------------------" + "\u001B[0m");
            System.out.println("1.: Кол-во домашних животных: ");
            System.out.println("2.: Список домашних животных: ");
            System.out.println("3.: Команды домашних животных: ");
            System.out.println("4.: Обучить животное новой команде: ");
            System.out.println("5.: Завести новое животное: ");
            System.out.println("6.: Исключит животное: ");
            System.out.println("7. Выход:");
            System.out.println("\u001b[31m" + "введите пункт меню: " + "\u001b[0m");

            userTextMenu = userText.nextInt();
        }while (userTextMenu > 7);
            switch (userTextMenu){
                case 1: System.out.println("rjv");
                    break;
                case 2: System.out.println();
                    break;
                case 3: System.out.println();
                    break;
                case 4: System.out.println("rjv");
                    break;
                case 5: System.out.println();
                    break;
                case 6: System.out.println();
                    break;
                case 7: System.out.println("До свидания :)");
                    break;
        }
    }
}


