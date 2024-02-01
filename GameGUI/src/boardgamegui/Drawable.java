// Drawable.java
package boardgamegui;

import java.awt.Graphics;

//Abstract Class (1 of 2) 
//Any class that implements this interface will have draw method
public interface Drawable {
    void draw(Graphics g, int x, int y, int cellSize);
}
