package at.ac.uibk.pm.g03.csbb5525.s07.e02;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Directory implements Iterable<String> {

    private final Map<Integer, List<String>> namesByAge;

    public Directory(Map<Integer, List<String>> namesByAge) {
        this.namesByAge = namesByAge;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //creates Map<Integer, List<String>> grouping names by age.
    //Cave: also needs to be sorted form lowest to highest age. -> TreeMap
    //groupingBy returns a Map, where the key is the age, and the values are List<member-names = String>
    //the age is used to determine how each member will be grouped
    //the TreeMap::new specifies the type of Map to be used for storing the grouped elements -> sorted by ascending age
    //Collectors.mapping(Member::getName, toList()):
        //Member::getName -> gives the name of a member
        //toList() collects all the input elements into a List, in encounter order
    public Directory(Collection<Member> members) {
        this.namesByAge = members.stream()
                                 .collect(Collectors.groupingBy(Member::getAge,
                                                                TreeMap::new,
                                                                Collectors.mapping(Member::getName, toList()))
                                 );
        //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Collectors.html#groupingBy(java.util.function.Function,java.util.function.Supplier,java.util.stream.Collector)
        //https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#mapping-java.util.function.Function-java.util.stream.Collector-
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static Directory ofUniqueMembers(Collection<Member> members) {
        return new Directory(deduplicate(members));
    }

    private static Collection<Member> deduplicate(Collection<Member> members) {
        //return members.stream().collect(Collectors.toCollection(()-> new TreeSet<>()));
        return new TreeSet<>(members);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public Directory upTo(int age) {
        var temp = this.namesByAge.entrySet()
                                  .stream()
                                  .filter(it -> it.getKey() <= age)
                                  .collect(Collectors.toMap(Map.Entry::getKey, itv -> itv.getValue()));
        return new Directory(temp);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public Directory ofYoungestNAgeGroups(int n) {
        //TreeMap should be ordered by natural ordering of its keys
        var temp = this.namesByAge.entrySet()
                                  .stream()
                                  .limit(n) //here profit form TreeMap!
                                  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new Directory(temp);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // unmodifiable List of names
    //intelliJ always wants to replace .collect(Collectors.toUnmodifiableList()); with .toList();
    //which works.
    //Cave: Stream.toList() and Collectors.toList() are different
    //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Stream.html#toList()
    public List<String> listNames() {
        return namesByAge.values()
                         .stream()
                         .flatMap(Collection::stream)
                         .toList();

        /*
        return namesByAge.values()
                         .stream()
                         .flatMap(Collection::stream)
                         .collect(Collectors.toUnmodifiableList());
         */
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int size() {
        // # of members
        return namesByAge.values()
                         .size();
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Iterator<String> iterator() {
        return new QueueDirectoryIterator(namesByAge);
    }

    public Iterator<String> advancingIterator() {
        return new AdvancingDirectoryIterator(namesByAge);
    }
}
