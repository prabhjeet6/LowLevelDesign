package designexamples.fooddeliveryapp.permissions;

import designexamples.fooddeliveryapp.data.FoodItem;
import designexamples.fooddeliveryapp.data.User;

public class AddToCartPermission implements Permission {
    private final User user;
    private final FoodItem foodItem;

    public AddToCartPermission(User user, FoodItem foodItem) {
        this.user = user;
        this.foodItem = foodItem;
    }

    @Override
    public boolean isPermitted() {
        //check if user is authorised
        return false;
    }
}
