package com.recime.core.component.ingredients.gateway;

import com.recime.core.component.ingredients.domain.Ingredient;
import com.recime.core.component.ingredients.mapper.IngredientGatewayMapper;
import com.recime.core.component.ingredients.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientGatewayImpl implements IngredientGateway {

    private final IngredientRepository ingredientRepository;
    private final IngredientGatewayMapper mapper;

    @Override
    public List<Ingredient> findAllByRecipe(Long recipeId) {
        return mapper.map(ingredientRepository.findAllByRecipe_Id(recipeId));
    }
}
