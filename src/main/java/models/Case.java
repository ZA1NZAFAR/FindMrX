package models;

/**
 *
 * @author z.zafar
 */
public class Case {

    private char val;
    private int x;
    private int y;

    public Case(char val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y += 1;
    }

    public void moveDown() {
        y -= 1;
    }

    public void moveLeft() {
        x -= 1;
    }

    public void moveRight() {
        x += 1;
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
