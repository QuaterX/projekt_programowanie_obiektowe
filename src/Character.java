import java.util.ArrayList;
import java.util.Arrays;

public class Character {

    protected String name;
    protected Equipment slot1;
    protected Equipment slot2;
    protected Stats baseStats;
    protected ArrayList<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.baseStats = new Stats(1,1,1,1,1);
        this.inventory = new ArrayList<>();
    }

    public Character(String name, Stats stats) {
        this.name = name;
        this.baseStats = stats;
        this.inventory = new ArrayList<>();
    }

    public Character(String name, Stats stats, Equipment slot1, Equipment slot2, Item... items) {
        this.name = name;
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.baseStats = stats;
        this.inventory = new ArrayList<>();

        inventory.addAll(Arrays.asList(items));
    }

    public void changeLocation(Location location) {

    }

    public void checkSurroundings() {

    }

    public void selectPoi() {

    }

    public void checkEnemy() {

    }

    public void attackEnemy() {

    }
}