import java.util.List;

public class LocationData {
    String name;
    List<String> connectedLocations;
    List<Character> characterList;

    public String getName() {
        return name;
    }

    public List<String> getConnectedLocations() {
        return connectedLocations;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }
}
