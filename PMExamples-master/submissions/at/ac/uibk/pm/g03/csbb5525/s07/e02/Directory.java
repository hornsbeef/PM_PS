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

    public Directory(Collection<Member> members) {
        this.namesByAge = members.stream()
                                 .collect(Collectors.groupingBy(Member::getAge, Collectors.mapping(Member::getName, toList())));
        //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Collectors.html#groupingBy(java.util.function.Function)
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
                                  .limit(n)
                                  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new Directory(temp);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<String> listNames() {
        return namesByAge.values()
                         .stream()
                         .flatMap(Collection::stream)
                         .collect(Collectors.toUnmodifiableList());
        //return namesByAge.values().stream().collect(Collectors.toUnmodifiableList());
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
