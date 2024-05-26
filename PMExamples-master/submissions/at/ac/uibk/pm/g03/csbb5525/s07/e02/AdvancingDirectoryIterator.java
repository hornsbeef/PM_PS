package at.ac.uibk.pm.g03.csbb5525.s07.e02;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class AdvancingDirectoryIterator implements Iterator<String> {

    private final Iterator<Map.Entry<Integer, List<String>>> outerIterator; //Iterator über die Einträge der Map (Map.Entry<Integer, List<String>>)
    private Iterator<String> innerIterator; //Iterator über Liste der Namen für jeden Eintrag der Map.
    private Map.Entry<Integer, List<String>> currentOuter;

    public AdvancingDirectoryIterator(Map<Integer, List<String>> namesByAge) {
        outerIterator = namesByAge.entrySet().iterator();   //entrySet() returns a Set -> Set has a .iterator()
        advanceToNextInnerIterator();   //setzt innerIterator auf ersten gültigen Eintrag
    }

    @Override
    public boolean hasNext() {
        if(innerIterator.hasNext()){
            return true;
        }
        if(outerIterator.hasNext()){
            advanceToNextInnerIterator();
            return true;
        }
        return false;

    }

    @Override
    public String next() {
        if(!this.hasNext()){
            throw new NoSuchElementException(); // correct like this?
        }
        String name = innerIterator.next();
        int age = currentOuter.getKey();
        return "%s (%d)".formatted(name, age);
    }


    private void advanceToNextInnerIterator(){

        if (outerIterator.hasNext()) {
            currentOuter = outerIterator.next();
            innerIterator = currentOuter.getValue()
                                        .iterator();
        }


    }

}
