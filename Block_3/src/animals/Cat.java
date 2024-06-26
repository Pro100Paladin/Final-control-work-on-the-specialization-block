package animals;

import management.Skills;

import java.util.Scanner;

import static management.Skills.*;

public class Cat extends Pets{

    public Cat(int id, String name, int birthDate, Skills skills) {
        super(id, name, birthDate, skills);
    }

    public static void addCat(){

        Cat cat = new Cat(1,"Cat", 2, SIT);
        System.out.println(cat);
    }

}

