package at.ac.uibk.pm.g03.csbb5525.s02.e04;

import codedraw.CodeDraw;
import codedraw.Image;

import java.awt.*;

import static java.lang.Math.*;

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

        //getting waldoArray specs
        int[][] waldoArray = convertImage2Array(waldo);
        //getting imageArray specs
        int[][] imageArray = convertImage2Array(image);




        //calculate (more than) max amount of image comparisons = SAD-Array size
        //TODO: -> Improve
        //int imagePixels = image.getHeight() * image.getWidth();

        //todo:create object array for SAD_info
        SAD_Info[][] sadInfos;
        sadInfos = new SAD_Info[image.getHeight()][image.getWidth()];



        int maxRow = (image.getHeight() - waldo.getHeight());
        int maxCol = image.getWidth() - waldo.getWidth();

        //going through all image Rows so that waldo still fits in (array wise)
        for(int currentRow = 0; currentRow < maxRow; currentRow++ ){
            //going through all image Cols so that waldo still fits in (array wise)
            for(int currentCol = 0; currentCol < maxCol; currentCol++){
                //calculate SAD for one position defined by leftUpperCorner
                int sadValue = sadCalculator(image, waldo, currentRow, currentCol,imageArray ,waldoArray );
                //testing: -> SAD value allways very large!
                //System.out.println("sad:"+sadValue);

                //todo: CREATE the Sad object for this position!
                // set the correct sad Object variables!
                sadInfos[currentRow][currentCol] = new SAD_Info(currentRow, currentCol, sadValue);

                //todo: testing:
                System.out.println(sadInfos[currentRow][currentCol].getSADvalue());



            }

        }









        //todo: idea for getting minimum: SAD array
    //    public int min(int[] array) {
    //        int min = array[0];
    //        for (int i = 1; i < array.length; i++) {
    //            if (array[i] < min) {
    //                min = array[i];
    //            }
    //        }
    //        return min;
    //    }
    ///////////////////////////////

    //int minAge = Arrays.stream(people)
    //                  .mapToInt(Person::getAge)
    //                  .min()
    //                  .getAsInt();
    //    https://www.perplexity.ai/search/Java-in-a-ZnGA_HWSTW6SXoVL95kbGg#21


//Testing
//Dirty testing:
//        System.out.println(waldo.getHeight());
//        System.out.println(waldoArray.length);
//        System.out.println("zeile 1: " + waldoArray[0].length);
//        System.out.println("zeile 1: " + waldoArray[5].length);
//        System.out.println("zeile 1: " + waldoArray[25].length);
//        System.out.println("waldo breite " + waldo.getWidth());





    }



    private static int sadCalculator(Image image, Image waldo, int rowPos, int colPos, int[][] imageArray, int[][] waldoArray) {
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

class SAD_Info{

    public int getSADvalue() {
        return SADvalue;
    }

    private int SADvalue;
    //positioning information:
    private int row;
    private int col;


    public SAD_Info(int currentRow, int currentCol, int SADvalue){
        this.SADvalue = SADvalue;
        row = currentRow;
        col = currentCol;
    }





}
