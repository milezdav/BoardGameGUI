// BoardApp.java

//Miles Davis and Ethan Dolbear
//COP3330 Final Project

package boardgamegui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Board App is where main is
public class BoardApp {
    public static void main(String[] args) {
        //Create menu with Jframe and JMenu
        JFrame frame = new JFrame("Board Game Board");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        //The two options, design or load
        JMenuItem designItem = new JMenuItem("Design");
        JMenuItem loadItem = new JMenuItem("Load");

        //If design, then make new boardPanel (this generates our board)
        designItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Board");

                //Make new grid size 32 x 32
                BoardPanel boardPanel = new BoardPanel(32, 32, 20);
                
                //Add the board panel to the frame
                frame.add(boardPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 800);
                frame.setVisible(true);
            }
        });

        //If load, then
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement board loading logic
            }
        });

        //Finish setting up menu and original frame
        fileMenu.add(designItem);
        fileMenu.add(loadItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
