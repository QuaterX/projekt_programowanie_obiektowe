public class Vendor extends Character implements Interactable {

    public Vendor(String name) {
        super(name);
    }

    public Vendor(String name, Stats stats) {
        super(name, stats);
    }

    public Vendor(String name, Stats stats, Equipment slot1, Equipment slot2, Item... items) {
        super(name, stats, slot1, slot2, items);
    }

    public void interact(Character character) {

    }
}
