package com.app.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.recipe.model.Recipe;
import com.app.recipe.model.User;

import com.app.recipe.service.RecipeService;
import com.app.recipe.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public Recipe createRecipe(@RequestBody Recipe recipe,  @RequestHeader("Authorization") String jwt) throws Exception{
        User user =  userService.findUserByJwt(jwt);
        Recipe createdRecipe = recipeService.creatRecipe(recipe, user);
        return createdRecipe;
    }
    
    @GetMapping()
    public List<Recipe> getAllRecipe(){
       List<Recipe> recipes = recipeService.findAllRecipe();
       return recipes;
    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe( @PathVariable Long recipeId) throws Exception{

        recipeService.deleteRecipe(recipeId);
        return "Recipe deleted successfully";

    }

    @PutMapping("/{recipeId}")
    public Recipe updateRecipe(@RequestBody Recipe recipe,  @PathVariable Long recipeId) throws Exception{

        Recipe uodatedRecipe =  recipeService.updateRecipe(recipe, recipeId);
        return uodatedRecipe;
    }
 
    @PutMapping("/{recipeId}/like")
    public Recipe likeRecipe(@RequestHeader("Authorization") String jwt, @PathVariable Long recipeId) throws Exception{
        User user = userService.findUserByJwt(jwt);
        Recipe likedRecipe =  recipeService.likeRecipe(recipeId, user );
        return likedRecipe;
    }
    
}
