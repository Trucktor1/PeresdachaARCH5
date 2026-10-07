package org.example;

interface Coffee {
    String getDescription();
    int getCost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() { return "Простой кофе"; }
    public int getCost() { return 100; }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    CoffeeDecorator(Coffee coffee) { this.coffee = coffee; }
}

class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() {
        return coffee.getDescription() + ", с молоком";
    }
    public int getCost() { return coffee.getCost() + 30; }
}

class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() {
        return coffee.getDescription() + ", с сахаром";
    }
    public int getCost() { return coffee.getCost() + 10; }
}

public class DecoratorPT {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println("Цена: " + coffee.getCost() + " руб.");
    }
}
