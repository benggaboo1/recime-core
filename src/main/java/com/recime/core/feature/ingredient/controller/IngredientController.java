package com.recime.core.feature.ingredient.controller;

import com.recime.core.component.ingredients.domain.Ingredient;
import com.recime.core.feature.ingredient.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping(path = "/recipes/{id:[\\d]+}")
    public List<Ingredient> getAllIngredients(@PathVariable("id") Long id) {
        return ingredientService.findAllIngredientsOfRecipe(id);
    }
}
