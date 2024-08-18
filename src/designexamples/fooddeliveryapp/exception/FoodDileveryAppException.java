package designexamples.fooddeliveryapp.exception;

public class FoodDileveryAppException extends Exception{
    FoodDileveryAppException(Exception exception){
        System.err.println(exception.getLocalizedMessage());
    }
    public FoodDileveryAppException(String message){
        System.err.println(message);
    }
}
