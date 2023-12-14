package com.recime.core.feature.ingredient.service;

import com.recime.core.component.ingredients.domain.Ingredient;
import com.recime.core.component.ingredients.gateway.IngredientGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientGateway ingredientGateway;

    @Override
    public List<Ingredient> findAllIngredientsOfRecipe(Long recipeId) {
        return ingredientGateway.findAllByRecipe(recipeId);
    }
}
