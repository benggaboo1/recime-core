package com.recime.core.feature.recipe.service;

import com.recime.core.RecimeCoreApplicationTests;
import com.recime.core.component.recipes.domain.Recipe;
import com.recime.core.component.recipes.gateway.RecipeGateway;
import com.recime.core.constants.Difficulty;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = RecimeCoreApplicationTests.class)
public class RecipeServiceImplTest {

    @Autowired
    private RecipeService recipeService;

    @Mock
    private RecipeGateway recipeGateway;

    @Before
    public void setUp() throws Exception {
        recipeService = new RecipeServiceImpl(recipeGateway);

        List<Recipe> hardRecipes = new ArrayList<>() {
            {
                add(new Recipe(1L, "Bacon Burger", 1, Difficulty.HARD, "imgUrl"));
            }
        };

        List<Recipe> easyRecipes = new ArrayList<>() {
            {
                add(new Recipe(2L, "Wagyu Burger", 15, Difficulty.EASY, "imgUrl"));
                add(new Recipe(2L, "Chicken Burger", 3, Difficulty.EASY, "imgUrl"));
            }
        };

        List<Recipe> allRecipes = new ArrayList<>();
        allRecipes.addAll(easyRecipes);
        allRecipes.addAll(hardRecipes);

        when(recipeGateway.findAllByDifficulty(Difficulty.HARD)).thenReturn(hardRecipes);
        when(recipeGateway.findAllByDifficulty(Difficulty.EASY)).thenReturn(easyRecipes);
        when(recipeGateway.findAll()).thenReturn(allRecipes);
    }

    @Test
    public void givenDifficulty_whenFindAllRecipesByDifficulty_thenReturnRecipes() {

        List<Recipe> hardRecipes = recipeService.findAllRecipesByDifficulty(Difficulty.HARD);
        assertThat(hardRecipes).isNotNull();
        assertThat(hardRecipes.size()).isEqualTo(1);
        assertThat(hardRecipes.get(0).getName()).isEqualTo("Bacon Burger");

        List<Recipe> easyRecipes = recipeService.findAllRecipesByDifficulty(Difficulty.EASY);
        assertThat(easyRecipes).isNotNull();
        assertThat(easyRecipes.size()).isEqualTo(2);
        assertThat(easyRecipes.get(0).getName()).isEqualTo("Wagyu Burger");

    }

    @Test
    public void whenFindAllRecipes_thenReturnRecipes() {
        List<Recipe> recipes = recipeService.findAllRecipes();
        assertThat(recipes).isNotNull();
        assertThat(recipes.get(0))
                .isEqualTo(recipes.stream().max(Comparator.comparing(Recipe::getPosition)).get());
    }

}
