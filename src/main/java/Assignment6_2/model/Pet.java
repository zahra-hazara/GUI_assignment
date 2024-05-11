package Assignment6_2.model;

/**
 * Enum to represent the possible movement directions of the pet.
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT;

    /**
     * Determines the direction based on delta x and delta y values.
     * @param dx delta x (change in x)
     * @param dy delta y (change in y)
     * @return Direction based on dx and dy.
     */
    public static Direction getDirection(int dx, int dy) {
        if (dx == 0 && dy == 0) {
            return null;  // No movement
        }
        if (dx > 0) {
            if (dy < 0) return UP_RIGHT;
            if (dy > 0) return DOWN_RIGHT;
            return RIGHT;
        } else if (dx < 0) {
            if (dy < 0) return UP_LEFT;
            if (dy > 0) return DOWN_LEFT;
            return LEFT;
        } else {  // dx == 0
            if (dy < 0) return UP;
            return DOWN;
        }
    }
}
