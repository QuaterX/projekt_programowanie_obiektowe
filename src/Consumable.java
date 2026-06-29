public class Consumable extends Item{
    private Effect effect;
    private int potency; // Potency is the value of the strength of the effect e.g. a healing potion with potency = 1 will give you less health than one with potency = 2

    public Consumable (String name, int potency, int cena, Effect effect) {
        this.name = name;
        this.cena = cena;
        this.potency = potency;
        this.effect = effect;
    }
}
