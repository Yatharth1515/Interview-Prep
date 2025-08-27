package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1000,4000,30000,5000,2000);
        //salaries > 3000
        long ans =  list.stream().filter(salary -> salary > 3000).count();
        System.out.println(ans);
        List<Integer> sortedList = list.stream().sorted((a, b) -> b-a).toList();
        for (Integer n: sortedList) {
            System.out.print(" " + n);
        }
        System.out.println();
        //map
        List<String> newlist = list.stream().sorted().map(Object::toString).toList();
        for (String i: newlist) {
            System.out.print(" " + i);
        }
        System.out.println();
        // Filter and Map
        Stream<String> nameStream = Stream.of("HELLO","EVERYBODY","HOW","ARE","YOU","DOING");
        List<String> filteredStream = nameStream.filter(name -> name.length() <= 3).toList();
        filteredStream.forEach(System.out::println);
        Stream<String> nameStream2 = Stream.of("HELLO","EVERYBODY","HOW","ARE","YOU","DOING");
        List<String> mapStreams = nameStream2.map(String::toLowerCase).toList();
        mapStreams.forEach(System.out::println);
        //FlatMap
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("I", "Love", "Learning"),
                Arrays.asList("I", "Am", "Yatharth"),
                Arrays.asList("Everyday", "Is", "Great"),
                Arrays.asList("")
        );

        List<String> flatten = nestedList.stream().flatMap(Collection::stream).toList();
        List<String> newFlatten = nestedList.stream().flatMap(words -> words.stream().map(String::toUpperCase)).distinct().toList();
        for (String itr : newFlatten) {
            System.out.print(itr + " ");
        }
        //peek
        System.out.println();
        System.out.println("peek");
        // since no terminate operation is used nothing will be printed as intermediate operations are lazy and gets invoked only when terminate operation is used
        Stream<String> flatten2 = nestedList.stream().
                flatMap(Collection::stream).
                peek(i -> System.out.print(i + " ---- "));
        List<String> flatten3 = nestedList.stream().
                flatMap(Collection::stream).
                peek(i -> System.out.print(i + " ")).
                toList();

        // sequence of stream operations
        System.out.println("-------------");
        List<Integer> numbers = Arrays.asList(2,1,4,7,10, 100, 1000, 10000, 13, 1421, 121, 25309, 3484, 9, 81, 151);
        Stream<Integer> numStream = numbers.stream()
                .filter(val -> val >= 3)
                .peek(val -> System.out.println("after filter :- " + val))
                .map(val -> -1 * val)
                .peek(val -> System.out.println("after negating :- " + val))
                .sorted()
                .peek(val -> System.out.println("after sorting :- " + val));

        List<Integer> filteredNumStream = numStream.toList();
        System.out.println("---reduce---");
        Optional<Integer> reducedVal = numbers.stream().reduce(Integer::sum);
        System.out.println(reducedVal);
        if (reducedVal.isPresent()){
            int ans1 = reducedVal.get();
            System.out.println(ans1);
        }

        Optional<Integer> minVal = numbers.stream().filter(val -> val >= 3).min((a, b) -> b-a);
        System.out.println(minVal);
        Optional<Integer> maxVal = numbers.stream().filter(val -> val >= 3).max((a, b) -> a-b);
        System.out.println(maxVal);
        Optional<Integer> anyMatch = numbers.stream().filter(val -> val < 3).findFirst().orElse(null).describeConstable();
        System.out.println(anyMatch);

        System.out.println("parallel vs sequential stream");

        List<Integer> nums = IntStream.rangeClosed(1, 100000).boxed().toList();
        long parallelProcessingTime = System.currentTimeMillis();
        nums.parallelStream().map(val -> doCal(val)).filter(val -> val > 1000).toList();
        System.out.println("parallel processingTime " + (System.currentTimeMillis() - parallelProcessingTime));
        long seqProcessingTime = System.currentTimeMillis();
        nums.stream().map(val -> doCal(val)).filter(val -> val > 1000).toList();
        System.out.println("sequential processingTime " + (System.currentTimeMillis() - seqProcessingTime));



    }

    private static int doCal(Integer val) {
        for (int i = 1 ; i < val ; i++){
            val += i;
        }
        return val;
    }
}