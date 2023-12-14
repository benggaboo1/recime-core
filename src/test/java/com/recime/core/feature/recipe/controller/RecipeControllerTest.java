package com.recime.core.feature.recipe.controller;

import com.recime.core.RecimeCoreApplication;
import com.recime.core.RecimeCoreApplicationTests;
import com.recime.core.common.WebConfig;
import com.recime.core.feature.recipe.service.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.recime.core.constants.RecimeConstants.MISSING_DIFFICULTY_PARAM;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = RecimeCoreApplication.class)
@AutoConfigureMockMvc
public class RecipeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenDifficulty_whenGetAllTrendingRecipesByDifficulty_thenStatus200() throws Exception {
        mvc.perform(get("/v1/recipes/trending/filter").queryParam("difficulty", "hard")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void givenInvalidDifficulty_whenGetAllTrendingRecipesByDifficulty_thenStatus400() throws Exception {
        mvc.perform(get("/v1/recipes/trending/filter").queryParam("difficulty", "normal")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void givenNullDifficulty_whenGetAllTrendingRecipesByDifficulty_thenStatus400() throws Exception {
        mvc.perform(get("/v1/recipes/trending/filter")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(MISSING_DIFFICULTY_PARAM));
    }

    @Test
    public void whenGetAllTrendingRecipes_thenStatus200() throws Exception {
        mvc.perform(get("/v1/recipes/trending")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
