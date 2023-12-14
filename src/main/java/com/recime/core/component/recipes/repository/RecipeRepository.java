package com.recime.core.component.recipes.repository;

import com.recime.core.component.recipes.entity.RecipeEntity;
import com.recime.core.constants.Difficulty;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RecipeRepository extends Repository<RecipeEntity, Long> {

    List<RecipeEntity> findAllByDifficultyOrderByViewCountDesc(Difficulty difficulty);
    List<RecipeEntity> findAllByOrderByViewCountDesc();
}
