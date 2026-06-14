public class Player extends Character {

    public Player(String name) {
        super(name);
    }

    public Player(String name, Stats stats) {
        super(name, stats);
    }

    public Player(String name, Stats stats, Equipment slot1, Equipment slot2, Item... items) {
        super(name, stats, slot1, slot2, items);
    }
}
