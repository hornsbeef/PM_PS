package at.ac.uibk.pm.g03.csbb5525.s02.e04;

import codedraw.CodeDraw;
import codedraw.Image;
import codedraw.*;

import java.awt.*;

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
        //codedraw settings:
        myDrawObj.setColor(Palette.DEEP_PINK);
        myDrawObj.setLineWidth(6);

        //getting waldoArray specs
        int[][] waldoArray = convertImage2Array(waldo);
        //getting imageArray specs
        int[][] imageArray = convertImage2Array(image);

        //calculating parameters for loop conditions so that waldo is still in the image
        int maxRow = (image.getHeight() - waldo.getHeight());    //for "bottom"
        int maxCol = image.getWidth() - waldo.getWidth();        //for "right" side

        //actual finding & drawing:
        traverseImage(myDrawObj, image, waldo, maxRow, maxCol, imageArray, waldoArray);

    }

    private static void traverseImage(CodeDraw myDrawObj, Image image, Image waldo, int maxRow, int maxCol, int[][] imageArray, int[][] waldoArray) {
        //looking for the smallest sadValue when comparing waldo to image-parts.

        var minimum =  Integer.MAX_VALUE;       //start with the largest possible value


        //going through all image Rows (so that waldo still fits in (array wise))
        for(int currentRow = 0; currentRow < maxRow; currentRow++ ){
            //going through all image Cols (so that waldo still fits in (array wise))
            for(int currentCol = 0; currentCol < maxCol; currentCol++){
                //calculate SAD for one position defined by leftUpperCorner
                int sadValue = sadCalculator(waldo, currentRow, currentCol, imageArray, waldoArray);

                minimum = Math.min(minimum, sadValue);

                if(minimum == sadValue){    //this is true when in this iteration of the loop minimum was set to sadValue
                                            //-> here we want to get the next rectangle drawn.
                    drawCurrentRectangle(myDrawObj, image, waldo, currentCol, currentRow);
                }
            }
        }
    }

    //
    private static void drawCurrentRectangle(CodeDraw myDrawObj, Image image, Image waldo, int currentCol, int currentRow) {
        myDrawObj.drawImage(0, 0, image);
        myDrawObj.drawRectangle(currentCol, currentRow, waldo.getWidth(), waldo.getHeight() );
        myDrawObj.show(300);
        myDrawObj.clear();
    }


    private static int sadCalculator(Image waldo, int rowPos, int colPos, int[][] imageArray, int[][] waldoArray) {
        int waldoRow = 0;   //for waldo image always start at 0
        int waldoCol = 0;   //for waldo image always start at 0

        int sadValue = 0;   //starting with sad_value 0 -> changed in the loops

        int maxRow = rowPos + waldo.getHeight();
        int maxCol = colPos + waldo.getWidth();



        //going through as many rows as the waldo image has:
        for (int currentRow = rowPos; currentRow < maxRow ; currentRow++, waldoRow++ ){

            //going through as many cols as the waldo image has:
            for (int currentCol = colPos; currentCol < maxCol ; currentCol++, waldoCol++){

                //implement the sad calculation:
                // |Image - waldo| + ... = sadValue
                int temp = Math.abs(imageArray[currentRow][currentCol] - waldoArray[waldoRow][waldoCol]);
                sadValue += temp;
            }
            waldoCol = 0;   //MUST NOT FORGET!!!
        }
        //return the sad_value
        return sadValue;
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

//leftover code from idea to traverse whole image before drawing rectangle with saving
//the coordinates and the sadValue to a class (as a replacement for C structs)
//still here for future coding experiment
//class SadInfo {
//    public SadInfo(int currentRow, int currentCol, int sadValue){
//        this.SADvalue = sadValue;
//        row = currentRow;
//        col = currentCol;
//    }
//    private static int sadMinRow;
//    private static int sadMinCol;
//    private static int sadMinValue;
//
//    public int getSADvalue() {
//        return SADvalue;
//    }
//
//    private int SADvalue;
//    //positioning information:
//    private int row;
//    private int col;
//
//    public static void setSadMinRow(int sadMinRow) {
//        SadInfo.sadMinRow = sadMinRow;
//    }
//
//    public static void setSadMinCol(int sadMinCol) {
//        SadInfo.sadMinCol = sadMinCol;
//    }
//    public static int getSadMinValue() {
//        return sadMinValue;
//    }
//
//    public static void setSadMinValue(int sadMinValue) {
//        SadInfo.sadMinValue = sadMinValue;
//    }
//
//
//}
//