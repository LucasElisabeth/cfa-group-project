package nl.codeforall.cannabits.hornpub.factory;

import nl.codeforall.cannabits.hornpub.gameobjects.fighters.AnimeGirl;
import nl.codeforall.cannabits.hornpub.gameobjects.fighters.Fighter;
import nl.codeforall.cannabits.hornpub.grid.Grid;
import nl.codeforall.cannabits.hornpub.grid.GridPosition;

public class FighterFactory {

    public static Fighter getFighter(Grid grid){
        return new AnimeGirl(new GridPosition(grid));
    }

}
