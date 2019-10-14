package nl.codeforall.cannabits.hornpub;

import nl.codeforall.cannabits.hornpub.grid.Grid;
import nl.codeforall.cannabits.hornpub.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello hornpub players!");

        gridTest();
    }

    public static void gridTest() throws InterruptedException {
        Grid grid = new Grid(50, 20);
        GridPosition rectangle = new GridPosition(5, 9, grid);
        GridPosition animeGirl = new GridPosition(8, 2, grid);
        animeGirl.setColor(Color.PINK);


        Thread.sleep(1000);
        rectangle.move(-100, 0);
        animeGirl.move(0, -100);
        Thread.sleep(1000);
        rectangle.move(100, 0);
        animeGirl.move(0, 100);
    }
}
