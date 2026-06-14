import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private ArrayList<Location> connectedLocations;
    private ArrayList<Character> charactersList;

    public Location(String name) {
        this.name = name;
        this.connectedLocations = new ArrayList<>();
        this.charactersList = new ArrayList<>();
    }

    public Location(String name, Location... poi) {
        this.name = name;
        this.connectedLocations = new ArrayList<>(List.of(poi));
        this.charactersList = new ArrayList<>();
    }

    public ArrayList<Character> getCharactersList() {
        return charactersList;
    }

    public void setCharactersList(ArrayList<Character> characters_list) {
        this.charactersList = characters_list;
    }

    public ArrayList<Location> getConnectedLocations() {
        return connectedLocations;
    }

    public void setConnectedLocations(ArrayList<Location> connectedLocations) {
        this.connectedLocations = connectedLocations;
    }

    public String getName() {
        return name;
    }

    public void addCharacterToList(Character character){
        charactersList.add(character);
    }
}
