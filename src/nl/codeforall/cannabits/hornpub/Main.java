package nl.codeforall.cannabits.hornpub;

import nl.codeforall.cannabits.hornpub.grid.GridPosition;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello hornpub players!");

        Game game = new Game();
        game.init();
//        GridPosition.gridPositionTest();
        game.start();

    }


}
