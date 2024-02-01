package boardgamegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

//Class for Coin reward
class Coin extends BoardObject {
    
    //We need a coin image to display
    private Image coinImage;
    
    //Coin constructor that reads the image 
    public Coin() {
        super(ObjectType.REWARD);
        //Loading once
        if (coinImage == null) {
            try {
                coinImage = ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/coin.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void draw(Graphics g, int x, int y, int cellSize) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, cellSize, cellSize);
        //Draw the coin on the cell
        g.drawImage(coinImage, x, y, cellSize, cellSize, null);
    }

    //Loading image for manual serialization
    @Override
    protected Image loadImageFromFile(String path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/coin.jpg"));
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