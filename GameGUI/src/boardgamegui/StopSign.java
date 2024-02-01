package boardgamegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

//Stop Sign class
class StopSign extends BoardObject {

    //Stop sign image variable
    private Image stopSignImage;

    //Stop sign constructor
    public StopSign() {
        super(ObjectType.OBSTACLE);

        //Loading once
        if (stopSignImage == null) {
            try {
            // Load the stop sign image from the package
            stopSignImage = ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/stop_sign.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    @Override
    public void draw(Graphics g, int x, int y, int cellSize) {
        g.setColor(Color.WHITE); 
        g.fillRect(x, y, cellSize, cellSize); 

        // Draw the stop sign image
        g.drawImage(stopSignImage, x, y, cellSize, cellSize, null);
    }
    
    //Loading image for manual serialization
    @Override
    protected Image loadImageFromFile(String path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/stop_sign.jpg"));
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
