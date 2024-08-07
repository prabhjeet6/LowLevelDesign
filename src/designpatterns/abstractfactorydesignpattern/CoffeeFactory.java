package designpatterns.abstractfactorydesignpattern;

public class CoffeeFactory {

    Coffee getCoffee(String coffeeType){
        Coffee coffee;
        if("Cappuccino".equals(coffeeType)){
            return new Cappuccino(new CappuccinoIngredientFactory());
        }else if("Espresso".equals(coffeeType)){
            return new Espresso(new EspressoIndgredientsFactory());
        }else{
            return new Robusta(new RobustaIndgredientsFactory());
        }
    }

}
