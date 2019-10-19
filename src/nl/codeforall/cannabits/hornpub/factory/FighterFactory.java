package nl.codeforall.cannabits.hornpub.factory;

import nl.codeforall.cannabits.hornpub.gameobjects.fighters.AnimeGirl;
import nl.codeforall.cannabits.hornpub.gameobjects.fighters.Fighter;
import nl.codeforall.cannabits.hornpub.grid.Grid;
import nl.codeforall.cannabits.hornpub.grid.GridPosition;

public class FighterFactory {

    private Fighter createFighter(Grid grid){
        return new AnimeGirl(new GridPosition(grid));
    }

    public Fighter[] createFighters(int number, Grid grid){
        Fighter[] fighters = new Fighter[number];

        for (int i = 0 ; i < number ; i++){
            fighters[i] = createFighter(grid);
        }

        return fighters;
    }

}
