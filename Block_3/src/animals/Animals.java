package animals;



import java.util.ArrayList;
import java.util.Date;

public abstract class Animals {

    protected static int id;
    protected String name;
    protected Date berthDay;
    protected ArrayList <String> commands;
    private static int animalCount = 0;

    public Animals(String name, Date berthDay) {
        this.name = name;
        this.berthDay = berthDay;
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

    public void setName(String name) {
        this.name = name;
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

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public static void setAnimalCount(int animalCount) {
        Animals.animalCount = animalCount;
    }
}
