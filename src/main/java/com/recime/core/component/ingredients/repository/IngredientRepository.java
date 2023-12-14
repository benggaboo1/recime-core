package com.recime.core.component.ingredients.repository;

import com.recime.core.component.ingredients.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

    List<IngredientEntity> findAllByRecipe_Id(Long id);
}

