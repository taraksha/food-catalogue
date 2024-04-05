package com.ashaselvaraj.foodcatalogue.dto;

import com.ashaselvaraj.foodcatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {
    // Displays Restaurant Details along with Food Listing
    private List<FoodItem> foodItemList;
    private RestaurantDTO restaurant;

}
