package com.ashaselvaraj.foodcatalogue.controller;

import com.ashaselvaraj.foodcatalogue.dto.FoodCataloguePage;
import com.ashaselvaraj.foodcatalogue.dto.FoodItemDTO;
import com.ashaselvaraj.foodcatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodCatalogueController {

    FoodCatalogueService foodCatalogueService;
    @Autowired
    public FoodCatalogueController(FoodCatalogueService foodCatalogueService) {
        this.foodCatalogueService=foodCatalogueService;
    }

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO savedFoodItemDTO =foodCatalogueService.addFoodItem(foodItemDTO);
        return  new ResponseEntity<>(savedFoodItemDTO, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantDetailsWithFoodList(@PathVariable Integer restaurantId){
        FoodCataloguePage foodCataloguePage = foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId);
        return new ResponseEntity<>(foodCataloguePage,HttpStatus.OK);
    }
}
