package Assignment6_2.view;

import Assignment6_2.controller.PetController;
import javafx.application.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GraphicsDemo extends Application {
    // Contains the canvas and draws the pet
    private final PetController controller;
    private final BufferedImage petImage;
    private final Timer timer;

    public GraphicsDemo(PetController controller, String petImagePath) throws IOException {
        this.controller = controller;
        this.petImage = ImageIO.read(new File(petImagePath));

        this.setPreferredSize(new Dimension(600, 400));
        this.setBackground(Color.WHITE);

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                controller.updateTarget(e.getX(), e.getY());
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                controller.stop();
            }
        });

        // Timer to periodically update the pet's position
        this.timer = new Timer(50, e -> {
            controller.moveTowardsTarget();
            repaint();
        });
        this.timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(petImage, controller.getPet().x, controller.getPet().y, null);
    }
}
