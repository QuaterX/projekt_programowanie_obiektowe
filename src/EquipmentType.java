public enum EquipmentType {
    RUSTY_SWORD(
            "Rusty Sword",
            new Stats(0, 1, 1, 1, 1),
            0
    );

    private final String name;
    private final Stats bonusStats;
    private final int additionalMult;

    EquipmentType(String name, Stats bonusStats, int additionalMult) {
        this.name = name;
        this.bonusStats = bonusStats;
        this.additionalMult = additionalMult;
    }

    public String getName() {
        return name;
    }

    public Stats getBonusStats() {
        return bonusStats;
    }

    public int getAdditionalMult() {
        return additionalMult;
    }
}
