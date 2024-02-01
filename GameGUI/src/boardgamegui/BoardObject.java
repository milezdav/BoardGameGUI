package boardgamegui;

import java.awt.*;
import java.io.Serializable;

//Abstract Class (2 of 2) 
//Abstract class for board objects
public abstract class BoardObject implements Drawable {
    
    private ObjectType type;
    
    //Objects are either obstacles, rewards, entrance, walls, exit, borders, or empty cells
    public enum ObjectType {
        OBSTACLE, REWARD, ENTRANCE, EXIT, WALL, BORDER, EMPTY
    }
    
    //Constructor for object
    public BoardObject(ObjectType type) {
        this.type = type;
    }

    //Get for access to object type
    public ObjectType getType() {
        return type;
    }

    //Implements Drawable
    public abstract void draw(Graphics g, int x, int y, int cellSize);

    // Abstract method for loading image from a file
    protected abstract Image loadImageFromFile(String path);

    // Serialization logic
    protected abstract void setImage(Image image);

    // Abstract method to get the image path
    protected abstract String getImagePath();
}
