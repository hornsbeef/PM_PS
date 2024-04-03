package at.ac.uibk.pm.g03.csbb5525.s02.e04;

import at.ac.uibk.pm.g03.csbb5525.s02.e01.PrintArray;
import codedraw.CodeDraw;
import codedraw.Image;
import codedraw.Palette;

import java.awt.*;
import at.ac.uibk.pm.g03.csbb5525.s02.e01.PrintArray.*;

public class WhereIsWaldo {

    // converts RGB image into a grayscale array
    //if I understand correctly:
    //creates a grayscale int for every pixel
    public static int[][] convertImage2Array(Image image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] array = new int[height][width];
        Color color;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                color = image.getPixel(col, row);
                array[row][col] = (int) (color.getRed() * 0.3 + color.getGreen() * 0.59 + color.getBlue() * 0.11);
            }
        }
        return array;
    }

    // detect Waldo by template matching
    public static void detectWaldo(CodeDraw myDrawObj, Image image, Image waldo) {
        // TODO: Implement missing functionality


        //Testing
        int[][] test = convertImage2Array(waldo);
//        PrintArray.printArray(test, "|");
        System.out.println(waldo.getHeight());
        System.out.println(test.length);





    }

    public static void main(String[] args) {

        // waldo1
        String linkImage = "https://fileshare.uibk.ac.at/f/281e89b8ab6941a2a6f8/?dl=1"; // image1.png
        String linkWaldo = "https://fileshare.uibk.ac.at/f/9c3f1c26dce649929411/?dl=1"; // waldo1.png

        // waldo2
        //String linkImage = "https://fileshare.uibk.ac.at/f/0f9894d1aa834fb581d8/?dl=1"; // image2.png
        //String linkWaldo = "https://fileshare.uibk.ac.at/f/80e1d0e93538489791c3/?dl=1"; // waldo2.png

        // waldo3
        //String linkImage = "https://fileshare.uibk.ac.at/f/778ed5cbf99a4d5ab450/?dl=1"; // image3.png
        //String linkWaldo = "https://fileshare.uibk.ac.at/f/201a5747f8aa40bb9214/?dl=1"; // waldo3.png

        // Load images
        Image image = Image.fromUrl(linkImage);
        Image waldo = Image.fromUrl(linkWaldo);

        // set window size based on the image size
        int width = image.getWidth();
        int height = image.getHeight();
        CodeDraw cd = new CodeDraw(width, height);

        //draw image
        cd.drawImage(0, 0, image);
        cd.show();

        // detect Waldo and show result
        detectWaldo(cd, image, waldo);

    }
}
