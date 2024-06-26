package animals;

import management.Skills;

import java.util.ArrayList;

public class Animals {
    private final int id;
    private final String name;
    private final int birthDate;
    private final Skills skills;

    public Animals(int id, String name, int birthDate, Skills skills) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Pets {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", skills=" + skills +
                '}';
    }
}
