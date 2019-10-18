package nl.codeforall.cannabits.hornpub.gameobjects.fighters;

import nl.codeforall.cannabits.hornpub.grid.GridPosition;

public class AnimeGirl extends Fighter {

    public AnimeGirl(GridPosition gridPosition) {
        super(FighterType.ANIMEGIRL, gridPosition);
        name = getClass().getSimpleName();
    }
}
