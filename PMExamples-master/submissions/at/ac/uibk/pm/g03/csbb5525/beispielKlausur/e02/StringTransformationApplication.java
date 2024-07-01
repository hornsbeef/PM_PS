package at.ac.uibk.pm.g03.csbb5525.beispielKlausur.e02;

import java.util.function.Function;

public class StringTransformationApplication {

    public static void transform(Function<String, String> function, String stringToTransform){

        System.out.println(function.apply(stringToTransform));

    }

    public static void main(String[] args) {
        StringTransformationApplication.transform(StringTransformer.createOperation1(3, "*"), "123456789");

        StringTransformationApplication.transform(StringTransformer.createOperation2(), "Abilities");
    }


}
