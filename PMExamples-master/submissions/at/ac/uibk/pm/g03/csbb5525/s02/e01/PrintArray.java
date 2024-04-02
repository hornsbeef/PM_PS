package at.ac.uibk.pm.g03.csbb5525.s02.e01;

import java.util.Arrays;

public class PrintArray {

    /* TODO: declare and implement the method printArray! */
    public static void printArray(int[][] array, String seperator){

        for(int[] innerArray : array){
            for(int number : innerArray){
                System.out.print(number + seperator);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        printArray(array, " | ");
    }
}



/*
Fügen Sie eine static-Methode namens printArray in die bereitgestellte Datei PrintArray.java ein.
Die Funktion soll das übergebene zweidimensionale int-Array ausgeben.
Jede Zeile des Arrays wird in einer neuen Zeile ausgegeben
und nach jedem Element wird der Trenner ausgegeben.
Die Methode hat zwei Parameter und gibt nichts zurück. Der erste Parameter ist ein zweidimensio-
nales int-Array beliebiger Größe und der Zweite ist ein String, der den Trenner angibt.

(hidden notes)
Implementieren Sie printArray entsprechend dieser Angaben! Verwenden Sie außerdem keine
Schleifen außer der erweiterten for-Schleife
 */