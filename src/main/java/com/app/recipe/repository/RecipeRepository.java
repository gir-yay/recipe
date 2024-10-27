package com.app.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.recipe.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe , Long> {

}
