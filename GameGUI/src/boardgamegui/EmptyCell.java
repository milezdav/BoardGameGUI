// EmptyCell.java
package boardgamegui;
import java.awt.*;

//EmptyCell class
public class EmptyCell extends BoardObject {

    //Constructor, of type EMPTY
    public EmptyCell() {
        super(ObjectType.EMPTY);
    }

    @Override
    public void draw(Graphics g, int x, int y, int cellSize) {
        
        //Sets the cell to empty white color 
        g.setColor(Color.WHITE);
        g.fillRect(x, y, cellSize, cellSize);
    }
    @Override
    protected Image loadImageFromFile(String path) {
        return null;
    }

    @Override
    protected void setImage(Image image) {

    }

    @Override
    protected String getImagePath() {
        return null;
    }
}
