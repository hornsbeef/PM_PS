package at.ac.uibk.pm.g03.csbb5525.s01.e04;

public class Months {

    public static void main(String[] args) {
        String month = "Feb";

        int monthNumber = switch (month) {
            case "Jan" -> 1;
            case "Feb" -> 2;
            case "Mar" -> 3;
            case "Apr" -> 4;
            case "May" -> 5;
            case "Jun" -> 6;
            case "Jul" -> 7;
            case "Aug" -> 8;
            case "Sep" -> 9;
            case "Oct" -> 10;
            case "Nov" -> 11;
            case "Dec" -> 12;
            default -> -1;
        };

        //Switch expression that maps monthNumber to the number of days in the month
        int numberOfDays = switch (monthNumber){
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> -1;

        };


        // Print the number of days in the month
        System.out.println(month + " has "+ numberOfDays + " days.");
    }
}