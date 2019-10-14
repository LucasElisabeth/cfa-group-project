package nl.codeforall.cannabits.hornpub;

import nl.codeforall.cannabits.hornpub.grid.Grid;
import nl.codeforall.cannabits.hornpub.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello hornpub players!");

        Grid grid = new Grid(80,40);
        GridPosition rectangle = new GridPosition(60,29,grid);
        GridPosition animeGirl = new GridPosition(0,0,grid);
        animeGirl.setColor(Color.PINK);

        Thread.sleep(2000);

        rectangle.move(200,0);
        animeGirl.move(-12,0);
    }
}
