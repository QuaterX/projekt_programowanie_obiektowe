import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;

public class Main {
    static Map<String, Location> locationMap = new HashMap<>();
    static Player player;
    static Scanner input = new Scanner(System.in);

    public static void initializeGame() throws IOException {
        System.out.print("Podaj nazwę gracza: ");
        player = new Player(input.nextLine());
        loadLocations();
        player.changeLocation(locationMap.get("Town"));
        game();
    }

    public static void main(String[] args) throws IOException {
        Menu.textArt();
        Menu.start();
    }

    public static void loadLocations() throws IOException {
        Path path = Path.of("src/Locations.json");
        String json = Files.readString(path);
        Gson gson = new Gson();

        LocationData[] dataList = gson.fromJson(Files.readString(path), LocationData[].class);

        for (LocationData data : dataList) {
            Location location = new Location(data.getName());
            locationMap.put(data.getName(), location);
        }

        for (LocationData data : dataList) {

            Location current =
                    locationMap.get(data.getName());

            for (String connectedName :
                    data.getConnectedLocations()) {

                Location target =
                        locationMap.get(connectedName);

                if (target != null) {
                    current.getConnectedLocations()
                            .add(target);
                }
            }
        }
    }

    public static void game() throws IOException {
        if(player.getCurrentHp() > 0){
            game();
        }
    }
}
