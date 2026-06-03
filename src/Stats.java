public class Stats {
    private int level;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int vitality;

    public Stats(int level,
                 int strength,
                 int dexterity,
                 int intelligence,
                 int vitality) {
        this.level = level;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.vitality = vitality;
    }

    public Stats add(Stats other) {
        return new Stats(
                level + other.level,
                strength + other.strength,
                dexterity + other.dexterity,
                intelligence + other.intelligence,
                vitality + other.vitality
        );
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return 20 + (level - 1) * 2 + (vitality - 1) * 4;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getVitality() {
        return vitality;
    }
}