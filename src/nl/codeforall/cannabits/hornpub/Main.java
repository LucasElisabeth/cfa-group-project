package nl.codeforall.cannabits.hornpub;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello hornpub players!");

        Player player1 = new Player();
        Player player2 = new Player();
        Game game = new Game(player1, player2);

        game.start();
    }
}
