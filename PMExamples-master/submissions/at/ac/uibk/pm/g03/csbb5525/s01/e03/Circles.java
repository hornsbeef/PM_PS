package at.ac.uibk.pm.g03.csbb5525.s01.e03;

import codedraw.CodeDraw;
import codedraw.Palette;

public class Circles {
    private static final int WIDTH = 650;
    private static final int HEIGHT = 600;
    private static final double RADIUS = 150;
    private static final double xCenter = (double) WIDTH /2;
    private static final double yCenter = (double) HEIGHT /2;

    public static void main(String[] args) {
        CodeDraw cd = new CodeDraw(WIDTH, HEIGHT);
        cd.setColor(Palette.BLACK);
        cd.setLineWidth(2);

        cd.drawCircle((double) WIDTH /2, (double) HEIGHT /2, RADIUS);
        cd.setColor(Palette.RED);

        double angle = 0;

        while(angle < 360) {
            double radAngle = Math.toRadians(angle);
            double xAxis = Math.cos(radAngle);
            double yAxis = Math.sin(radAngle);

            double xCoordinate = xCenter + (RADIUS * xAxis);
            double yCoordinate = yCenter + (RADIUS * yAxis);

            cd.drawCircle(xCoordinate, yCoordinate, RADIUS);
            angle += 60;
        }

        cd.show();
        //cd.clear(); for next assignment!
    }

}
