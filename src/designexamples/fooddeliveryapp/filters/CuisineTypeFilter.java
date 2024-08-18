package designexamples.fooddeliveryapp.filters;

import designexamples.fooddeliveryapp.data.CuisineType;
import designexamples.fooddeliveryapp.data.FoodItem;
import designexamples.fooddeliveryapp.data.Restaurant;

import java.util.List;

public class CuisineTypeFilter implements FoodItemFilter, RestaurantFilter {

    private final List<CuisineType> cuisineTypes;

    public CuisineTypeFilter(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return cuisineTypes.contains(foodItem.getCuisineType());
    }

    @Override
    public boolean filter(Restaurant restaurant) {

        long cuisinesAvailableInRestaurant = restaurant.getCuisineTypes().stream().filter(this.cuisineTypes::contains).count();
        return cuisinesAvailableInRestaurant != 0;
    }
}
