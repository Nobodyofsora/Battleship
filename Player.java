package Battleship;

public class Player {
    public String name;
    public Character[][] myGrid = new Character[3][3];
    public Character[][] enemyGrid = new Character[3][3];

    public Player(String name) {
        resetAllGrids();
        this.name = name;
    }
    public void resetAllGrids(){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                myGrid[i][j] = ' ';
                enemyGrid[i][j] = ' ';
            }
    }
    public void resetGrid (Character[][] grid){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
    }
    public int insertCoordinates (Character x) {
        if (x == 'A' || x == 'a') return 0;
        else if (x == 'B' || x == 'b') return 1;
        else if (x == 'C' || x == 'c') return 2;
        return -1;
    }

    @Override
    public String toString() {
        String s="\n\tMy Battlefield\n\n \t1\t\t2\t\t3\n";
        for (int i=0; i<3;i++){
            if (i==0) s+="A";
            if (i==1) s+="B";
            if (i==2) s+="C";
            for (int j = 0; j < 3; j++) {
                if (j == 0) s += "|\t" + myGrid[i][j] + "\t|";
                else s += "|\t"+myGrid[i][j] + "\t|";
            }
                s+="\n";
        }
        s+="\n\tEnemy Battlefield\n\n \t1\t\t2\t\t3\n";
        for (int i=0; i<3;i++) {
            if (i==0) s+="A";
            if (i==1) s+="B";
            if (i==2) s+="C";
            for (int j = 0; j < 3; j++)
                if (j == 0) s += "|\t" + enemyGrid[i][j] + "\t|";
                else s +=  "|\t" + enemyGrid[i][j] + "\t|";
            s+="\n";
        }
        return s;
    }
}
