package com.recime.core.component.recipes.gateway;

import com.recime.core.component.recipes.domain.Recipe;
import com.recime.core.component.recipes.mapper.RecipeGatewayMapper;
import com.recime.core.component.recipes.repository.RecipeRepository;
import com.recime.core.constants.Difficulty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeGatewayImpl implements RecipeGateway {

    private final RecipeRepository recipeRepository;
    private final RecipeGatewayMapper mapper;

    @Override
    public List<Recipe> findAllByDifficulty(Difficulty difficulty) {
        return mapper.map(recipeRepository.findAllByDifficultyOrderByViewCountDesc(difficulty));
    }

    @Override
    public List<Recipe> findAll() {
        return mapper.map(recipeRepository.findAllByOrderByViewCountDesc());
    }
}
