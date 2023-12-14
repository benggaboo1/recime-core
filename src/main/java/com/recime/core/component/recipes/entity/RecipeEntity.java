package com.recime.core.component.recipes.entity;

import com.recime.core.component.common.entity.BaseEntity;
import com.recime.core.constants.Difficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RECIPES")
public class RecipeEntity extends BaseEntity {

    @Id
    private Long id;

    private String name;

    @Column(name = "VIEW_COUNT")
    private int viewCount;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String imageUrl;

}
