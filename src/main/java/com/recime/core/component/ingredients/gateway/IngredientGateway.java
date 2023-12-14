package com.recime.core.component.ingredients.gateway;

import com.recime.core.component.ingredients.domain.Ingredient;

import java.util.List;

public interface IngredientGateway {

    List<Ingredient> findAllByRecipe(Long recipeId);
}
