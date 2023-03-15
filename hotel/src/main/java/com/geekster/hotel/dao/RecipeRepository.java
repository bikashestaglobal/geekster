package com.geekster.hotel.dao;

import com.geekster.hotel.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    @Query(value = "SELECT * FROM recipe_tbl WHERE user_id=:userId", nativeQuery = true)
    List<Recipe> getAllRecipes(int userId);

    @Query(value = "SELECT * FROM recipe_tbl WHERE id=:recipeId AND user_id=:userId", nativeQuery = true)
    Recipe getRecipeById(int recipeId, int userId);
}
