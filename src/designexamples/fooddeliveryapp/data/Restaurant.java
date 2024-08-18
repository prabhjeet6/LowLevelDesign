package designexamples.fooddeliveryapp.data;

import java.util.List;

public class Restaurant {
    private final int id;
    private final String name;
    private final String description;
    private  BusinessHours businessHours;
    private final  MealType mealType;
    private final List<CuisineType> cuisineTypes;
    private  StarRating rating;
    private  Menu menu;
    private final Address address;

    public Restaurant(RestaurantBuilder restaurantBuilder){
        this.id=restaurantBuilder.id;
        this.name=restaurantBuilder.name;
        this.description= restaurantBuilder.description;
        this.businessHours=restaurantBuilder.businessHours;
        this.mealType=restaurantBuilder.mealType;
        this.cuisineTypes=restaurantBuilder.cuisineTypes;
        this.rating=restaurantBuilder.rating;
        this.menu=restaurantBuilder.menu;
        this.address = restaurantBuilder.address;
    }

    public Address getAddress() {
        return address;
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

    public BusinessHours getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(BusinessHours businessHours) {
        this.businessHours = businessHours;
    }

    public MealType getMealType() {
        return mealType;
    }

    public List<CuisineType> getCuisineTypes() {
        return cuisineTypes;
    }

    public StarRating getRating() {
        return rating;
    }

    public void setRating(StarRating rating) {
        this.rating = rating;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    private static class RestaurantBuilder{
        private final int id;
        private final String name;
        private final String description;
        private final BusinessHours businessHours;
        private final  MealType mealType;
        private final List<CuisineType> cuisineTypes;
        private final StarRating rating;
        private final Menu menu;
        private final Address address;

        public RestaurantBuilder(int id, String name, String description, BusinessHours businessHours, MealType mealType, List<CuisineType> cuisineTypes, StarRating rating, Menu menu, Address address) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.businessHours = businessHours;
            this.mealType = mealType;
            this.cuisineTypes = cuisineTypes;
            this.rating = rating;
            this.menu = menu;
            this.address = address;
        }

        public Address getAddress() {
            return address;
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

        public BusinessHours getBusinessHours() {
            return businessHours;
        }

        public MealType getMealType() {
            return mealType;
        }

        public List<CuisineType> getCuisineTypes() {
            return cuisineTypes;
        }

        public StarRating getRating() {
            return rating;
        }

        public Menu getMenu() {
            return menu;
        }
        public Restaurant build(){
            return new Restaurant(this);
        }
    }
}
