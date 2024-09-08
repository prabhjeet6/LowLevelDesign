package designpatterns.decoratordesignpattern;

public class Mushroom extends Topping{
    public Mushroom( Pizza pizza) {
        super("Mushroom", 6d, pizza);
    }
}
