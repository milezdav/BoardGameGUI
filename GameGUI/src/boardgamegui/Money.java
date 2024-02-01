package boardgamegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

//Class for Money reward
class Money extends BoardObject {

    //Money image to display
    private Image moneyImage;
    
    //Coin constructor that reads the image 
    public Money() {
        super(ObjectType.REWARD);
        if (moneyImage == null) {
            try {
                moneyImage = ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/money.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
           
    }
    @Override
    public void draw(Graphics g, int x, int y, int cellSize) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, cellSize, cellSize);
        // Draw the money image
        g.drawImage(moneyImage, x, y, cellSize, cellSize, null);
    }

    //Loading image for manual serialization
    @Override
    protected Image loadImageFromFile(String path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/money.jpg"));
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