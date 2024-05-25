package at.ac.uibk.pm.g03.csbb5525.s07.e02;

import java.util.*;
import java.util.stream.Collectors;

public class QueueDirectoryIterator implements Iterator<String> {

    private Queue<String> queue;


    public QueueDirectoryIterator(Map<Integer, List<String>> namesByAge) {
        //TODO: errorchecking - IllegalArgumentException(); ?
        this.queue = namesByAge.entrySet()
                               .stream()
                               .map(it -> {
                                 return "%s (%d)".formatted(it.getValue(), it.getKey());
                             })
                               .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
        //queue = empty -> returns false
        //queue = not empty -> returns true
    }

    @Override
    public String next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return queue.remove();
    }
}
