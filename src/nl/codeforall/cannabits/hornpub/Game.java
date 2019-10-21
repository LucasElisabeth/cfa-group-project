package nl.codeforall.cannabits.hornpub;

import nl.codeforall.cannabits.hornpub.factory.FighterFactory;
import nl.codeforall.cannabits.hornpub.gameobjects.fighters.Fighter;
import nl.codeforall.cannabits.hornpub.grid.Grid;
import nl.codeforall.cannabits.hornpub.grid.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;


public class Game implements KeyboardHandler {

    private Grid grid;
    private GridPosition selectCell;

    private Player player1;
    private Player player2;

    private Fighter selectedFighter;
    private int moveCount;
    private boolean spacePressed;
    private RoundPhase roundPhase;

    private int choiceMenu;

    public Game() {

        grid = new Grid(15, 9);
        spacePressed = false;
        FighterFactory fighterFactory = new FighterFactory();
        player1 = new Player(fighterFactory.createFighters(3, grid));
        player2 = new Player(fighterFactory.createFighters(3, grid));
        roundPhase = RoundPhase.MOVE;
        choiceMenu = 0;
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

        while (!player1.hasLost() && !player2.hasLost()) {

            System.out.println("Player 1 turn to move");
            selectedFighter = player1.chooseCharacter();
            roundMove(selectedFighter);
            roundAttack(selectedFighter, player2);

            if (player2.hasLost()) {
                break;
            }

            System.out.println("Player 2 turn to move");
            selectedFighter = player2.chooseCharacter();
            roundMove(selectedFighter);
            roundAttack(selectedFighter, player1);

        }

    }

    private void roundMove(Fighter fighter) {

        selectCell.move((fighter.getPosition().getImage().getX() - selectCell.getImage().getX()) / Grid.CELLSIZE,
                (fighter.getPosition().getImage().getY() - selectCell.getImage().getY()) / Grid.CELLSIZE);
        System.out.println("my hitpoints :" + fighter.getHealthPoints());
        Text text = new Text(fighter.getPosition().getImage().getX(), fighter.getPosition().getImage().getY() - 10, Integer.toString(fighter.getHealthPoints()));
        while (roundPhase == RoundPhase.MOVE) {

            System.out.println("Make a move");
        }
    }

    private void roundAttack(Fighter fighter, Player enemyPlayer) {

        Fighter[] enemiesInRange = enemiesInRange(fighter, enemyPlayer);
        System.out.println("Attack a character.");

        while (roundPhase == RoundPhase.ATTACK) {

            if (enemiesInRange.length == 0) {
                roundPhase = RoundPhase.MOVE;
                return;
            }
            //all enemies in range turn green
            if (!spacePressed) {
                for (Fighter enemy : enemiesInRange) {
                    enemy.getPosition().getImage().setColor(Color.GREEN);
                }
            }

            if (choiceMenu == enemiesInRange.length) {
                choiceMenu = 0;
            }
            if (choiceMenu < 0) {
                choiceMenu = enemiesInRange.length - 1;
            }

            while (enemiesInRange[choiceMenu].isDestroyed()) {
                choiceMenu++;

                if (choiceMenu == enemiesInRange.length) {
                    choiceMenu = 0;
                }

            }
            //selected enemy turns yellow;
            enemiesInRange[choiceMenu].getPosition().getImage().setColor(Color.YELLOW);
        }
        fighter.attack(enemiesInRange[choiceMenu]);

        for (Fighter enemy : enemiesInRange) {
            enemy.getPosition().getImage().setColor(Color.BLACK);
        }

        if (enemiesInRange[choiceMenu].isDestroyed()) {
            enemiesInRange[choiceMenu].getPosition().getImage().delete();
        }

    }


    public void init() {

        keyboardMethodsPlayers();

        selectCell = new GridPosition(0, 0, grid, Color.RED);
    }

    private boolean comparePositionsWithSelectedFighter() {
        return selectCell.getImage().getY() == selectedFighter.getPosition().getImage().getY()
                && selectCell.getImage().getX() == selectedFighter.getPosition().getImage().getX();

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (roundPhase == RoundPhase.MOVE) {
            keyPressedMovePhase(keyboardEvent);
        }
        if (roundPhase == RoundPhase.ATTACK) {
            keyPressedAttackPhase(keyboardEvent);
        }

    }

    private Fighter[] enemiesInRange(Fighter fighter, Player enemyPlayer) {
        LinkedList<Fighter> enemyFightersInRange = new LinkedList<>();
        int initX = fighter.getPosition().getImage().getX();
        int initY = fighter.getPosition().getImage().getY();

        for (Fighter enemyFighter : enemyPlayer.getFighters()) {
            if (enemyFighter.getPosition().getImage().getX() <= initX + fighter.attackRange() * Grid.CELLSIZE &&
                    enemyFighter.getPosition().getImage().getX() >= initX - fighter.attackRange() * Grid.CELLSIZE &&
                    enemyFighter.getPosition().getImage().getY() <= initY + fighter.attackRange() * Grid.CELLSIZE &&
                    enemyFighter.getPosition().getImage().getY() >= initY - fighter.attackRange() * Grid.CELLSIZE) {

                enemyFightersInRange.add(enemyFighter);
            }

        }

        return enemyFightersInRange.toArray(new Fighter[enemyFightersInRange.size()]);
    }

    private void keyPressedMovePhase(KeyboardEvent keyboardEvent) {

        boolean moveRange = (moveCount < selectedFighter.moveRange());
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                if (selectedFighter.getPosition().isSelected() && moveRange) {
                    selectCell.move(0, 1);
                    selectedFighter.getPosition().move(0, 1);
                    moveCount++;
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (selectedFighter.getPosition().isSelected() && moveRange) {
                    selectCell.move(0, -1);
                    selectedFighter.getPosition().move(0, -1);
                    moveCount++;
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (selectedFighter.getPosition().isSelected() && moveRange) {
                    selectCell.move(-1, 0);
                    selectedFighter.getPosition().move(-1, 0);
                    moveCount++;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (selectedFighter.getPosition().isSelected() && moveRange) {
                    selectCell.move(1, 0);
                    selectedFighter.getPosition().move(1, 0);
                    moveCount++;
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                if (comparePositionsWithSelectedFighter() && !selectedFighter.getPosition().isSelected()) {
                    selectCell.setColor(Color.BLUE);
                    selectedFighter.getPosition().hideImage();
                    spacePressed = true;
                    moveCount = 0;
                    break;
                } else {
                    selectCell.setColor(Color.ORANGE);
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

    private void keyPressedAttackPhase(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (spacePressed) {
                    break;
                }
                choiceMenu--;
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (spacePressed) {
                    break;
                }
                choiceMenu++;
                break;
            case KeyboardEvent.KEY_SPACE:
                spacePressed = !spacePressed;
                break;
            case KeyboardEvent.KEY_ENTER:
                if (!spacePressed) {
                    break;
                }
                roundPhase = RoundPhase.MOVE;
                break;
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


    private enum RoundPhase {
        MOVE,
        ATTACK;

        public RoundPhase nextPhase() {
            if (this == MOVE) {
                return ATTACK;
            }
            return MOVE;
        }
    }
}
