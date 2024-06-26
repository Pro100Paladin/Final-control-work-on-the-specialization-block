package animals;

import management.Skills;

public abstract class Pets extends Animals {

    public Pets(int id, String name, int birthDate, Skills skills) {
        super(id, name, birthDate, skills);
    }
}
