package at.ac.uibk.pm.g03.csbb5525.beispielKlausur.e01;

import java.util.*;
import java.util.stream.Collectors;

public class FunctionalJava {

    public <E extends Comparable<? super E>> List<E> methodA(List<E> list, E min, E max){

        return list.stream().distinct().sorted().filter(Objects::nonNull)
                .filter(it -> it.compareTo(min) >= 0)
                .filter(it ->it.compareTo(max) <= 0)
                .collect(Collectors.toUnmodifiableList());
    }


public <K, V> Map<V, Set<K>> methodB(Map<K, V> values){

    return values.entrySet()
                 .stream()
                 .map(entry -> {
                     var x =  new AbstractMap.SimpleEntry<>(entry.getValue(), new HashSet<K>());
                     HashSet<K> keyValueSet = new HashSet<>();
                     keyValueSet.add(entry.getKey());
                     x.setValue(keyValueSet);
                     return x;
                 })
                 .collect(Collectors.toMap(it -> it.getKey(), it -> it.getValue()));
}

    public <K, V> Map<V, Set<K>> methodB2(Map<K, V> values){
        Map<V, Set<K>> result = new HashMap<>();
        for(Map.Entry<K, V> entry : values.entrySet()){
            result.putIfAbsent(entry.getValue(), new HashSet<>());
            result.get(entry.getValue()).add(entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> integerSet = Set.of(1, 2, 3);
        Map<String, Set<Integer>> map = new HashMap<>();

        map.put("one", integerSet);
        map.put("two", Set.of(4,5,6));
        map.put("three", Set.of(7,8,9));
        map.put("four", Set.of(10,11,12));
        map.put(null, Set.of(10,11,12));
        map.put("four", null);

        System.out.println(new FunctionalJava().methodB2(map));

        System.out.println("-".repeat(20));
        System.out.println(new FunctionalJava().methodB(map));



    }




}
