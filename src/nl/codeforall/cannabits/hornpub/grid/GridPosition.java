package nl.codeforall.cannabits.hornpub.grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridPosition {
    private Grid grid;
    private int col;
    private int row;
    private Rectangle image;

    public GridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    public void move(int moveRangeX, int moveRangeY) {

    }

    private void setColor(Color color) {

    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Grid getGrid() {
        return grid;
    }
}
