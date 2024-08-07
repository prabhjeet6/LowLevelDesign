package designpatterns.abstractfactorydesignpattern.example1;

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
