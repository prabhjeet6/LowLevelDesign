package designpatterns.factorydesignpattern;
//Creational Design Pattern
public class FactoryDesignPattern {
    public static void main(String[] arg) throws Exception {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("Circle").draw();
        shapeFactory.getShape("triangle").draw();
        shapeFactory.getShape("Utopia").draw();
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle Drawn");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle Drawn");
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Triangle Drawn");
    }
}

class ShapeFactory {


    Shape getShape(String shape) throws Exception {
        if ("circle".equalsIgnoreCase(shape)) {
            return new Circle();
        } else if ("rectangle".equalsIgnoreCase(shape)) {
            return new Rectangle();
        } else if ("triangle".equalsIgnoreCase(shape)) {
            return new Triangle();
        } else {
            throw new Exception("Unknown Shape");
        }
    }

}