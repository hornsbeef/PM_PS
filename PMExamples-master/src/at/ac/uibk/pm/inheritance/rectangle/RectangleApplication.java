package at.ac.uibk.pm.inheritance.rectangle;

/**
 * Class provides means to test rectangle implementation.
 */
public class RectangleApplication {

    /**
     * Main method for rational application
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(20, 3);
        Rectangle rectangle2 = new Rectangle(20, 3);
        System.out.println(rectangle1);
        System.out.println(rectangle1 == rectangle2);
        System.out.println(rectangle1.equals(rectangle2));
    }
}
