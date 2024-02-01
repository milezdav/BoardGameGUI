package boardgamegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

//Entrance class
class Entrance extends BoardObject {

    //Constructor, of type ENTRANCE
    public Entrance() {
        super(ObjectType.ENTRANCE);
    }

    @Override
    public void draw(Graphics g, int x, int y, int cellSize) {
        //Draws a light blue rectangle
        g.setColor(new Color(0, 255, 247));
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