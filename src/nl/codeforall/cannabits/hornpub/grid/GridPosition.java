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

        image.translate( colToX(moveRangeCol) ,rowToY(moveRangeRow));

    }

    private int rowToY(int moveRangeRow){

        int moveRangeY = moveRangeRow * Grid.CELLSIZE;

        if (moveRangeY + image.getY() < Grid.PADDING){
            moveRangeY = -image.getY() + Grid.PADDING;
        }

        if (moveRangeY + image.getY() > grid.height()){
            moveRangeY = grid.height() - image.getY() + Grid.PADDING;
        }

        return moveRangeY;
    }

    private int colToX(int moveRangeCol){
        int moveRangeX = moveRangeCol * Grid.CELLSIZE;

        if (moveRangeX + image.getX() < Grid.PADDING){
            moveRangeX = -image.getX() + Grid.PADDING;
        }

        if (moveRangeX + image.getX() > grid.width()){
            moveRangeX = grid.width() - image.getX() + Grid.PADDING;
        }

        return moveRangeX;
    }

    public void setColor(Color color) {
        image.setColor(color);
    }

    public Grid getGrid() {
        return grid;
    }

    public static void gridTest() throws InterruptedException {
        Grid grid = new Grid(85, 40);
        GridPosition rectangle = new GridPosition(60, 29, grid);
        GridPosition animeGirl = new GridPosition(40, 29, grid);
        animeGirl.setColor(Color.PINK);

        for (int i = 0; i <= grid.getCol() ; i++){

            for (int j = 0; j <= grid.getRow();j++){
                new Rectangle(i * Grid.CELLSIZE + Grid.PADDING,j * Grid.CELLSIZE + Grid.PADDING, Grid.CELLSIZE, Grid.CELLSIZE).draw();
            }
        }


        Thread.sleep(1000);
        rectangle.move(-100, 0);
        animeGirl.move(0, -100);
        Thread.sleep(1000);
        rectangle.move(100, 0);
        animeGirl.move(0, 100);
    }
}