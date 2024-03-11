package at.ac.uibk.pm.generics.tags;

/**
 * Class demonstrates usage of taggable interface.
 */
public class TaggableObject implements Taggable<String> {
    private String tag;

    /**
     * Method sets tag for current object.
     *
     * @param tag content of tag to be set
     */
    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Method retrieves set tag.
     *
     * @return tag assigned to object.
     */
    @Override
    public String getTag() {
        return tag;
    }
}