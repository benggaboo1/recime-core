package com.recime.core.component.recipes.mapper;

import com.recime.core.component.recipes.domain.Recipe;
import com.recime.core.component.recipes.entity.RecipeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeGatewayMapper {

    List<Recipe> map(List<RecipeEntity> entities);
    @Mapping(target = "position", source = "entity.viewCount")
    Recipe map(RecipeEntity entity);
}
