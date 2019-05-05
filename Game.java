package Battleship;

public class Game {
    public Player player1;
    public Player player2;
    public int turn=0;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String startingGame(){
        if (Math.random()<=0.5) {
            turn = 1;
            return "Inizia " + player1.name;
        }
            else {
                turn=2;
                return "Inizia " + player2.name;
            }
    }
    public String play (int x, int y, int didYouWin){
        Player player;
        Player otherPlayer;
        if (this.turn==1){
            player = player1;
            otherPlayer=player2;
            turn++;
        }
        else{
            player = player2;
            otherPlayer= player1;
            turn--;
        }
        if (otherPlayer.myGrid[x][y]=='▓'){
            didYouWin++;
            if (didYouWin==2){
                this.turn=100;
                return "Colpito ed affondato! "+player.name+ " ha vinto!";
            }
            player.enemyGrid[x][y]='▓';
            return "Colpito! :D";
        }
        else {
            player.enemyGrid[x][y]='░';
            return "Mancato :(";
        }
    }
    @Override
    public String toString() {
        if (turn==1) return this.player1.toString();
        else return this.player2.toString();
    }
}
