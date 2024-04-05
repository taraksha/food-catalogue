package com.ashaselvaraj.foodcatalogue.service;

import com.ashaselvaraj.foodcatalogue.dto.FoodCataloguePage;
import com.ashaselvaraj.foodcatalogue.dto.FoodItemDTO;
import com.ashaselvaraj.foodcatalogue.dto.RestaurantDTO;
import com.ashaselvaraj.foodcatalogue.entity.FoodItem;
import com.ashaselvaraj.foodcatalogue.mapper.FoodItemMapper;
import com.ashaselvaraj.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    FoodItemRepo foodItemRepo;
    RestTemplate restTemplate;

    @Autowired
    public void setFoodItemRepo(FoodItemRepo foodItemRepo) {
        this.foodItemRepo = foodItemRepo;
    }
    @Autowired
     private void setRestTemplate(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
      FoodItem foodItem = foodItemRepo.save(FoodItemMapper.Instance.mapFoodItemDtoToFoodItem(foodItemDTO));
      return FoodItemMapper.Instance.mapFoodItemtoFoodItemDto(foodItem);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        //Fetch food items List
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        //Restaurant Details
        RestaurantDTO restaurantDTO = fetchRestaurantDetailsFromRestaurantsMS(restaurantId);
        return  createFoodCataloguePage(foodItemList,restaurantDTO);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, RestaurantDTO restaurantDTO) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurant(restaurantDTO);
        return foodCataloguePage;
    }

    private RestaurantDTO fetchRestaurantDetailsFromRestaurantsMS(Integer restaurantId) {
        return restTemplate.getForObject("http://Restaurant-Service/restaurant/fetchRestaurantById/"+restaurantId, RestaurantDTO.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }
}
