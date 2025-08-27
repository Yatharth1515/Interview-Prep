package org.example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Bird bird = () -> {
            System.out.println("abcam");
        };
        bird.canFly();


        Consumer<Integer> abc = (val) -> {
            if (val > 10){
                System.out.println("print val " + val);
            }
        };
        abc.accept(20);
        abc.accept(11);

        Supplier<Integer> newSup = () -> {
            return 100;
        };
        Supplier<String> newSup1 = () -> {
            return "This is supplier";
        };
        System.out.println(newSup.get());
        System.out.println(newSup1.get());

        Function<Integer, String> newFunc = (value) -> {

            if (value >= 100) {
                return value.toString();
            }
            return null;
        };
        System.out.println(newFunc.apply(101));

        Predicate<Integer> newPred = (value) -> {
            if(value % 2 == 0) return true;
            return false;
        };
        System.out.println(newPred.test(101));
        System.out.println(newPred.test(1000));

    }
    /*
    what is functional interface(java 8 feature)
    -> if an interface contains only 1 abstract method , buy can have static , private methods also
    @FunctionalInterface restricts us and throws compilation error if we try to add more than 1 abstract method
     */
    /*
    what is lambda expression ?
    -> way of implementing functional interface
     */
    /*
    Types of functional interface:-
    1. consumer -> accepts single i/p and returns no result.
    2. Supplier -> accepts no i/p and returns result
    3. Functional -> accepts one argument and returns a result
    4. Predicate -> accepts one argument and returns a boolean

     */

}
