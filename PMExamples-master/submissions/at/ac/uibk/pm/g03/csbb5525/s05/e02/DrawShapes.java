package at.ac.uibk.pm.g03.csbb5525.s05.e02;

import codedraw.CodeDraw;

public class DrawShapes {
    public static void main(String[] args) {
        Line line1 = new Line(new Vector2(100,650), new Vector2(150, 600));
        Line line2 = new Line(new Vector2(200,650), new Vector2(250, 600));
        Line line3 = new Line(new Vector2(100,750), new Vector2(150, 700));
        Line line4 = new Line(new Vector2(200,750), new Vector2(250, 700));
        Line line5 = new Line(new Vector2(500,200), new Vector2(550, 250));
        Line line6 = new Line(new Vector2(500,300), new Vector2(550, 350));
        Line line7 = new Line(new Vector2(700,200), new Vector2(750, 250));
        Line line8 = new Line(new Vector2(700,300), new Vector2(750, 350));

        Rectangle rectangle1 = new Rectangle(new Vector2(100,650), new Vector2(100, 100));
        Rectangle rectangle2 = new Rectangle(new Vector2(150,600), new Vector2(100, 100));
        Rectangle rectangle3 = new Rectangle(new Vector2(500,200), new Vector2(200, 100));
        Rectangle rectangle4 = new Rectangle(new Vector2(550,250), new Vector2(200, 100));

        Shape[] shapes = new Shape[]{
                line1, line2, line3, line4, line5, line6, line7, line8, rectangle1, rectangle2, rectangle3, rectangle4
        };
        ShapeMemory drawnShapes = new ShapeMemory(shapes.length);

        CodeDraw cd = new CodeDraw(800, 800);
        for (Shape shape : shapes) {
            if (!drawnShapes.contains(shape)) {
                shape.draw(cd);
                System.out.println("Drawing: " + shape);
                drawnShapes.addElement(shape);
            }
            //just me testing
            //shape.draw(cd);

        }
        cd.show();
    }
}
