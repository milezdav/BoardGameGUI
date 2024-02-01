package boardgamegui;

import java.io.Serializable;

// Board class to hold board information
public class Board implements Serializable {
    private BoardObject[][] cells;

    public Board(int rows, int cols) {
        this.cells = new BoardObject[rows][cols];
    
    }

    public BoardObject[][] getCells() {
        return cells;
    }
}