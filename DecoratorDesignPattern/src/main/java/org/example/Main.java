package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!, learning decorator design pattern");

        Coffee coffee = new PlainCoffee();
        System.out.println(coffee.getCost());

        coffee = new ArabicaCoffee();
        System.out.println(coffee.getCost());

        coffee = new MilkDecorator(new ArabicaCoffee());
        System.out.println(coffee.getCost());

        coffee = new MilkDecorator(new SugarDecorator(new ArabicaCoffee()));
        System.out.println(coffee.getCost());

    }
}