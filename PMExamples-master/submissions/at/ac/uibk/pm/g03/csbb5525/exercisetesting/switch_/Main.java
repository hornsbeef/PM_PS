package at.ac.uibk.pm.g03.csbb5525.exercisetesting.switch_;
//trying to understand difference between switch-statement and switch-expression:


public class Main {


    public static void main(String[] args){
        enum Input {ONE, TWO, THREE}

        int inputStatment = 11;

        //switch-statement:
        String switchStatementMessage = "";

        switch (inputStatment){
            case 1 -> {
                switchStatementMessage = "ONE";
            }
            case 2 -> switchStatementMessage = "TWO";
            //default -> switchStatementMessage = "default";

        }
        /*
        -> no warning, that not all cases have been checked!
        with the "->"   no fallthrough possible.
         */

        System.out.println(switchStatementMessage);

        int inputExpression = 1;

        String switchExpressionMessage = switch (inputExpression){
            case (1) -> "one";
            case 2 -> {yield "two";}
            case 3 -> "three";

            default -> "default";
        };
        System.out.println(switchExpressionMessage);


        System.out.println(switch (inputExpression){
            case 1 -> "one";
            default -> "default";
        });

        /*
        -> 'switch' expression does not cover all possible input values - ERROR:
            -> is warning that not all cases have been checked!!!

        switch-Expression needs ; after the } -> var x = switch(yyy){cases....};

        switch-Expression possible inside of System.out.println(-here-) -> ?in function calls?
         */



    }








}
