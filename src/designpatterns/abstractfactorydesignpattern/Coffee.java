package designpatterns.abstractfactorydesignpattern;

public abstract class Coffee {
    private final Milk milk;
    private final Sugar sugar;
    private final Bean bean;

    private final IndgredientsFactory indgredientsFactory;
    abstract void brew();

    @Override
    public String toString() {
        return "Coffee{" +
                "milk=" + milk +
                ", sugar=" + sugar +
                ", bean=" + bean +
                ", indgredientsFactory=" + indgredientsFactory +
                '}';
    }

    abstract void boil();
    Coffee(IndgredientsFactory indgredientsFactory){
        this.indgredientsFactory=indgredientsFactory;
        this.bean=indgredientsFactory.getBean();
        this.milk=indgredientsFactory.getMilk();
        this.sugar=indgredientsFactory.getSugar();
    }

}
