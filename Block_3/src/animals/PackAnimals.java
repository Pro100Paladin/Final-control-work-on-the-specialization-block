package animals;

import animals.Animals;

import java.util.List;

public abstract class PackAnimals extends Animals {
    public PackAnimals(String name, int age, List<String> commands) {
        super(name, age, commands);
    }
}
