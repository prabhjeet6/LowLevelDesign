package designpatterns.decoratordesignpattern;

//Decorator is a structural design pattern that lets you attach new behaviors to objects by placing
// these objects inside special wrapper objects that contain the behaviors.
//https://refactoring.guru/design-patterns/decorator
//  example BufferedReader:ref source
public class DecoratorPatternTester {
    public static void main(String[] as) {
        Pizza pizza = new Mushroom(new Olive(new Onion(new WheatBase())));
        System.out.println(pizza.getName() + " " + pizza.getCost());
    }
}
