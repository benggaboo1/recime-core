package com.recime.core.feature.ingredient.service;

import com.recime.core.component.ingredients.domain.Ingredient;

import java.util.List;

public interface IngredientService {

    public List<Ingredient> findAllIngredientsOfRecipe(Long recipeId);
}
