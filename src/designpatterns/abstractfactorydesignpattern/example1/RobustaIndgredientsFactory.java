package designpatterns.abstractfactorydesignpattern.example1;

public class RobustaIndgredientsFactory implements IndgredientsFactory{
    @Override
    public Bean getBean() {
        return new AmericanBean();
    }

    @Override
    public String toString() {
        return "RobustaIndgredientsFactory{}";
    }

    @Override
    public Milk getMilk() {
        return new PowderedMilk();
    }

    @Override
    public Sugar getSugar() {
        return new RegularSugar();
    }
}
