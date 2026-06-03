import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private ArrayList<LocationPoi> poi_list;
    private ArrayList<Character> characters_list;

    public Location(String name) {
        this.name = name;
        this.poi_list = new ArrayList<>();
        this.characters_list = new ArrayList<>();
    }

    public Location(String name, LocationPoi... poi) {
        this.name = name;
        this.poi_list = new ArrayList<>(List.of(poi));
        this.characters_list = new ArrayList<>();
    }

    public ArrayList<Character> getCharacters_list() {
        return characters_list;
    }

    public void setCharacters_list(ArrayList<Character> characters_list) {
        this.characters_list = characters_list;
    }

    public ArrayList<LocationPoi> getPoi_list() {
        return poi_list;
    }

    public void setPoi_list(ArrayList<LocationPoi> poi_list) {
        this.poi_list = poi_list;
    }
}
