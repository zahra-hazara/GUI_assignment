package Assignment6_2.controller;

import  Assignment6_2.model.*;

public class PetController {
    // Updates the pet's position based on movement logic
    private final Pet pet;
    private final int speed;
    private int targetX, targetY;
    private boolean active;

    public PetController(Pet pet, int speed) {
        this.pet = pet;
        this.speed = speed;
        this.targetX = pet.x;
        this.targetY = pet.y;
        this.active = false;
    }

    public void moveTowardsTarget() {
        if (!active) return;

        int dx = targetX - pet.x;
        int dy = targetY - pet.y;
        double distance = Math.hypot(dx, dy);

        if (distance < speed || distance == 0) {
            pet.x = targetX;
            pet.y = targetY;
        } else {
            double angle = Math.atan2(dy, dx);
            pet.x += (int)(speed * Math.cos(angle));
            pet.y += (int)(speed * Math.sin(angle));
        }
    }

    public void updateTarget(int x, int y) {
        this.targetX = x;
        this.targetY = y;
        this.active = true;
    }

    public void stop() {
        this.active = false;
    }

    public Pet getPet() {
        return pet;
    }
}
