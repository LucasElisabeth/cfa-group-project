package nl.codeforall.cannabits.hornpub.grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import javax.print.attribute.standard.RequestingUserName;

public class GridPosition {
    private Grid grid;
    private Rectangle image;

    public GridPosition(Grid grid){
         this((int) (Math.random() * grid.getCol() ), (int) (Math.random() * grid.getRow()) , grid);
    }

    public GridPosition(int col, int row, Grid grid) {

        this.grid = grid;
        image = new Rectangle(grid.columnToX(col), grid.rowToY(row), Grid.CELLSIZE, Grid.CELLSIZE);
        image.fill();
    }

    public void move(int moveRangeCol, int moveRangeRow) {

        image.delete();
        image.translate(moveRangeCol * Grid.CELLSIZE ,moveRangeRow * Grid.CELLSIZE);
        image.fill();

    }

    public void setColor(Color color) {
        image.setColor(color);
    }

    public Grid getGrid() {
        return grid;
    }
}
