package designexamples.fooddeliveryapp.filters;

import designexamples.fooddeliveryapp.data.FoodItem;

public interface FoodItemFilter {
    boolean filter(FoodItem foodItem);
}
