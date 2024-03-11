package at.ac.uibk.pm.objectorientation.rationalnumbers;

/**
 * Class stores rational numbers and provides methods for multiplying, adding,
 * negating rational numbers based on normalized rational numbers.
 */
public record Rational(long numerator, long denominator) {

    /**
     * Constructs a normalized rational.
     *
     * @param numerator   nominator
     * @param denominator denominator
     */
    public Rational {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    /**
     * Constructs a rational number representing an integer.
     *
     * @param integer number to be represented as rational.
     */
    public Rational(long integer) {
        this(integer, 1);
    }

    /**
     * Method computes the greatest common divisor of two given numbers.
     *
     * @param x First number
     * @param y Second number
     * @return greatest common divisor of x and y
     */
    private static long gcd(long x, long y) {
        return y == 0 ? Math.abs(x) : gcd(y, x % y);
    }

    /**
     * Adds given rational number to second rational number.
     *
     * @param other rational number to add to
     * @return sum of two given rational numbers
     */
    public Rational add(Rational other) {
        return new Rational(
                numerator * other.denominator + denominator * other.numerator,
                denominator * other.denominator);
    }


    /**
     * Multiplies given rational number with second rational number.
     *
     * @param other rational number to multiply with
     * @return product of two given rational numbers
     */
    public Rational multiply(Rational other) {
        return new Rational(numerator * other.numerator,
                denominator * other.denominator);
    }

    /**
     * Multiplies given rational number with an integer.
     *
     * @param integer integer to multiply with
     * @return product of two given rational numbers
     */
    public Rational multiply(long integer) {
        return multiply(new Rational(integer));
    }

    /**
     * Negates given rational number.
     *
     * @return negated rational number.
     */
    public Rational negate() {
        return new Rational(-numerator, denominator);
    }

}
