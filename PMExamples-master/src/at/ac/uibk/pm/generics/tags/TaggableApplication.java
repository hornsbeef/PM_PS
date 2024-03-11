package at.ac.uibk.pm.generics.tags;

/**
 * Class demonstrates use of TaggableObject (implementing Tagable-interface).
 */

public final class TaggableApplication {
    /**
     * Main method for demonstrating taggable objects.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        TaggableObject taggableObject = new TaggableObject();
        taggableObject.setTag("fancy tag for object");
        System.out.println(taggableObject.getTag());
    }

}
