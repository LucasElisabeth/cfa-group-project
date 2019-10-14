package nl.codeforall.cannabits.hornpub.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    public static final int PADDING = 10;
    public static final int CELLSIZE = 20;
    private int col;
    private int row;

    public Grid(int col, int row) {
         this.col = col;
         this.row = row;
         new Rectangle(PADDING,PADDING,columnToX(col),rowToY(row)).draw();
    }

    private int width(){
        return col * CELLSIZE;
    }

    private int height(){
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
}
