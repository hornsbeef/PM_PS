package at.ac.uibk.pm.g03.csbb5525.exercisetesting.artemisexperiment_exercise.two;

//package artemis;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] marsmap = {{ '*', '*', '*', '*' },
                { '*', '*', 'R', '*' },
                { '*', '*', '*', '*' },
                { '*', '*', '*', '*' },
                { '*', '*', '*', '*' } };


        System.out.println(displayMapFromMatrix(marsmap));
        int[] roverPosition = searchRover(marsmap);
        System.out.println("Rover is at: " + roverPosition[0]+','+roverPosition[1]);
        System.out.println(displayMapFromMatrix(moveRover(marsmap, 2, 1)));
        roverPosition = searchRover(marsmap);
        System.out.println("Rover is at: " + roverPosition[0]+','+roverPosition[1]);
    }

    public static char[][] moveRover(char[][] marsmap, int rows, int cols) {
        if (marsmap ==null || marsmap.length == 0){
            return null;
        }

        //added for better checking!
        for (int i = 0; i <marsmap.length ; i++) {
            if (marsmap[i] ==null || marsmap[i].length == 0){
                return null;
            }
        }

        int[] roverPosition = searchRover(marsmap);
        //add checking if rover is even on map
        if( roverPosition == null ){   //maybe || is better here than &&
            return null; // map is null or empty -> return null
        }
        if(roverPosition[0] == -1 || roverPosition[1] == -1){   //maybe || is better here than &&
            return marsmap; //rover not on map simply return map.
        }

        int newrow = 0;
        int newcol = 0;

        if(rows >= 0){
            if( (roverPosition[0] + rows) >= marsmap.length){
                newrow = marsmap.length -1;
            }else{
                newrow = roverPosition[0] + rows;
            }
        }
        if(rows < 0){
            if( (roverPosition[0] + rows) < 0){
                newrow = 0;
            }else{
                newrow = roverPosition[0] + rows;
            }
        }


        if(cols >= 0){
            if( (roverPosition[1] + cols) >= marsmap[0].length){
                newcol = marsmap[0].length -1;
            }else{
                newcol = roverPosition[1] + cols;
            }
        }
        if(cols < 0){
            if( (roverPosition[1] + cols) < 0){
                newcol = 0;
            }else{
                newcol = roverPosition[1] + cols;
            }
        }

       // marsmap[roverPosition[0]][roverPosition[1]] = '*';
        for (int i = 0; i < marsmap.length; i++) {
            Arrays.fill(marsmap[i], '*');

        }

        marsmap[newrow][newcol] = 'R';


        return marsmap;



    }

    /*
     * Util Methods
     *
     */
    public static int[] searchRover(char[][] marsmap) {
        if (marsmap == null || marsmap.length == 0) return null;
        for(int i=0; i < marsmap.length; i++) {
            if (marsmap[i] == null || marsmap[i].length == 0 || marsmap[i].length != marsmap[0].length) return null;
        }

        int[] result = new int[2];
        for (int i = 0; i < marsmap.length; i++) {
            for (int j = 0; j < marsmap[i].length; j++) {
                if (marsmap[i][j] == 'R') {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return new int[] {-1,-1};
    }

    public static String displayMapFromMatrix(char[][] matrix) {
        String out = " ";
        if (matrix == null || matrix.length == 0) return "null";
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                out += matrix[x][y] + ", ";
            }
            out += "\n ";
        }
        return out;
    }
}
