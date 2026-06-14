public class Consumable extends Item{
    private Effect effect;

    public Consumable (String name, Effect effect) {
        this.name = name;
        this.effect = effect;
    }
}
