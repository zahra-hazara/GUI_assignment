package Assignment6_2.utils;

public enum Direction {
    UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT;

    public static Direction getDirection(int dx, int dy) {
        if (dx > 0 && dy < 0) return UP_RIGHT;
        if (dx > 0 && dy > 0) return DOWN_RIGHT;
        if (dx < 0 && dy < 0) return UP_LEFT;
        if (dx < 0 && dy > 0) return DOWN_LEFT;
        if (dx > 0) return RIGHT;
        if (dx < 0) return LEFT;
        if (dy < 0) return UP;
        return DOWN;
    }
}