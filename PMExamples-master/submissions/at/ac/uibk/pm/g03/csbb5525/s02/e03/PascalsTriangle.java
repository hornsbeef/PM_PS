package at.ac.uibk.pm.g03.csbb5525.s02.e03;

import static java.lang.Integer.parseInt;
import static at.ac.uibk.pm.g03.csbb5525.s02.e01.PrintArray.printArray;

public class PascalsTriangle {

    private static int[][] pascalTriangle(int lines){
    //int[][] was used to ease printing.
    //could have used long, but even then overflow occurs at some point.

        if(lines <= 0){
            System.out.println("only Integers >=1 allowed!");
            int[][] pascalTriangle = {{0}};
            return pascalTriangle;
        }

        int[][] pascalTriangle = new int[lines][];

        int maxRows = pascalTriangle.length;

        for(int currentRow = 0; currentRow < maxRows; currentRow++){

            pascalTriangle[currentRow] = new int[currentRow+1];     //CAVE: MUST be currentRow + 1 !!! (count starts @ 0...)
            int maxCols = pascalTriangle[currentRow].length;

            for(int currentCol = 0; currentCol < maxCols; currentCol++){

                if(currentCol == 0){
                    pascalTriangle[currentRow][currentCol] = 1;
                } else if (currentCol == (maxCols - 1)) {
                    pascalTriangle[currentRow][currentCol] = 1;
                }else{
                    pascalTriangle[currentRow][currentCol] = pascalTriangle[currentRow-1][currentCol-1] + pascalTriangle[currentRow-1][currentCol];
                }
            }
        }
        return pascalTriangle;
    }



    private static void printPascalTriangel(int[][] pascalTriangle){
        //this code is functional but not used, since the imported class ...printArray does its job.
        //this was a try to symmetrically print out the array, taking the growing number width into consideration.
        //has been abandoned in favour of Where's Waldo? e04

        // this hopefully gives me the length of the number in the middle of the last line ( + 2):
        int max_number_width;
        if(pascalTriangle.length == 1){
            max_number_width = 1;
        }else{
            max_number_width = String.valueOf(pascalTriangle[pascalTriangle.length - 1][pascalTriangle[pascalTriangle.length - 1].length / 2]).length() + 2;
        }

        //System.out.println("maxNumberWidth " + max_number_width);
        String space = " ";


        for (int[] ints : pascalTriangle) {
            for (int inner = 0; inner < ints.length; inner++) {
                int numWidth = String.valueOf(ints[inner]).length();
                int padding = ((max_number_width - numWidth) / 2) + 2;

                String pos = String.valueOf(ints[inner]);

                if ((numWidth % 2) == 0) {
                    int paddingLeft = padding - 1;
                    pos = String.format(space.repeat(paddingLeft) + " " + pos + " " + space.repeat(padding));

                } else {
                    pos = String.format(space.repeat(padding) + " " + pos + " " + space.repeat(padding));
                }

                if (inner == (ints.length - 1)) {   //for last pos

                    System.out.println(pos);

                } else {  //for all pos between

                    System.out.print(pos);
                }


            }
        }

    }


    public static void main(String[] args){

        int input = parseInt(args[0]);

        int[][] pascTriangle = pascalTriangle(input);
        printArray(pascTriangle, " ");
        //printPascalTriangel(pascTriangle);




    }

}

/*

Schreiben Sie eine Methode namens pascalsTriangle, die ein pascalsches Dreieck der Höhe n er-
zeugt und zurückgibt. Der Rückgabewert der pascalsTriangle-Methode soll ein zweidimensionales
Array sein, welches die ersten n Zeilen des pascalschen Dreiecks enthält.
Jede Zeile soll dabei ein
Sub-Array sein, welches nur genau die Zahlen der entsprechenden Zeile des pascalschen Dreiecks
enthält.
Die main-Methode gibt das ermittelte pascalsche Dreieck der Höhe n aus, wobei n als Kommando-
zeilenparameter (args[0]) angegeben wird. Hängen Sie dazu bei der Ausführung Ihres Programms
ein zusätzliches Argument an den java-Befehl oder an die Run-Configuration beispielsweise von
IntelliJ IDEA an.

Die nachfolgende Methode könnte bei der Lösung der Aufgabe hilfreich sein:
• Integer.parseInt(java.lang.String)
    https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Integer.html#parseInt(java.lang.String)
Sie können in der verlinkten Dokumentation eine kurze Beschreibung der Methode finden.

 */