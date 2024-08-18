package designexamples.fooddeliveryapp.filters;

import designexamples.fooddeliveryapp.data.Restaurant;

public interface RestaurantFilter {

    boolean filter(Restaurant restaurant);
}
