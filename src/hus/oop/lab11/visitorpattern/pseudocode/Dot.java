package hus.oop.lab11.visitorpattern.pseudocode;

public class Dot implements Shape{
    private int id;
    private int x;
    private int y;

    public Dot(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor v) {
        return v.visitDot(this);
    }
}
