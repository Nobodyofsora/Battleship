package Battleship;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MainShip {
    public static void main(String[] args) {
        String name;
        Player player= new Player("");
        int x, y, shipLenght=2;
        Character xChar;
        Character[][] ship = new Character[3][3];
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Giocatore 1, inserisci nome");
            name = input.next();
            Player player1 = new Player(name);
            player1.resetAllGrids();
            System.out.println("Giocatore 2, inserisci nome");
            name = input.next();
            Player player2 = new Player(name);
            player2.resetAllGrids();
            Game game = new Game(player1, player2);
            for (int j=0;j<2;j++) {
                player.resetGrid(ship);
                if (j==0) player=player1;
                if (j==1) player=player2;
                System.out.println(player.toString());
                for (int i = 0; i < shipLenght; i++) {
                        System.out.println(player.name + ", inserisci la " + (i + 1) + "° riga della  nave da 2 caselle (A-B-C):");
                        xChar = input.next().charAt(0);
                        x = player.insertCoordinates(xChar);
                        System.out.println(player.name + ", inserisci la " + (i + 1) + "° colonna della nave da 2 caselle (1-2-3):");
                        y = input.nextInt();
                        y--;
                        ship[x][y] = '▓';
                        player.myGrid = ship;
                }
            }
            do {
                int win=0;
                if (game.turn==0)
                    System.out.println(game.startingGame());
                else {
                    if (game.turn==1) player=player1;
                    if (game.turn==2) player=player2;
                    System.out.println(player.toString()+player.name + ", inserisci la riga per attaccare ");
                    xChar = input.next().charAt(0);
                    x = player.insertCoordinates(xChar);
                    System.out.println(player.name + ", inserisci la colonna per attaccare ");
                    y = input.nextInt();
                    y--;
                    System.out.println(game.play(x, y, win) + "\n\n\n\n");
                }
            } while (game.turn!=100);
            System.out.println(game);
        } catch (Exception e) {
            System.out.println("Errore" + e);
        }
    }

}
