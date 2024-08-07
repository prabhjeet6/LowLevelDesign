package designpatterns.abstractfactorydesignpattern;

public class Espresso extends Coffee{

    Espresso(IndgredientsFactory indgredientsFactory) {
        super(indgredientsFactory);
    }

    @Override
    void brew() {

    }

    @Override
    void boil() {

    }
}
