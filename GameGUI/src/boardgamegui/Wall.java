package boardgamegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

//Class for wall
class Wall extends BoardObject {
    //We are either going to draw a top, bottom, left, or right line on the chosen cell
    private boolean topLine;
    private boolean bottomLine;
    private boolean leftLine;
    private boolean rightLine;

    //Constructor for Wall, of type WALL
    public Wall() {
        super(ObjectType.WALL);

        //Choose a random line, at least one will be chosen
        topLine = Math.random() < 0.5;
        bottomLine = Math.random() < 0.5;
        leftLine = Math.random() < 0.5;
        rightLine = Math.random() < 0.5;
    }

    @Override
    public void draw(Graphics g, int x, int y, int cellSize) {

        //This is important, make sure to initially set everything to white for walls to init properly
        g.setColor(Color.WHITE); 
        g.fillRect(x, y, cellSize, cellSize);

        //Walls are color blue
        g.setColor(Color.BLUE);

        //Depending on what direction the line is, draw the line with the appropriate arguments
        if (topLine) {
            g.drawLine(x, y, x + cellSize, y);
        }
        if (bottomLine) {
            g.drawLine(x, y + cellSize, x + cellSize, y + cellSize);
        }
        if (leftLine) {
            g.drawLine(x, y, x, y + cellSize);
        }
        if (rightLine) {
            g.drawLine(x + cellSize, y, x + cellSize, y + cellSize);
        }
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
