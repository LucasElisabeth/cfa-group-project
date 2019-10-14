package nl.codeforall.cannabits.hornpub;

import nl.codeforall.cannabits.hornpub.gameobjects.fighters.AnimeGirl;
import nl.codeforall.cannabits.hornpub.gameobjects.fighters.Fighter;

public class Player {

    private Fighter[] fighters;

    public Fighter chooseCharacter() {
        return new AnimeGirl();
    }
}
