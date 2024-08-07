package designpatterns.abstractfactorydesignpattern;

public interface IndgredientsFactory {
    Bean getBean();
    Milk getMilk();
    Sugar getSugar();
}
