package designpatterns.abstractfactorydesignpattern;

public class CappuccinoIngredientFactory implements IndgredientsFactory{
    @Override
    public Bean getBean() {
        return new AmericanBean();
    }

    @Override
    public String toString() {
        return "CappuccinoIngredientFactory{}";
    }

    @Override
    public Milk getMilk() {
        return new CowMilk();
    }

    @Override
    public Sugar getSugar() {
        return new RegularSugar();
    }
}
