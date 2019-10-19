package nl.codeforall.cannabits.hornpub;

import nl.codeforall.cannabits.hornpub.factory.FighterFactory;
import nl.codeforall.cannabits.hornpub.gameobjects.fighters.Fighter;
import nl.codeforall.cannabits.hornpub.grid.Grid;
import nl.codeforall.cannabits.hornpub.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Game implements KeyboardHandler {

    private Grid grid;
    private GridPosition selectCell;

    private Player player1;
    private Player player2;

    private Fighter selectedFighter;
    private boolean spacePressed;
    private RoundPhase roundPhase;


    public Game() {

        grid = new Grid(15, 9);
        spacePressed = false;
        player1 = new Player(new Fighter[]{FighterFactory.getFighter(grid)});
        player2 = new Player(new Fighter[]{FighterFactory.getFighter(grid)});
        roundPhase = RoundPhase.MOVE;
    }

    public void start() {
        /**
         * player 1 starts,
         * round move
         * round attack
         * check if p2 lost
         * round move
         * round attack
         * check if player 1 lost
         */

        while (!player1.hasLost() && !player2.hasLost()){

            selectedFighter = player1.chooseCharacter();
            roundMove(selectedFighter);
            roundAttack(selectedFighter);

            if (player2.hasLost()){ break; }

            selectedFighter = player2.chooseCharacter();
            roundMove(selectedFighter);
            roundAttack(selectedFighter);

        }

        }

        private void roundMove(Fighter fighter){
         while (roundPhase == RoundPhase.MOVE){
             System.out.println("gotta moveit moveit");
         }
        }

        private void roundAttack(Fighter fighter){
            while (roundPhase == RoundPhase.ATTACK){
                System.out.println("gotta fighht for your right to partyy");
            }
        }


    public void init(){

        keyboardMethodsPlayers();

        selectCell = new GridPosition(0, 0, grid, Color.RED);
    }

    private boolean comparePositionsWithSelectedFighter() {
        return selectCell.getImage().getY() == selectedFighter.getPosition().getImage().getY()
                && selectCell.getImage().getX() == selectedFighter.getPosition().getImage().getX() ;

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                selectCell.move(0, 1);
                if (selectedFighter.getPosition().isSelected()) {
                    selectedFighter.getPosition().move(0, 1);
                }
                break;
            case KeyboardEvent.KEY_UP:
                selectCell.move(0, -1);
                if (selectedFighter.getPosition().isSelected()) {
                    selectedFighter.getPosition().move(0, -1);
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                selectCell.move(-1, 0);
                if (selectedFighter.getPosition().isSelected()) {
                    selectedFighter.getPosition().move(-1, 0);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                selectCell.move(1, 0);
                if (selectedFighter.getPosition().isSelected()) {
                    selectedFighter.getPosition().move(1, 0);
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                if (comparePositionsWithSelectedFighter() && !selectedFighter.getPosition().isSelected()) {
                    selectCell.setColor(Color.BLUE);
                    selectedFighter.getPosition().hideImage();
                    spacePressed = true;
                    break;
                } else {
                    selectCell.setColor(Color.PINK);
                    break;
                }
            case KeyboardEvent.KEY_ENTER:
                if (selectedFighter.getPosition().isSelected() && spacePressed) {
                    selectCell.setColor(Color.RED);
                    selectedFighter.getPosition().showImage();
                    roundPhase = roundPhase.nextPhase();
                    spacePressed = false;
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


    private enum RoundPhase{
        MOVE,
        ATTACK;

        public RoundPhase nextPhase(){
            if (this == MOVE){
                return ATTACK;
            }
            return MOVE;
        }
    }
}
