package utilz;

import Main.Game;

public class HelpMethods {

    //Check position
    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData){ //Stop when hit wall
        //check solid
        if(!IsSolid(x, y, lvlData)) //top left
            if(!IsSolid(x + width, y + height, lvlData)) //bottom right
                if(!IsSolid(x + width, y, lvlData)) //top right
                    if(!IsSolid(x, y + height, lvlData)) //bottom left
                        return true;
        return false;

    }

    //Check whether or not it is a tile and check position inside the game window or not
    private static boolean IsSolid(float x, float y, int[][] lvlData){
        if(x < 0 || x >= Game.GAME_WIDTH)
            return true;
        if(y < 0 || y >= Game.GAME_HEIGHT)
            return true;

        float xIndex = x / Game.TILES_SIZE;
        float yIndex = y / Game.TILES_SIZE;

        int value = lvlData[(int) yIndex][(int) xIndex];
        if(value >= 48 || value < 0 || value != 11)
            return true;
        return false;
    }
}
