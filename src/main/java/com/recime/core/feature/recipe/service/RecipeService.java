package com.recime.core.feature.recipe.service;

import com.recime.core.component.recipes.domain.Recipe;
import com.recime.core.constants.Difficulty;

import java.util.List;

public interface RecipeService {

    public List<Recipe> findAllRecipesByDifficulty(Difficulty difficulty);
    public List<Recipe> findAllRecipes();
}
