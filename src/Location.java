import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private ArrayList<LocationPoi> poiList;
    private ArrayList<Character> charactersList;

    public Location(String name) {
        this.name = name;
        this.poiList = new ArrayList<>();
        this.charactersList = new ArrayList<>();
    }

    public Location(String name, LocationPoi... poi) {
        this.name = name;
        this.poiList = new ArrayList<>(List.of(poi));
        this.charactersList = new ArrayList<>();
    }

    public ArrayList<Character> getCharactersList() {
        return charactersList;
    }

    public void setCharactersList(ArrayList<Character> characters_list) {
        this.charactersList = characters_list;
    }

    public ArrayList<LocationPoi> getPoiList() {
        return poiList;
    }

    public void setPoiList(ArrayList<LocationPoi> poiList) {
        this.poiList = poiList;
    }
}
