package com.ashaselvaraj.foodcatalogue.mapper;

import com.ashaselvaraj.foodcatalogue.dto.FoodItemDTO;
import com.ashaselvaraj.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper Instance = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDtoToFoodItem(FoodItemDTO foodItemDTO);

    FoodItemDTO mapFoodItemtoFoodItemDto(FoodItem foodItem);
}
