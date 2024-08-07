package designpatterns.abstractfactorydesignpattern;

public class Robusta extends Coffee{
    Robusta(IndgredientsFactory indgredientsFactory) {
        super(indgredientsFactory);
    }

    @Override
    void brew() {

    }

    @Override
    void boil() {

    }
}
