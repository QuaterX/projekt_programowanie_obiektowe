public class Weapon extends Equipment{
    protected int damageMultiplier;

    public Weapon(String name, Stats bonusStats, int damageMultiplier) {
        this.name = name;
        this.bonusStats = bonusStats;
        this.damageMultiplier = damageMultiplier;
    }
}
