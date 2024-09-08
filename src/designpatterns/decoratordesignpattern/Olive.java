package designpatterns.decoratordesignpattern;

public class Olive extends Topping {
    public Olive(Pizza pizza) {
        super("Olive", 16d, pizza);
    }
}
