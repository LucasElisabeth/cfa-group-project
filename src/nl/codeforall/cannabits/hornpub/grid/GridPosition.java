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

    public GridPosition(int col, int row, Grid grid, Color color ) {

        this.grid = grid;
        image = new Rectangle(grid.columnToX(col), grid.rowToY(row), Grid.CELLSIZE, Grid.CELLSIZE);
        image.setColor(color);
        image.fill();
    }

    public void move(int moveRangeCol, int moveRangeRow) {

        image.translate( colToX(moveRangeCol) ,rowToY(moveRangeRow));

    }

    private int rowToY(int moveRangeRow){

        int moveRangeY = moveRangeRow * Grid.CELLSIZE;

        if (moveRangeY + image.getY() < Grid.PADDING){
            moveRangeY = -image.getY() + Grid.PADDING;
        }

        if (moveRangeY + image.getY() + Grid.PADDING > grid.height()){
            moveRangeY = grid.height() - image.getY() - image.getHeight() + Grid.PADDING;
        }

        return moveRangeY;
    }

    private int colToX(int moveRangeCol){
        int moveRangeX = moveRangeCol * Grid.CELLSIZE;

        if (moveRangeX + image.getX() < Grid.PADDING){
            moveRangeX = -image.getX() + Grid.PADDING;
        }

        if (moveRangeX + image.getX() + Grid.PADDING > grid.width()){
            moveRangeX = grid.width() - image.getX() - image.getWidth() + Grid.PADDING;
        }

        return moveRangeX;
    }

    public void setColor(Color color) {
        image.setColor(color);
    }

    public Grid getGrid() {
        return grid;
    }


    public static void gridPositionTest() throws InterruptedException {
        Grid grid = new Grid(30, 15);
        GridPosition narutoRunner = new GridPosition(5, 9, grid);
        GridPosition animeGirl = new GridPosition(8, 2, grid);
        animeGirl.setColor(Color.PINK);


        Thread.sleep(1000);
        narutoRunner.move(-100, 0);
        animeGirl.move(0, -100);
        Thread.sleep(1000);
        narutoRunner.move(100, 0);
        animeGirl.move(0, 100);

    }
}
