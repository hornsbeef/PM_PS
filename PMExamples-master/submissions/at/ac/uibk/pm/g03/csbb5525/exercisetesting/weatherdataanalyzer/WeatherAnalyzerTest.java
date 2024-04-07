package at.ac.uibk.pm.g03.csbb5525.exercisetesting.weatherdataanalyzer;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherAnalyzerTest {
    @Test
    public void calculateAverage(){
        double[] array = {1,2,3,4,5};
        double expectation = 3;
        assertEquals(expectation, WeatherDataAnalyzer.calculateAverage(array));
    }

    @Test
    public void emptyArrayReturns0(){
        double[] array = {};
        double expectation = 0.0;
        assertEquals(expectation, WeatherDataAnalyzer.calculateAverage(array));
    }

    @Test
    public void celsiusToFahreheit(){
        assertEquals(32, WeatherDataAnalyzer.convertCelsiusToFahrenheit(0));
        assertEquals(302, WeatherDataAnalyzer.convertCelsiusToFahrenheit(150));
        assertEquals(50, WeatherDataAnalyzer.convertCelsiusToFahrenheit(10));
        assertEquals(14, WeatherDataAnalyzer.convertCelsiusToFahrenheit(-10));
        assertEquals(33.8, WeatherDataAnalyzer.convertCelsiusToFahrenheit(1));
    }



    @Test
    public void _0_mkhToMph_0_(){
        assertEquals(0, WeatherDataAnalyzer.convertKmHtoMph(0));
    }
    @Test
    public void _100_mkhToMph__(){
        DecimalFormat df = new DecimalFormat("#.####");
        String expected = "62,1371";
        String result = df.format(WeatherDataAnalyzer.convertKmHtoMph(100));
        assertEquals(expected, result);
    }
}
