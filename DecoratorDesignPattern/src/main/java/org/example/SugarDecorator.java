package org.example;

public class SugarDecorator extends DecoratorCoffee{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public int getCost(){
        return super.getCost() + 10;
    }
}
