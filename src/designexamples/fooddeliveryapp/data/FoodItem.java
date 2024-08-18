package designexamples.fooddeliveryapp.data;

public class FoodItem {
    private final int id;
    private final String name;
    private final String description;
    private final double priceINR;
    private final MealType mealType;
    private final CuisineType cuisineType;
    private  StarRating starRating;
    private final int restaurantId;
    private  boolean isAvailable;

    public FoodItem(FoodItemBuilder foodItemBuilder){
        this.id=foodItemBuilder.id;
        this.name=foodItemBuilder.name;
        this.description=foodItemBuilder.description;
        this.priceINR=foodItemBuilder.priceINR;
        this.mealType=foodItemBuilder.mealType;
        this.cuisineType=foodItemBuilder.cuisineType;
        this.starRating=foodItemBuilder.starRating;
        this.restaurantId=foodItemBuilder.restaurantId;
        this.isAvailable=foodItemBuilder.isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPriceINR() {
        return priceINR;
    }

    public MealType getMealType() {
        return mealType;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    private static class FoodItemBuilder{
        private final int id;
        private final String name;
        private final String description;
        private final double priceINR;
        private final MealType mealType;
        private final CuisineType cuisineType;
        private  StarRating starRating;
        private final int restaurantId;
        private  boolean isAvailable;

        public FoodItemBuilder(int id, String name, String description, double priceINR, MealType mealType, CuisineType cuisineType, StarRating starRating, int restaurantId, boolean isAvailable) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.priceINR = priceINR;
            this.mealType = mealType;
            this.cuisineType = cuisineType;
            this.starRating = starRating;
            this.restaurantId = restaurantId;
            this.isAvailable = isAvailable;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public double getPriceINR() {
            return priceINR;
        }

        public MealType getMealType() {
            return mealType;
        }

        public CuisineType getCuisineType() {
            return cuisineType;
        }

        public StarRating getStarRating() {
            return starRating;
        }

        public void setStarRating(StarRating starRating) {
            this.starRating = starRating;
        }

        public int getRestaurantId() {
            return restaurantId;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }

        FoodItem build(){
            return new FoodItem(this);
        }

    }



}
