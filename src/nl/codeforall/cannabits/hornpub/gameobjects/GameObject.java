package nl.codeforall.cannabits.hornpub.gameobjects;

import nl.codeforall.cannabits.hornpub.grid.GridPosition;

public class GameObject {

    protected GridPosition position;

    public GameObject(GridPosition gridPosition) {
        position = gridPosition;
    }
}
