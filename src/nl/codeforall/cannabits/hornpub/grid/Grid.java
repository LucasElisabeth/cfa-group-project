package nl.codeforall.cannabits.hornpub.grid;

public class Grid {
    public static final int CELLSIZE = 20;
    private int col;
    private int row;

    public Grid(int col, int row) {
         this.col = col;
         this.row = row;
    }

    public void init() {

    }

    private int columnToX(int col) {
         return 0;
    }

    private int rowToY(int row) {
        return 0;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
