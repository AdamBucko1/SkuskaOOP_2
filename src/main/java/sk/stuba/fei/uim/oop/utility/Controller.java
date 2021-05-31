package sk.stuba.fei.uim.oop.utility;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Controller {
    public MyCanvas myCanvas=new MyCanvas(this);
    public ArrayList<Shapes> allShapes=new ArrayList<>();
    private int shapeSelected=0;
    private int colorSelected=0;
    MouseMovement mouseMovement;
    private Shapes lastShapeCreated;
    public Controller() {
        this.mouseMovement=new MouseMovement(this);
        myCanvas.addMouseListener(mouseMovement);
        myCanvas.addMouseMotionListener(mouseMovement);
    }
    public Shapes createNewShape(int x,int y, int endX, int endY){
        if (shapeSelected==1){
            lastShapeCreated=new Circle(x,y,endX,endY);
            return lastShapeCreated;
        }
        else {
            lastShapeCreated=new Line(x,y,endX,endY);
            return lastShapeCreated;
        }

    }
    public void recountMyCoordinates(Shapes circle,int startX, int startY){
         //KLIK SURADNICE
        // int startX=startX;
        // int startY=startY;
         //DRAG SURADNICE
         int endX=circle.endX;
         int endY=circle.endY;

         int width;
         int length;

         width=abs(startX-endX);
         length=abs(startY-endY);
         if (width>length){
             width=length;
         }
        else {
            length=width;
         }
        if (startX>endX){
            circle.x=startX-width;
        }
        if (startY>endY){
            circle.y=startY-length;
        }

        circle.endX=width;
        circle.endY=length;




    }

    public int getShapeSelected() {
        return shapeSelected;
    }

    public void setShapeSelected(int shapeSelected) {
        this.shapeSelected = shapeSelected;
    }

    public int getColorSelected() {
        return colorSelected;
    }

    public void setColorSelected(int colorSelected) {
        this.colorSelected = colorSelected;
    }
}
