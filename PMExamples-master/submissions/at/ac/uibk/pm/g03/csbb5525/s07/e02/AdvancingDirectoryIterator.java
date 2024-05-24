package at.ac.uibk.pm.g03.csbb5525.s07.e02;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AdvancingDirectoryIterator implements Iterator<String> {

    private final Iterator<Map.Entry<Integer, List<String>>> outerIterator;
    private Iterator<String> innerIterator;

    public AdvancingDirectoryIterator(Map<Integer, List<String>> namesByAge) {
        outerIterator = namesByAge.entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        // TODO
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String next() {
        // TODO
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
