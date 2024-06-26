package animals;

import java.util.ArrayList;
import java.util.List;

public abstract class Animals {
    final String name;
    int age;
    List<String> commands = new ArrayList<>();


    public Animals(String name, int age, List<String> commands) {
        this.name = name;
        this.age = age;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
}
