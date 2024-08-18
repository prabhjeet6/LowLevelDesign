package designexamples.fooddeliveryapp.filters;

import designexamples.fooddeliveryapp.data.FoodItem;
import designexamples.fooddeliveryapp.data.Restaurant;
import designexamples.fooddeliveryapp.data.StarRating;

public class StarRatingFilter implements RestaurantFilter,FoodItemFilter {

    private final StarRating starRating;

    public StarRatingFilter(StarRating starRating) {
        this.starRating = starRating;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getStarRating().getVal()>=starRating.getVal();
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getRating().getVal()>= starRating.getVal();
    }
}
