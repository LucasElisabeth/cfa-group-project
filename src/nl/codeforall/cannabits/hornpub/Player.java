package nl.codeforall.cannabits.hornpub;

import nl.codeforall.cannabits.hornpub.gameobjects.fighters.AnimeGirl;
import nl.codeforall.cannabits.hornpub.gameobjects.fighters.Fighter;

public class Player {
    private int currentFighter;


    private Fighter[] fighters;

    public Player(Fighter[] fighters){
        this.fighters = fighters;
        currentFighter = 0;
    }

    public Fighter chooseCharacter() {

        loopArray();
        Fighter fighter;
        if(!fighters[currentFighter].isDestroyed()){
            fighter = fighters[currentFighter];
            currentFighter++;
            return fighter;

        }
        while (fighters[currentFighter].isDestroyed()){
            currentFighter++;
            loopArray();
        }

        return fighters[currentFighter];
    }

    public boolean hasLost(){
        for (Fighter fighter : fighters){
            if (!fighter.isDestroyed()){
                return false;
            }
        }
        return true;
    }
    private void loopArray(){
        if (currentFighter >= fighters.length) {
            currentFighter = 0;
        }
    }




}
