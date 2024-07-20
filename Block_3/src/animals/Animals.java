package animals;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class Animals implements Serializable {

    protected static int id;
    protected String name;
    protected Date berthDay;
    protected String type;
    protected ArrayList<String> commands;


    public Animals(String name, Date berthDay, String type) {
        this.name = name;
        this.berthDay = berthDay;
        this.type = type;
        this.commands = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public Date getBerthDay() {
        return berthDay;
    }


    public ArrayList<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}