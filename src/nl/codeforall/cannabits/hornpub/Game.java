package nl.codeforall.cannabits.hornpub;

import nl.codeforall.cannabits.hornpub.grid.Grid;
import nl.codeforall.cannabits.hornpub.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Game implements KeyboardHandler {

    private Player player1;
    private Player player2;
    private GridPosition selectCell;
    private GridPosition animeGirl;


    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        keyboardMethodsPlayers();

        Grid grid = new Grid(15, 9);
        GridPosition narutoRunner = new GridPosition(5, 8, grid);
        animeGirl = new GridPosition(8, 2, grid);

        selectCell = new GridPosition(0, 0, grid, Color.RED);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        boolean comparePositionsWithAnimeGirl = selectCell.getGrid().rowToY(selectCell.getGrid().getRow()) == animeGirl.getGrid().rowToY(animeGirl.getGrid().getRow()) && selectCell.getGrid().columnToX(selectCell.getGrid().getCol()) == animeGirl.getGrid().columnToX(animeGirl.getGrid().getCol());

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                selectCell.move(0, 1);
                if (comparePositionsWithAnimeGirl && animeGirl.isHidden()) {
                    animeGirl.move(0, 1);
                }
                break;
            case KeyboardEvent.KEY_UP:
                selectCell.move(0, -1);
                if (comparePositionsWithAnimeGirl && animeGirl.isHidden()) {
                    animeGirl.move(0, -1);
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                selectCell.move(-1, 0);
                if (comparePositionsWithAnimeGirl && animeGirl.isHidden()) {
                    animeGirl.move(-1, 0);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                selectCell.move(1, 0);
                if (comparePositionsWithAnimeGirl && animeGirl.isHidden()) {
                    animeGirl.move(1, 0);
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                if (comparePositionsWithAnimeGirl && !animeGirl.isHidden()) {
                    selectCell.setColor(Color.BLUE);
                    animeGirl.hideImage();
                    break;
                }  else {
                    selectCell.setColor(Color.RED);
                    break;
                }
            case KeyboardEvent.KEY_ENTER:
                if (comparePositionsWithAnimeGirl && animeGirl.isHidden()) {
                    selectCell.setColor(Color.PINK);
                    animeGirl.showImage();
                    break;
                }


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void keyboardMethodsPlayers() {
        Keyboard keyboard = new Keyboard(this);

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
