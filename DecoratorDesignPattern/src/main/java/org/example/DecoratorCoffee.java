package org.example;

public abstract class DecoratorCoffee implements Coffee{

    public Coffee coffee;
    public DecoratorCoffee(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public int getCost(){
        return coffee.getCost();
    }
}
