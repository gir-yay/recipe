package com.app.recipe.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.recipe.model.Recipe;
import com.app.recipe.model.User;
import com.app.recipe.repository.RecipeRepository;

@Service
public class RecipeServiceImp implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe creatRecipe(Recipe recipe, User user) {
        Recipe createdRecipe = new Recipe();
        createdRecipe.setTitle(recipe.getTitle());
        createdRecipe.setDescription(recipe.getDescription());
        createdRecipe.setImage(recipe.getImage());
        createdRecipe.setUser(user);
        createdRecipe.setVegetarian(recipe.isVegetarian());
        createdRecipe.setCreatedAt(LocalDateTime.now());
       
        return recipeRepository.save(createdRecipe);
    }

    @Override
    public Recipe findRecipeById(Long id) throws Exception {

        Optional<Recipe> opt = recipeRepository.findById(id);

        if(opt.isPresent()){
            return opt.get();
        }

       throw new Exception("Recipe not found");
    }

    @Override
    public void deleteRecipe(Long id) throws Exception {
       findRecipeById(id);
       recipeRepository.deleteById(id);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe, Long id) throws Exception {
       Recipe oldRecipe =  findRecipeById(id);
       if (recipe.getTitle() != null){
            oldRecipe.setTitle(recipe.getTitle());
       }

       if (recipe.getDescription() != null){
        oldRecipe.setDescription(recipe.getDescription());
    }
       
        if (recipe.getImage() != null){
            oldRecipe.setImage(recipe.getImage());
       }

       return recipeRepository.save(oldRecipe);
    }

    @Override
    public List<Recipe> findAllRecipe() {

        return recipeRepository.findAll();
       
    }

    @Override
    public Recipe likeRecipe(Long id, User user) throws Exception {

        Recipe recipe = findRecipeById(id);
        if(recipe.getLikes().contains(user.getId()))
        {
            recipe.getLikes().remove(user.getId());
        }else{
            recipe.getLikes().add(user.getId());
        }
       
        return null;
    }


    


}
