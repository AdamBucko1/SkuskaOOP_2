package sk.stuba.fei.uim.oop.utility;

public class Line extends Shapes{
    public Line(int x, int y, int endX, int endY,int color) {
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
        this.shapeType=2;
        this.colourOfObject=color;
    }
}
