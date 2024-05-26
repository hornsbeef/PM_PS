package at.ac.uibk.pm.g03.csbb5525.s07.e02;

import java.util.*;
import java.util.stream.Collectors;

public class QueueDirectoryIterator implements Iterator<String> {

    private final Queue<String> queue;


    public QueueDirectoryIterator(Map<Integer, List<String>> namesByAge) {
        this.queue = namesByAge.entrySet()
                               .stream()
                               //stream of Entries of <Integer, List<String>>
                               .map(entry -> {
                                   int age = entry.getKey();
                                   List<String> namesWithThisAge = entry.getValue();
                                   return namesWithThisAge.stream()
                                                          .map(name -> "%s (%d)".formatted(name, age));
                               })
                               //->stream of Streams of Strings
                               .flatMap(it -> it)
                               //-> Stream of Strings
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
