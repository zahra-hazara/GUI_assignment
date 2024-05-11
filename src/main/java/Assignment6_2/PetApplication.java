package Assignment6_2;

import Assignment6_2.model.Pet;
import Assignment6_2.controller.PetController;
import Assignment6_2.view.PetView;

import javax.swing.*;
import java.io.IOException;

public class VirtualPetApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Virtual Pet");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Pet pet = new Pet(300, 200);
            PetController controller = new PetController(pet, 5);

            try {
                PetView view = new PetView(controller, "path/to/cute_pet_image.png");
                frame.add(view);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (IOException e) {
                System.err.println("Error loading the pet image.");
            }
        });
    }
}
