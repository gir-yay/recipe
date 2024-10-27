package com.app.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.recipe.model.Recipe;
import com.app.recipe.model.User;

import com.app.recipe.service.RecipeService;
import com.app.recipe.service.UserService;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/recipe/user/{userId}")
    public Recipe createRecipe(@RequestBody Recipe recipe,  @PathVariable Long userId) throws Exception{
        User user =  userService.findUserById(userId);
        Recipe createdRecipe = recipeService.creatRecipe(recipe, user);
        return createdRecipe;
    }
    
    @GetMapping("/api/recipe")
    public List<Recipe> getAllRecipe(){
       List<Recipe> recipes = recipeService.findAllRecipe();
       return recipes;
    }

    @DeleteMapping("/api/recipe/{recipeId}")
    public String deleteRecipe( @PathVariable Long recipeId) throws Exception{

        recipeService.deleteRecipe(recipeId);
        return "Recipe deleted successfully";

    }

    @PutMapping("/api/recipe/{recipeId}")
    public Recipe updateRecipe(@RequestBody Recipe recipe,  @PathVariable Long recipeId) throws Exception{

        Recipe uodatedRecipe =  recipeService.updateRecipe(recipe, recipeId);
        return uodatedRecipe;
    }
 
    @PutMapping("/api/recipe/{recipeId}/user/userId")
    public Recipe updateRecipe(@PathVariable Long recipeId, @PathVariable Long userId) throws Exception{
        User user = userService.findUserById(userId);
        Recipe likeedRecipe =  recipeService.likeRecipe(recipeId, user );
        return likeedRecipe;
    }
    
}
