package at.ac.uibk.pm.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class representing an iterator over all positive integers up to a given value.
 */
public final class PositiveIntegerIterator implements Iterator<Integer> {
    private int current = 0;
    private final int n;

    /**
     * Create an iterator over the integers from 0 to n-1.
     *
     * @param n upper bound (excluded)
     */
    public PositiveIntegerIterator(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        return current < n;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return ++current;
    }
}