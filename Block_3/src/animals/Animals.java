package animals;


import java.util.ArrayList;
import java.util.Date;

public abstract class Animals {

    protected static int id;
    protected String name;
    protected Date berthDay;
    protected String type;
    protected ArrayList<String> commands;
    private static int animalCount = 0;

    public Animals(String name, Date berthDay, String type) {
        this.name = name;
        this.berthDay = berthDay;
        this.type = type;
        this.commands = new ArrayList<>();
        animalCount++;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Animals.id = id;
    }

    public String getName() {
        return name;
    }

    public Date getBerthDay() {
        return berthDay;
    }

    public void setBerthDay(Date berthDay) {
        this.berthDay = berthDay;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}