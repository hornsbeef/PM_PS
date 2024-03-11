package at.ac.uibk.pm.generics.linkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implements a linked list
 *
 * @param <T> generic type of elements contained within the list.
 */
public class LinkedList<T> implements Iterable<T> {

    private final Node<T> root = new Node<>(null, null);
    private long modificationCounter = 0;

    /**
     * Method increments modification counter.
     */
    private void touch() {
        ++modificationCounter;
    }

    /**
     * Method adds the given element elem to the front of the list.
     *
     * @param elem the element to be added.
     */
    public void add(T elem) {
        touch();
        root.next = new Node<>(elem, root.next);
    }

    /**
     * Method empties the list.
     */
    public void clear() {
        if (root.next != null) {
            touch();
            root.next = null;
        }
    }

    /**
     * Method returns an iterator for the list.
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Method appends another list to the current list.
     *
     * @param other the list to be added.
     */
    public void append(Iterable<? extends T> other) {
        Node<T> last = root;
        while (last.next != null) {
            last = last.next;
        }
        for (T elem : other) {
            touch();
            last.next = new Node<>(elem, null);
            last = last.next;
        }
    }

    /**
     * Returns a string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
            sb.append(iterator.next());
            if (!iterator.hasNext()) {
                break;
            }
            sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * Inner class implementing iterator on top of linked list.
     */
    private class LinkedListIterator implements Iterator<T> {
        private Node<T> iteratorNode = root.next;
        private final long iteratorModificationCounter = modificationCounter;

        /**
         * Method checks if iterator has more elements, returns true if there are more
         * elements, else false.
         *
         * @return true if there is a next element, else false
         */
        @Override
        public boolean hasNext() {
            if (modificationCounter != iteratorModificationCounter) {
                throw new ConcurrentModificationException();
            }
            return iteratorNode != null;
        }

        /**
         * Method returns next element in iteration.
         *
         * @return next element in linked list
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = iteratorNode.element;
            iteratorNode = iteratorNode.next;
            return element;
        }
    }

    /**
     * Inner class holding information about nodes within the linked list.
     */
    private static class Node<T> {
        private final T element;
        private Node<T> next;

        /**
         * Constructs the node with the given element and next element.
         *
         * @param element the content of the node.
         * @param next the next element within the linked list.
         */
        private Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }
}
