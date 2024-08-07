package designpatterns.abstractfactorydesignpattern.example1;

public class Cappuccino extends Coffee{
    Cappuccino(IndgredientsFactory indgredientsFactory) {
        super(indgredientsFactory);
    }

    @Override
    void brew() {

    }

    @Override
    void boil() {

    }
}
