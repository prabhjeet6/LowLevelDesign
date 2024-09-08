package designpatterns.decoratordesignpattern;

public class Onion extends Topping{
    public Onion( Pizza pizza) {
        super("Onion", 4d, pizza);
    }
}
