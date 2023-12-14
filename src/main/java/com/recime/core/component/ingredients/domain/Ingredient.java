package com.recime.core.component.ingredients.domain;

import com.recime.core.component.common.entity.BaseEntity;
import com.recime.core.component.recipes.domain.Recipe;
import com.recime.core.component.recipes.entity.RecipeEntity;
import lombok.Data;

@Data
public class Ingredient {

    private Long id;
    private String name;
    private double quantity;
    private String unit;
}
