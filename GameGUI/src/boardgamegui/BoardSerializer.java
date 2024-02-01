// BoardSerializer.java
package boardgamegui;

import java.io.*;

//Board Serializer class
public class BoardSerializer {

    //Save current board object
    public static void saveBoard(BoardPanel board, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(board);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Load current board object
    public static BoardPanel loadBoard(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (BoardPanel) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
