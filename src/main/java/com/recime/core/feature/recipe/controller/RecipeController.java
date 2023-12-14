package com.recime.core.feature.recipe.controller;

import com.recime.core.component.recipes.domain.Recipe;
import com.recime.core.constants.Difficulty;
import com.recime.core.feature.recipe.service.RecipeService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping(path = "/trending/filter")
    public List<Recipe> getAllTrendingRecipesByDifficulty(@RequestParam("difficulty")
                                          @NotNull Difficulty difficulty) {
        return recipeService.findAllRecipesByDifficulty(difficulty);
    }

    @GetMapping(path = "/trending")
    public List<Recipe> getAllTrendingRecipes() {
        return recipeService.findAllRecipes();
    }
}
