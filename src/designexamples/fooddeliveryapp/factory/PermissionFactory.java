package designexamples.fooddeliveryapp.factory;

import designexamples.fooddeliveryapp.data.*;
import designexamples.fooddeliveryapp.permissions.*;

public class PermissionFactory {
    private PermissionFactory() {}

    public static Permission getAddToCartPermission(User user, FoodItem foodItem) {
        return new AddToCartPermission(user, foodItem);
    }

    public static Permission getDeleteFromCartPermission(User user, FoodItem foodItem) {
        return new DeleteFromCartPermission(user, foodItem);
    }

    public static Permission getCheckoutCartPermission(User user) {
        return new CheckoutCartPermission(user);
    }

    public static Permission getPlaceOrderPermission(User user,Restaurant restaurant) {
        return new PlaceOrderPermission(user,restaurant);
    }

    public static Permission getUpdateOrderPermission(User user, Order order, OrderStatus orderStatus) {
        return new UpdateOrderPermission(user, order, orderStatus);
    }

}
