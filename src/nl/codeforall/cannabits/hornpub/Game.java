package nl.codeforall.cannabits.hornpub;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    private Player player1;
    private Player player2;
    private Keyboard keyboard;


    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        keyboardMethodsPlayer1();
        keyboardMethodsPlayer2();
    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void keyboardMethodsPlayer1() {
        KeyboardEvent goLeft = new KeyboardEvent();
        KeyboardEvent goRight = new KeyboardEvent();
        KeyboardEvent goUp = new KeyboardEvent();
        KeyboardEvent goDown = new KeyboardEvent();

        goLeft.setKey(KeyboardEvent.KEY_LEFT);
        goLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        goDown.setKey(KeyboardEvent.KEY_DOWN);
        goDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        goRight.setKey(KeyboardEvent.KEY_RIGHT);
        goRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        goUp.setKey(KeyboardEvent.KEY_UP);
        goUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(goDown);
        keyboard.addEventListener(goLeft);
        keyboard.addEventListener(goUp);
        keyboard.addEventListener(goRight);
    }

    public void keyboardMethodsPlayer2() {
        KeyboardEvent goLeft2 = new KeyboardEvent();
        KeyboardEvent goRight2 = new KeyboardEvent();
        KeyboardEvent goUp2 = new KeyboardEvent();
        KeyboardEvent goDown2 = new KeyboardEvent();

        goLeft2.setKey(KeyboardEvent.KEY_A);
        goLeft2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        goDown2.setKey(KeyboardEvent.KEY_S);
        goDown2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        goRight2.setKey(KeyboardEvent.KEY_D);
        goRight2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        goUp2.setKey(KeyboardEvent.KEY_W);
        goUp2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(goDown2);
        keyboard.addEventListener(goLeft2);
        keyboard.addEventListener(goUp2);
        keyboard.addEventListener(goRight2);
    }

}
