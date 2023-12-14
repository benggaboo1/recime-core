package com.recime.core.component.recipes.domain;

import com.recime.core.constants.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    private Long id;
    private String name;
    private int position;
    private Difficulty difficulty;
    private String imageUrl;
}
