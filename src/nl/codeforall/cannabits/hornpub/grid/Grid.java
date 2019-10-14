package nl.codeforall.cannabits.hornpub.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    public static final int PADDING = 10;
    public static final int CELLSIZE = 30;
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
        for (int i = 0; i <= col ; i++){
            for (int j = 0; j <= row;j++){
                new Rectangle(i * Grid.CELLSIZE + Grid.PADDING,j * Grid.CELLSIZE + Grid.PADDING, Grid.CELLSIZE, Grid.CELLSIZE).draw();
            }
        }
    }
}
