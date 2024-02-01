package boardgamegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

//Class for Shark reward
class Shark extends BoardObject {

    //Shark shark to display
    private Image sharkImage;
    
    //Shark constructor that reads the image 
    public Shark() {
        super(ObjectType.OBSTACLE);

        //Load once
        if (sharkImage == null) {
            try {
                sharkImage = ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/shark.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int cellSize) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, cellSize, cellSize);
        // Draw the shark sign image
        g.drawImage(sharkImage, x, y, cellSize, cellSize, null);
    }

    //Loading image for manual serialization
    @Override
    protected Image loadImageFromFile(String path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/shark.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void setImage(Image image) {

    }

    @Override
    protected String getImagePath() {
        return null;
    }
}