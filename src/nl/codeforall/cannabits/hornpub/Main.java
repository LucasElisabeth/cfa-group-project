package nl.codeforall.cannabits.hornpub;

import nl.codeforall.cannabits.hornpub.grid.GridPosition;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello hornpub players!");

        Player p1 = new Player();
        Player p2 = new Player();
        Game game = new Game(p1, p2);

        GridPosition.gridPositionTest();
//        game.start();

    }


}
