package org.example;

public class MilkDecorator extends DecoratorCoffee{
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public int getCost() {
        return super.getCost() + 15;
    }
}
