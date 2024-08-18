package designexamples.fooddeliveryapp.manager;

import designexamples.fooddeliveryapp.data.CartItem;
import designexamples.fooddeliveryapp.data.FoodItem;
import designexamples.fooddeliveryapp.data.Restaurant;
import designexamples.fooddeliveryapp.data.User;
import designexamples.fooddeliveryapp.exception.FoodDileveryAppException;
import designexamples.fooddeliveryapp.permissions.Permission;
import designexamples.fooddeliveryapp.factory.PermissionFactory;
import designexamples.fooddeliveryapp.searchers.RestaurantSearcher;

import java.util.List;

public class CartManager {

    public List<CartItem> getUserCart(User user) {
        //TODO: fetch results from DB
        return null;
    }

    // adds 1 unit
    public void addItemToCart(User user, FoodItem foodItem) throws FoodDileveryAppException {
        validateFoodItemAddedFromSameRestaurant(user, foodItem);
        Permission permission = PermissionFactory.getAddToCartPermission(user, foodItem);
        validatePermission(permission);

        //TODO: add CartItems in runtime memory as well as DB
        //Storing CartItems in DB makes sure, whenever user logs in from another device,
        // not-checked out items will be visible in the cart
    }


    public void deleteItemFromCart(User user, FoodItem foodItem) throws FoodDileveryAppException {
        Permission permission = PermissionFactory.getDeleteFromCartPermission(user, foodItem);
        validatePermission(permission);
        validateIfFoodItemPresentInCart(user, foodItem);
        //TODO: add CartItems in runtime memory as well as DB
        //Storing CartItems in DB makes sure, whenever user logs in from another device,
        // not-checked out items will be visible in the cart

    }


    public void checkOutUserCart(User user) throws FoodDileveryAppException {
        Permission permission = PermissionFactory.getCheckoutCartPermission(user);
        validatePermission(permission);
        validateIfCartIsEmpty(user);
        //TODO: add CartItems in runtime memory as well as DB
        //Storing CartItems in DB makes sure, whenever user logs in from another device,
        // not-checked out items will be visible in the cart
    }

    private void validateIfCartIsEmpty(User user) throws FoodDileveryAppException {
        if (isCartEmpty(user))
            throw new FoodDileveryAppException("Cart is empty");
    }


    private void validateIfFoodItemPresentInCart(User user, FoodItem foodItem) throws FoodDileveryAppException {
        if (!isFoodItemPresentInCart(user, foodItem))
            throw new FoodDileveryAppException("FoodItem is not present in the Cart");
    }

    private void validateFoodItemAddedFromSameRestaurant(User user, FoodItem foodItem) throws FoodDileveryAppException {
        if (!isFoodItemFromSameRestaurant(user, foodItem))
            throw new FoodDileveryAppException("Adding FoodItem from multiple restaurants not allowed");
    }

    private void validatePermission(Permission permission) throws FoodDileveryAppException {
        if (!permission.isPermitted()) {
            throw new FoodDileveryAppException("Permission Denied");
        }
    }

    private boolean isFoodItemFromSameRestaurant(User user, FoodItem foodItem) {
        List<CartItem> cartItems = getUserCart(user);
        return cartItems.isEmpty() || (cartItems.getFirst().getFoodItem().getRestaurantId() == foodItem.getRestaurantId());
    }

    private boolean isFoodItemPresentInCart(User user, FoodItem foodItem) {
        List<CartItem> cartItems = getUserCart(user);
        for (CartItem item : cartItems) {
            if (item.getFoodItem().getId() == foodItem.getId())
                return true;
        }
        return false;
    }

    private boolean isCartEmpty(User user) {
        List<CartItem> cartItems = getUserCart(user);
        return cartItems.isEmpty();
    }


}
