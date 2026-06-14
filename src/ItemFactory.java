public class ItemFactory {

    private ItemFactory() {
    }

    public static Weapon rustySword() {
        return new Weapon(
                "Rusty Sword",
                new Stats(0, 1, 0, 0, 0),
                5
        );
    }

    public static Weapon ironSword() {
        return new Weapon(
                "Iron Sword",
                new Stats(0, 3, 0, 0, 0),
                10
        );
    }

    public static Armor leatherArmor() {
        return new Armor(
                "Leather Armor",
                new Stats(0, 0, 0, 0, 2)
        );
    }

    public static Consumable healthPotion() {
        return new Consumable(
                "Health Potion",
                new Effect(
                        Effect.Type.HEAL,
                        0,
                        50
                )
        );
    }

    public static Consumable strengthPotion() {
        return new Consumable(
                "Strength Potion",
                new Effect(
                        Effect.Type.STRENGTH_BUFF,
                        3,
                        5
                )
        );
    }
}