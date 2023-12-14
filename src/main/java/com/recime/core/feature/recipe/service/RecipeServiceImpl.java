package com.recime.core.feature.recipe.service;

import com.recime.core.component.recipes.domain.Recipe;
import com.recime.core.component.recipes.gateway.RecipeGateway;
import com.recime.core.constants.Difficulty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeGateway recipeGateway;

    @Override
    public List<Recipe> findAllRecipesByDifficulty(Difficulty difficulty) {
        return recipeGateway.findAllByDifficulty(difficulty);
    }

    @Override
    public List<Recipe> findAllRecipes() {
        return recipeGateway.findAll();
    }
}
