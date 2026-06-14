public class Stats {
    private final int level;
    private final int strength;
    private final int dexterity;
    private final int intelligence;
    private final int vitality;

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

    public Stats subtract(Stats other) {
        return new Stats(
                level - other.level,
                strength - other.strength,
                dexterity - other.dexterity,
                intelligence - other.intelligence,
                vitality - other.vitality
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