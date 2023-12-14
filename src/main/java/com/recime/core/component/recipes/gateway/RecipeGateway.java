package com.recime.core.component.recipes.gateway;

import com.recime.core.component.recipes.domain.Recipe;
import com.recime.core.constants.Difficulty;

import java.util.List;

public interface RecipeGateway {

    List<Recipe> findAllByDifficulty(Difficulty difficulty);

    List<Recipe> findAll();
}
