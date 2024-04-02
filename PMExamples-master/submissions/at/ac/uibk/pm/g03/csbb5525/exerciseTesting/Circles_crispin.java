package at.ac.uibk.pm.g03.csbb5525.exerciseTesting;

import codedraw.CodeDraw;
import codedraw.Palette;

public class Circles_crispin {
    private static final int WIDTH = 650;
    private static final int HEIGHT = 600;
    private static final double RADIUS = 150;

    public static void main(String[] args) {
        CodeDraw cd = new CodeDraw(WIDTH, HEIGHT);

        cd.setLineWidth(2);

        // central circle
        cd.setColor(Palette.BLACK);
        cd.drawCircle(WIDTH/2, HEIGHT/2, RADIUS);

        // surrounding circles
        cd.setColor(Palette.RED);


        //Formel verändert, mit RADIUS * .....
        for (int i = 0; i < 6; ++i)
        {
            double x = (WIDTH /2) + RADIUS * Math.cos(Math.toRadians(60) * i);
            //System.out.println(("x" +x));
            double y = (HEIGHT /2) + RADIUS * Math.sin(Math.toRadians(60) * i);
            //System.out.println("y" + y);

            cd.drawCircle(x, y, RADIUS);
        }

        cd.show();
    }

}
