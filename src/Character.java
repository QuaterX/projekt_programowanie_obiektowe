import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Character implements FreeroamActions {
    private String name;
    private EquipmentType slot1;
    private EquipmentType slot2;
    private Stats baseStats;
    private ArrayList<EquipmentType> inventory;

    // For creating a new character
    public Character(String name) {
        this.name = name;
        this.baseStats = new Stats(1,1,1,1,1);
        this.inventory = new ArrayList<>();
    }

    // For creating a character with already set level and baseStats
    public Character(String name, Stats stats) {
        this.name = name;
        this.baseStats = stats;
        this.inventory = new ArrayList<>();
    }

    // For creating a character with already set level, baseStats and equipment
    public Character(String name, Stats stats, EquipmentType slot1, EquipmentType slot2, EquipmentType... items) {
        this.name = name;
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.baseStats = stats;
        this.inventory = new ArrayList<>(List.of(items));
    }

    @Override
    public void changeLocation(Location location) {

    }

    @Override
    public void checkSurroundings() {

    }

    @Override
    public void selectPoi() {

    }

    @Override
    public void checkEnemy() {

    }

    @Override
    public void attackEnemy() {

    }
}
