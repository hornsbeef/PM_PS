package at.ac.uibk.pm.objectorientation.rationalnumbers;

/**
 * Class provides means to test rational implementations.
 */
public class RationalApplication {

    /**
     * Main method for rational application
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Rational r1 = new Rational(2);
        Rational r2 = new Rational(2, 3);
        Rational r3 = r2.multiply(3);
        System.out.println(r1.numerator());
        System.out.println(r1.denominator());
        System.out.println(r1);
        System.out.println(r1.equals(r3));
    }
}
