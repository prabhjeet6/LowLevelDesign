package designpatterns.abstractfactorydesignpattern.example1;

public class EspressoIndgredientsFactory implements IndgredientsFactory{
    @Override
    public Bean getBean() {
        return new FrenchBean();
    }

    @Override
    public String toString() {
        return "EspressoIndgredientsFactory{}";
    }

    @Override
    public Milk getMilk() {
        return new PowderedMilk();
    }

    @Override
    public Sugar getSugar() {
        return new BrownSugar();
    }
}
