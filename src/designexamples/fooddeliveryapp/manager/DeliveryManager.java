package designexamples.fooddeliveryapp.manager;

import designexamples.fooddeliveryapp.data.Address;

public class DeliveryManager {
    public static boolean isDeliverPossible(Address userAddress, Address restaurantAddress) {
        return userAddress.getCity().equalsIgnoreCase(restaurantAddress.getCity()) &&
                userAddress.getState().equalsIgnoreCase(restaurantAddress.getState()) &&
                userAddress.getCountry().equalsIgnoreCase(restaurantAddress.getCountry());
    }

}
