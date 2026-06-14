public class Enemy extends Character {

    public Enemy(String name) {
        super(name);
    }

    public Enemy(String name, Stats stats) {
        super(name, stats);
    }

    public Enemy(String name, Stats stats, Equipment slot1, Equipment slot2, Item... items) {
        super(name, stats, slot1, slot2, items);
    }
}
