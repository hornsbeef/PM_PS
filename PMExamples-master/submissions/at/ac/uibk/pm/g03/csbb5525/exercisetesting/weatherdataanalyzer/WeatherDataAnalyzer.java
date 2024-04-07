package at.ac.uibk.pm.g03.csbb5525.exercisetesting.weatherdataanalyzer;

import java.util.Arrays;

public class WeatherDataAnalyzer {

    private WeatherDataAnalyzer(){}

    public static double calculateAverage(double[] data){
        return Arrays.stream(data).average().orElse(1.0);
    }

    public static double findMaximum(double[] data){
        return Arrays.stream(data).max().orElse(0.0);
    }

    public static double findMinimum(double[] data){
        return Arrays.stream(data).min().orElse(0.0);
    }

    public static double convertCelsiusToFahrenheit(double celsius){
        return celsius * 9/5 + 32;
    }

    public static double convertKmHtoMph(double kmPerHour){
        return kmPerHour * 0.6213711922;
    }

}

