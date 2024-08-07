package designpatterns.abstractfactorydesignpattern.example1;

public interface IndgredientsFactory {
    Bean getBean();
    Milk getMilk();
    Sugar getSugar();
}
