package boardgamegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

//Class for Orange reward
class Orange extends BoardObject {

    //Orange image to display
    private Image orangeImage;
    
    //Orange constructor that reads the image 
    public Orange() {
        super(ObjectType.REWARD);

        //Load once
        if (orangeImage == null) {
            try {
                orangeImage = ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/orange.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int cellSize) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, cellSize, cellSize);
        // Draw the orange sign image
        g.drawImage(orangeImage, x, y, cellSize, cellSize, null);
    }
    //Loading image for manual serialization
    @Override
    protected Image loadImageFromFile(String path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/orange.jpg"));
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