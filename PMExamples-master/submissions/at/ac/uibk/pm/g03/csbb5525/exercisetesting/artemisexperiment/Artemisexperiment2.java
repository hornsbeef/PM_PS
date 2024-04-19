package at.ac.uibk.pm.g03.csbb5525.exercisetesting.artemisexperiment;

//package artemis;

public class Artemisexperiment2 {
    public static void main(String[] args) {

        char[][] marsmap = {{ '*', '*', '*', '*' },
                { '*', '*', 'R', '*' },
                { '*', '*', '*', '*' },
                { '*', '*', '*', '*' },
                { '*', '*', '*', '*' } };
        System.out.println(displayMapFromMatrix(marsmap));
        int[] roverPosition = searchRover(marsmap);
        System.out.println("Rover is at: " + roverPosition[0]+','+roverPosition[1]);

        //problem here
        System.out.println(displayMapFromMatrix(moveRover(marsmap, 2, 1)));


        roverPosition = searchRover(marsmap);
        System.out.println("Rover is at: " + roverPosition[0]+','+roverPosition[1]);



    }

    public static char[][] moveRover(char[][] marsmap, int rows, int cols) {

        if(marsmap == null){    //good
            return null;
        }
        if(mapEmpty(marsmap)){  //good
            return null;
        }

        int currentRow = findRRow(marsmap);
        int currentCol = findRCol(marsmap);

        if(currentRow + rows >= marsmap.length){
            return null;
        }

        if(currentCol + cols >= marsmap[0].length){
            return null;
        }

        for(int i = 0; i < marsmap.length ; i++){
            for(int j = 0; j < marsmap[i].length; j++){
                marsmap[i][j] = '*';
            }
        }

        for(int i = 0; i < marsmap.length ; i++){
            for(int j = 0; j < marsmap[i].length; j++){
                if(i == rows && j == cols){
                    marsmap[i][j] = 'R';
                }
            }
        }
    return marsmap;
    }

    private static int findRRow(char[][] marsmap){

        for(int i = 0; i < marsmap.length ; i++){
            for(int j = 0; j < marsmap[i].length; j++){

                if(marsmap[i][j] == 'R'){
                    return i;
                }


            }
        }

        return 0;
    }
    private static int findRCol(char[][] marsmap){

        for(int i = 0; i < marsmap.length ; i++){
            for(int j = 0; j < marsmap[i].length; j++){

                if(marsmap[i][j] == 'R'){
                    return j;
                }


            }
        }

        return 0;
    }


    private static boolean mapEmpty(char[][] marsmap){

        boolean isempty = false;

        for(int i = 0; i < marsmap.length ; i++){
            for(int j = 0; j < marsmap[i].length; j++){

                if(marsmap[i][j] != '*'){
                    if(marsmap[i][j] != 'R'){
                        isempty = true;
                        return isempty;
                    }
                }
            }
        }
        return isempty;
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

