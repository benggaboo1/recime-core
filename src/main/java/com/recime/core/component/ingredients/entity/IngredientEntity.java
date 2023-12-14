package com.recime.core.component.ingredients.entity;

import com.recime.core.component.common.entity.BaseEntity;
import com.recime.core.component.recipes.entity.RecipeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INGREDIENTS")
public class IngredientEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double quantity;

    private String unit;

    @ManyToOne
    @JoinColumn(name = "RECIPE_ID")
    private RecipeEntity recipe;
}
