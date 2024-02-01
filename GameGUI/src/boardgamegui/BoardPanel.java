package boardgamegui;

import javax.imageio.ImageIO;
import javax.swing.*;
import boardgamegui.BoardObject.ObjectType;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

//BoardPanel class
public class BoardPanel extends JPanel implements Serializable {
    private BoardObject[][] cells;
    private int cellSize;
   
    //Constuctor for board panel which inits the board
    public BoardPanel(int rows, int cols, int cellSize) {

        //Create our new BoardObject grid
        this.cellSize = cellSize;
        this.cells = new BoardObject[rows][cols];
        
        //This method inits the board, it's going to be different each time it's called
        initializeBoard();

        //This method saves the board to memory (maybe makes it a .ser file?)
        JButton saveButton = makeButton("Save Board", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement save functionality
            }
        });

        //This button just calls the initBoard method
        JButton generateButton = makeButton("Generate New Board", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeBoard();
                repaint(); 
            }
        });

        //Make the button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(generateButton);
        buttonPanel.add(saveButton);
        setLayout(new BorderLayout());

        //Make the label panel
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.add(makeLabel("Border", createBorderImage()));
        labelPanel.add(makeLabel("Entrance", createEntranceImage()));
        labelPanel.add(makeLabel("Exit", createExitImage()));
        labelPanel.add(makeLabel("Wall (Obstacle)", createWallImage()));
        labelPanel.add(makeLabel("Shark (Obstacle)", createSharkImage()));
        labelPanel.add(makeLabel("Stop Sign (Obstacle)", createStopSignImage()));
        labelPanel.add(makeLabel("Coin (Reward)", createCoinImage()));
        labelPanel.add(makeLabel("Money (Reward)", createMoneyImage()));
        labelPanel.add(makeLabel("Orange (Reward)", createOrangeImage()));
        
        //Add the panels to frame
        add(buttonPanel, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.EAST);
    }

    //Helper method for making button
    private JButton makeButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        return button;
    }
    //Helper method for making labels
    private JLabel makeLabel(String text, Image image) {
        JLabel label = new JLabel(text, new ImageIcon(image), SwingConstants.CENTER);
        return label;
    }

    //Method to init the board
    private void initializeBoard() {
        //First action is generate new Border objects on the edges of the grid, everything else we will init as EmptyCells
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (i == 0 || i == cells.length - 1 || j == 0 || j == cells[i].length - 1) {
                    cells[i][j] = new Border();
                } else {
                    cells[i][j] = new EmptyCell(); 
                }
            }
        }
    
        //Generate the entrace, exit, walls, obstacles, and rewards
        generateEntranceExit();
        generateObstaclesAndRewards();    
        generateWalls();
    }

    //Method to generate the walls
    private void generateWalls() {
        for (int i = 0; i < 256; i++) {
            //Find random row and col
            int randomRow = (int) (Math.random() * (cells.length - 2) + 1); 
            int randomCol = (int) (Math.random() * (cells[0].length - 2) + 1); 

            //As long as the cells at these random rows and cols aren't Border objects and are empty
            if (cells[randomRow][randomCol].getType() == ObjectType.EMPTY) {
                cells[randomRow][randomCol] = new Wall();    
            }
        }
    }

    //Randomly generate obstacles and rewards
    private void generateObstaclesAndRewards() {
        // Place a minimum of 16 obstacles and 16 rewards
        generateObjectsRandomly(16, new StopSign());
        generateObjectsRandomly(16, new Shark());
        generateObjectsRandomly(16, new Coin());
        generateObjectsRandomly(16, new Money());
        generateObjectsRandomly(16, new Orange());
        
    }
    
    //Helper method for generating objects
    private void generateObjectsRandomly(int count, BoardObject object) {
            for (int i = 0; i < count; i++) {
                int randomRow = (int) (Math.random() * (cells.length - 2) + 1); 
                int randomCol = (int) (Math.random() * (cells[0].length - 2) + 1); 
                 if (!(cells[randomRow][randomCol] instanceof Border) && cells[randomRow][randomCol].getType() == ObjectType.EMPTY) {
                    cells[randomRow][randomCol] = object;
                }
            }
        }
    
    //Generate entrance and exit
    private void generateEntranceExit() {

      //Exit will be by default on bottom row
      int exitCol = (int) (Math.random() * (cells[0].length - 2)) + 1;
      cells[cells.length - 1][exitCol] = new Exit();
  
      //Entrance will be by default on top row
      int entranceRow = (int) (Math.random() * (cells[0].length - 2)) + 1;
      cells[0][entranceRow] = new Entrance();
    }

    //Helper methods for creating images
    private Image createBorderImage() {
        BufferedImage img = new BufferedImage(cellSize, cellSize, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, cellSize, cellSize);
        g.dispose();
        return img;
    }
    private Image createWallImage() {
        BufferedImage img = new BufferedImage(cellSize, cellSize, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, cellSize, cellSize);
        g.dispose();
        return img;
    }
    private Image createStopSignImage() {
        try {
            Image stopSignImage = ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/stop_sign.png"));
            BufferedImage img = new BufferedImage(cellSize, cellSize, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.drawImage(stopSignImage, 0, 0, cellSize, cellSize, null);
            g.dispose();
            return img;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    } 
    private Image createSharkImage() {
        try {
            Image sharkImage = ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/shark.jpg"));
            BufferedImage img = new BufferedImage(cellSize, cellSize, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.drawImage(sharkImage, 0, 0, cellSize, cellSize, null);
            g.dispose();
            return img;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    } 
    private Image createCoinImage() {
        try {
            Image coinImage = ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/coin.jpg"));
            BufferedImage img = new BufferedImage(cellSize, cellSize, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.drawImage(coinImage, 0, 0, cellSize, cellSize, null);
            g.dispose();
            return img;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
     private Image createMoneyImage() {
        try {
            Image moneyImage = ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/money.jpg"));
            BufferedImage img = new BufferedImage(cellSize, cellSize, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.drawImage(moneyImage, 0, 0, cellSize, cellSize, null);
            g.dispose();
            return img;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
     private Image createOrangeImage() {
        try {
            Image orangeImage = ImageIO.read(getClass().getResourceAsStream("/boardgamegui/images/orange.jpg"));
            BufferedImage img = new BufferedImage(cellSize, cellSize, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.drawImage(orangeImage, 0, 0, cellSize, cellSize, null);
            g.dispose();
            return img;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Image createExitImage() {
        BufferedImage img = new BufferedImage(cellSize, cellSize, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, cellSize, cellSize);
        g.dispose();
        return img;
    }
    private Image createEntranceImage() {
        BufferedImage img = new BufferedImage(cellSize, cellSize, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setColor(new Color(0, 255, 247));
        g.fillRect(0, 0, cellSize, cellSize);
        g.dispose();
        return img;
    }
    
    

    //This basically draws paints whats in the cells
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Iterate through cells and draw each board object
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                //Find cell position for draw
                int x = j * cellSize;
                int y = i * cellSize;

                cells[i][j].draw(g, x, y, cellSize);
            }
        }
    }
}
