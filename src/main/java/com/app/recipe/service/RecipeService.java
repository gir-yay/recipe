package com.app.recipe.service;

import com.app.recipe.model.Recipe;
import com.app.recipe.model.User;
import java.util.List;

public interface RecipeService {

    public Recipe creatRecipe(Recipe recipe , User user);
    public Recipe findRecipeById(Long id) throws Exception;
    public void deleteRecipe(Long id) throws Exception;
    public Recipe updateRecipe(Recipe recipe , Long id) throws Exception;
    public List<Recipe> findAllRecipe();
    public Recipe likeRecipe(Long id, User user) throws Exception;

}
