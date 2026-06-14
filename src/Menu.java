import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void start() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Wybierz jedną z opcji:
                    1. Nowa gra
                    2. Wczytaj grę (Unused for now)
                    3. Wyjście
                """);
        switch (input.nextInt()) {
            case 1:
                Main.initializeGame();
                break;
            case 2:
                //Unused for now... Might implement later.
                //Main.loadGameState();
                break;
            default:
                break;
        }
    }

    public static void textArt() {
        System.out.println("""
                   ______              __________  ____  __________________
                  / ____/________ _   / ____/ __ \\/ __ \\/ ____/ ____/ ____/
                 / / __/ ___/ __ `/  / __/ / /_/ / /_/ / __/ / / __/ __/  \s
                / /_/ / /  / /_/ /  / /___/ _, _/ ____/ /___/ /_/ / /___  \s
                \\____/_/   \\__,_/  /_____/_/ |_/_/   /_____/\\____/_____/  \s
                """);

    }
}
