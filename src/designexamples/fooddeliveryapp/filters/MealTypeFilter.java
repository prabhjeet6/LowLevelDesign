package designexamples.fooddeliveryapp.filters;

import designexamples.fooddeliveryapp.data.FoodItem;
import designexamples.fooddeliveryapp.data.MealType;
import designexamples.fooddeliveryapp.data.Restaurant;

public class MealTypeFilter implements FoodItemFilter,RestaurantFilter{

    private final MealType mealType;

    public MealTypeFilter(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getMealType().equals(this.mealType);
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getMealType().equals(this.mealType);
    }
}
