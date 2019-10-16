package nl.codeforall.cannabits.hornpub;

import nl.codeforall.cannabits.hornpub.grid.Grid;
import nl.codeforall.cannabits.hornpub.grid.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;

public class Game implements KeyboardHandler {

    private Player player1;
    private Player player2;
    private Keyboard keyboard;
    private GridPosition selectCell;


    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        Grid grid = new Grid(30,15);
        GridPosition narutoRunner = new GridPosition(5, 9, grid);
        GridPosition animeGirl = new GridPosition(8, 2, grid);

        selectCell = new GridPosition(0, 0, grid, Grid.CELLSIZE, Grid.CELLSIZE);

        keyboardMethodsPlayers();
    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                selectCell.move(0, Grid.CELLSIZE);
                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void keyboardMethodsPlayers() {
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

        KeyboardEvent select = new KeyboardEvent();
        KeyboardEvent confirm = new KeyboardEvent();
        select.setKey(KeyboardEvent.KEY_SPACE);
        select.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        confirm.setKey(KeyboardEvent.KEY_ENTER);
        confirm.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(confirm);
        keyboard.addEventListener(select);
    }
}
