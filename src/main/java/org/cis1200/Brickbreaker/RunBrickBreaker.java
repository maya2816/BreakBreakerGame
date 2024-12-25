package org.cis1200.Brickbreaker;
import org.cis1200.mushroom.GameCourt;

import java.awt.*;
import javax.swing.*;

public class RunBrickBreaker implements Runnable {
    public void run() {

        // Top-level frame in which game components live.
        final JFrame frame = new JFrame("BRICK-BREAKER");
        frame.setSize(1000, 1000);
        frame.setBackground(Color.BLACK);
        frame.setResizable(false);


//        // Status panel
//        final JPanel statusPanel = new JPanel(new GridLayout(1, 5));
//        frame.add(statusPanel, BorderLayout.SOUTH);
//        final JLabel status = new JLabel("Running...");
//        statusPanel.add(status);

        // Main playing area
        Board board = new Board();
        frame.add(board, BorderLayout.CENTER);



//        // Reset button
//        final JPanel control_panel = new JPanel();
//        frame.add(control_panel, BorderLayout.NORTH);

//        // Listener for reset button.
//        final JButton reset = new JButton("Reset");
//        control_panel.add(reset);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start game
    }

}
