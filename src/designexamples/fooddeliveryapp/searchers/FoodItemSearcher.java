package designexamples.fooddeliveryapp.searchers;

import designexamples.fooddeliveryapp.data.FoodItem;
import designexamples.fooddeliveryapp.exception.FoodDileveryAppException;
import designexamples.fooddeliveryapp.filters.FoodItemFilter;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcher {

    public List<FoodItem> search(String foodItemName, List<FoodItemFilter> filters) throws FoodDileveryAppException {
        validateInput(foodItemName,filters);
        //TODO: perform DAO operations to fetch List of foodItems

        List<FoodItem> foodItems=new ArrayList<>();
        for(FoodItemFilter filter:filters){
            List<FoodItem> filteredFoodItems = new ArrayList<>();
            for (FoodItem foodItem : foodItems) {
                if (filter.filter(foodItem))
                    filteredFoodItems.add(foodItem);
            }
            foodItems = filteredFoodItems;
        }

        return foodItems;
    }
    private void validateInput(String foodItemName,List<FoodItemFilter> filters) throws FoodDileveryAppException {
      if(null==foodItemName|| foodItemName.isEmpty()||null== filters){
       throw new FoodDileveryAppException("FoodItem Search input is invalid");
      }
    }

}
