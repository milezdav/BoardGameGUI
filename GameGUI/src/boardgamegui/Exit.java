package boardgamegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

//Class for exit cell
class Exit extends BoardObject {

    //Constructor for exit, of type EXIT
    public Exit() {
        super(ObjectType.EXIT);
    }

    @Override
    public void draw(Graphics g, int x, int y, int cellSize) {
        //Draws a magenta cell
        g.setColor(Color.MAGENTA);
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