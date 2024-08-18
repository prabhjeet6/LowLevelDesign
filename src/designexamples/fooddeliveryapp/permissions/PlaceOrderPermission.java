package designexamples.fooddeliveryapp.permissions;

import designexamples.fooddeliveryapp.data.Restaurant;
import designexamples.fooddeliveryapp.data.User;
import designexamples.fooddeliveryapp.manager.DeliveryManager;

public class PlaceOrderPermission implements Permission {

    private final User user;
    private final Restaurant restaurant;

    public PlaceOrderPermission(User user, Restaurant restaurant) {
        this.user = user;
        this.restaurant = restaurant;
    }

    @Override
    public boolean isPermitted() {
        return DeliveryManager.isDeliverPossible(user.getAddress(),restaurant.getAddress());
    }
}