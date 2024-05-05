package at.ac.uibk.pm.g03.csbb5525.s05.e04;

import codedraw.CodeDraw;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CodeDraw cd = new CodeDraw(1920, 1080);

        Drawings drawings = new Drawings();
        Drawings wrongDrawings = new Drawings();

        try{
            drawings.parser("(400,400,175);(576,576,175);(576,225,175);(225,576,175);\n" +
                                    "(225,225,175);(400,400,73);(576,225,175);(400,576,124);\n" +
                                    "(400,225,124);(225,400,124);(400,400,175);(576,400,124)");

            wrongDrawings.parser("(400,400;175, 4);(576,576,175);(576,225,175)");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }





        List<Circle> drawnCircles = new ArrayList<>();


        for(Circle c : drawings.getCircles()){
            if(!drawnCircles.contains(c)){
                c.draw(cd);
                drawnCircles.add(c);
            }
        }

        cd.show();

    }
}
