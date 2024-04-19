package at.ac.uibk.pm.g03.csbb5525.s02.e02;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
improvement comments:

 */


public class TimesTwo {

    public static void timesTwo(int value){
        value *= 2;                         //save to formal parameter
        System.out.println(value);          //print out
    }

    public static void timesTwo(int[] value){

        for(int i = 0; i < value.length; i++){
            value[i] *= 2;
        }

        System.out.println(Arrays.toString(value));

    }


    public static void main(String[] args){

        int singleTest = 1;
        System.out.println("Before:" + singleTest);
        timesTwo(singleTest);
        System.out.println("After: " + singleTest);

        int[] test = {1,2,3,4};
        System.out.println("Before: " + Arrays.toString(test));
        timesTwo(test);
        System.out.println("After: " + Arrays.toString(test));

    }
}


/*
Erstellen Sie eine Klasse namens TimesTwo und implementieren Sie die in a) und b) geforderten
Methoden.
Rufen Sie anschließend beide Methoden in Ihrer main-Methode auf und beantworten
Sie alle Fragen aus c) in einer Text-Datei.

a) Schreiben Sie eine statische (static) Methode namens timesTwo die einen an die Methode
übergegebenen int-Wert mit Zwei multipliziert, das Ergebnis wieder im Parameter speichert
und den berechneten Wert am Ende ausgibt.

b) Schreiben Sie eine statische (static) Methode namens timesTwo die jeden int-Wert eines
an die Methode übergegebenen int-Arrays mit zwei multipliziert, das Ergebnis wieder in der
entsprechenden Zelle speichert und das gesamte Array am Ende ausgibt.

Hinweis
Sie können die Methode Arrays.toString() verwenden um das gesamte Array auszu-
gebn.


c) Recherchieren und erklären Sie:
(i) Warum können mehrere Methoden mit demselben Namen definiert werden?
Weil in Java Methoden-Überladung exisitert. -> damit können mehrere Methode("Funktion") mit dem
selben Namen, aber anderen Parameter-Typen | anderer Reihenfolge der Parameter-Typen existieren,. (Signatur)
Zur Laufzeit wird dann entschieden, weleche Methode aufgerufen wird, abhängig davon, Parameter übergeben werden.
..............................
(ii) Ist es möglich zwei Methoden mit demselben Namen und denselben Parametern aber
unterschiedlichen Rückgabewerten zu definieren?
Nein, die Signatur der beiden Methoden gleich wäre.
Der Rückgabewert ist hier nicht entscheidend.
..............................
(iii) Bedenken Sie: Java unterstützt nur Call by Value.
Beobachten Sie die Variablen,
die jeder der beiden timesTwo Methoden übergeben werden
jeweils vor und nach dem Aufruf der entsprechenden Methode in der main-Methode.
Haben Sich die Werte verändert?
-> nur die Werte im Array haben sich verändert.
Erklären sie warum!
Java unterstützt eigentlich nur Call by Value - wenn es allerdings um Referenz-Typen (zB Arrays)
geht, dann wird zwar technisch betrachtet auch Call by Value verwendet (es wird eine Kopie der Referenz übergeben),
aber praktisch ermöglicht das die Veränderung der Werte des referenzierten Objekts, was auch wieder
ausserhalb sichtbar wird.
 */