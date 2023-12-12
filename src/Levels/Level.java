package Levels;

public class Level {
    private int[][] lvlData;

    public Level(int[][] lvlData) {
        this.lvlData = lvlData;
    }

    public int getSpriteIndex(int x, int y) { //Get specific index for sprite array
        return lvlData[y][x];
    }

    public int [][] getLvlData(){
        return lvlData;
    }
}
