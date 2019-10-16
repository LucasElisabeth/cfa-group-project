package nl.codeforall.cannabits.hornpub.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {
    public static final int PADDING = 10;
    public static final int CELLSIZE = 50;
    private int col;
    private int row;

    public Grid(int col, int row) {
         this.col = col;
         this.row = row;
         makeGrid();
    }

    public int width(){
        return col * CELLSIZE;
    }

    public int height(){
        return row * CELLSIZE;
    }

    public int columnToX(int col) {
         return col * CELLSIZE + PADDING;
    }

    public int rowToY(int row) {
        return row * CELLSIZE + PADDING;
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    private void makeGrid(){
        new Rectangle(PADDING,PADDING,width(),height()).draw();
        for (int i = 0; i < col ; i++){
            for (int j = 0; j < row;j++){
               Picture tile = new Picture(columnToX(i),rowToY(j),"source/blank50x50.png" );
               tile.draw();
            }
        }
    }
}
