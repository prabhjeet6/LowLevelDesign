package designpatterns.abstractfactorydesignpattern;

public class AbstractFactoryTester {
    public static void main(String[] as){
        CoffeeFactory coffeeFactory=new CoffeeFactory();
        System.out.println(coffeeFactory.getCoffee("Espresso"));
        System.out.println(coffeeFactory.getCoffee("Robusta"));
    }
}
