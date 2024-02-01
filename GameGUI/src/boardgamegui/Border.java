package boardgamegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

//Class for border
public class Border extends BoardObject {

    //Constructor for border
    public Border() {
        super(ObjectType.BORDER);
    }

    //Draws black rectangles
    @Override
    public void draw(Graphics g, int x, int y, int cellSize) {
        g.setColor(Color.BLACK);
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
