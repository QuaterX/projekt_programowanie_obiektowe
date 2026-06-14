import java.util.ArrayList;
import java.util.Arrays;

public class Character {

    protected int currentHp;
    protected String name;
    protected Equipment slot1;
    protected Equipment slot2;
    protected Stats baseStats;
    protected ArrayList<Item> inventory;
    protected Location currentLocation;

    public Character(String name) {
        this.name = name;
        this.baseStats = new Stats(1,1,1,1,1);
        this.inventory = new ArrayList<>();
        this.currentHp = baseStats.getHp();
    }

    public Character(String name, Stats stats) {
        this.name = name;
        this.baseStats = stats;
        this.inventory = new ArrayList<>();
        this.currentHp = baseStats.getHp();
    }

    public Character(String name, Stats stats, Equipment slot1, Equipment slot2, Item... items) {
        this.name = name;
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.baseStats = stats;
        this.inventory = new ArrayList<>();
        this.currentHp = baseStats.getHp();

        inventory.addAll(Arrays.asList(items));
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void subtractHp(int value){
        currentHp -= value;
    }

    public void changeLocation(Location location) {
        location.addCharacterToList(this);
        currentLocation = location;
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