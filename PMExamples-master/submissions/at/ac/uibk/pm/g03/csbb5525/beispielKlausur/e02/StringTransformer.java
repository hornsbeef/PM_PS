package at.ac.uibk.pm.g03.csbb5525.beispielKlausur.e02;

import java.util.function.Function;

interface myMarker{
}

public class StringTransformer implements myMarker{

    public static Function<String, String> createOperation1(int offset, String separator){
        Function<String, String> operation1 = (String input ) -> {
            StringBuilder sb = new StringBuilder(input);

            int currentPos = 0;
            while(currentPos + offset < sb.length()){
                sb.insert(currentPos+offset, separator);
                currentPos += offset + separator.length();
            }
            return sb.toString();
        };
        return operation1;
    }

    public static Function<String, String> createOperation2(){
        Function<String, String> operation2 = (String input) -> {
            String newString = new String(input);
            return newString.replace('A', '4').replace('b', '6')
                     .replace('i', '!').replace('l', '1').replace('s', '$');

        };
        return operation2;
    }



}
