public class Weapon extends Equipment{
    protected int damageMultiplier;

    public Weapon(String name, int cena, Stats bonusStats, int damageMultiplier) {
        this.name = name;
        this.cena = cena;
        this.bonusStats = bonusStats;
        this.damageMultiplier = damageMultiplier;
    }
}
