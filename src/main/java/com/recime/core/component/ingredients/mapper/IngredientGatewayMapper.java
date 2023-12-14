package com.recime.core.component.ingredients.mapper;

import com.recime.core.component.ingredients.domain.Ingredient;
import com.recime.core.component.ingredients.entity.IngredientEntity;
import com.recime.core.component.recipes.domain.Recipe;
import com.recime.core.component.recipes.entity.RecipeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientGatewayMapper {

    List<Ingredient> map(List<IngredientEntity> entities);

    Ingredient map(IngredientEntity entity);
}
