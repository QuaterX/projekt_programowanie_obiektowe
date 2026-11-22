public class Stats {
    private final int level;
    private final int strength;
    private final int dexterity;
    private final int intelligence;
    private final int vitality;

    /**
     * This class constructor is mostly used for character creation.
     * Stats add/subtract are used to edit an existing instance of this class.
     * @param level is used for character health points calculation.
     * @param strength   \
     * @param dexterity   \
     * @param intelligence > These variables are used for calculating damage that weapons/skills do.
     *
     * @param vitality is used for character health points calculation.
     *                 This variable is different from the level variable since it is a stat that can be increased with stat points.
     */
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

    /**
     * This method is used for editing an existing instance of a Stats class.
     * @param other This object is a Stats class instance the values of which are added to the current instance.
     * @return Stats class with the added values of the other Stats class.
     */
    public Stats add(Stats other) {
        return new Stats(
                level + other.level,
                strength + other.strength,
                dexterity + other.dexterity,
                intelligence + other.intelligence,
                vitality + other.vitality
        );
    }

    /**
     * This method is used for editing an existing instance of a Stats class.
     * @param other This object is a Stats class instance the values of which are subtracted from the current instance.
     * @return Stats class with the subtracted values of the other Stats class.
     */
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