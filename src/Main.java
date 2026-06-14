import java.util.Scanner;

public class Main {
    static Player player;
    static Scanner input = new Scanner(System.in);
    static boolean gameover;

    public static void initializeGame() {
        System.out.print("Podaj nazwę gracza: ");
        player = new Player(input.nextLine());
        game();
    }

    public static void main(String[] args) {
        Menu.textArt();
        Menu.start();
    }

    public static void game() {

        if(player.baseStats.getHp() == 0){
            gameover = true;
        }else {
            game();
        }
    }
}
