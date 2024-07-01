package at.ac.uibk.pm.g03.csbb5525.exercisetesting.bigDecimal;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class BigDecimalTesting {

    public static void main(String[] args) {
        BigDecimal x = BigDecimal.valueOf(12345, 2);

        System.out.println(x);      //Ausgabe: 123.45

        System.out.printf("%-2.1s", "test" );
        System.out.printf("%-+5d|\n", 15 );

        //////////////////////////////////////////////////////////////////////

        StringBuilder sb1 = new StringBuilder("01234");
        sb1.replace(3, 4, "asdf");
        System.out.println(sb1);

        //////////////////////////////////////////////////////////////////////
        Collection<String> collection = new ArrayList<>(List.of("a", "b", "c"));

        //collection.listIterator()
        Iterator<String> it = collection.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            it.remove();
        }
        System.out.println("#".repeat(20));
        System.out.println(collection);


        Collection<Object> variableList = new ArrayList<>();
        variableList.add("asdf");
        variableList.add(1);
        variableList.add(BigDecimal.ONE);
        variableList.add(new BigDecimalTesting());

        System.out.println(variableList);

        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        System.out.println(map);

        var entries = map.entrySet();
        System.out.println(entries);

        var keys = map.keySet();
        System.out.println(keys);

        keys.remove(1);

        System.out.println(map);

        //keys.add(null);   //not possible on TreeMap...
        System.out.println(map);

        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        hashMap.put(4, "four");
        hashMap.put(null, "four");  //works for HashMap

        System.out.println(hashMap);

        var mapValues = map.values();
        System.out.println(mapValues);

        List<String> mapValueLIst = new ArrayList<>(mapValues);

        Collections.reverse(mapValueLIst);
        System.out.println("Reverse: " +mapValueLIst);
        Collections.shuffle(mapValueLIst);
        System.out.println("Shuffle: " +  mapValueLIst);

        List<Integer> testList = List.of(1, 2, 3,4,5,6,7,8,9,10,11);







    }

}
