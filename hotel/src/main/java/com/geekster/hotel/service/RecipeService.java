package com.geekster.hotel.service;

import com.geekster.hotel.dao.RecipeRepository;
import com.geekster.hotel.dao.UserRepository;
import com.geekster.hotel.dto.RecipeRequest;
import com.geekster.hotel.model.Recipe;
import com.geekster.hotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    // createRecipe
    public Map<Object, Object> createRecipe(RecipeRequest recipeRequest) throws Exception{
        Map<Object, Object> resMap = new HashMap();
        Boolean existUser = userRepository.findById(recipeRequest.getUserId()).isPresent();
        if(existUser != null){
            User user = userRepository.findById(recipeRequest.getUserId()).get();
            Recipe recipe = Recipe.build(null,recipeRequest.getName(),recipeRequest.getIngredients(), recipeRequest.getInstructions(), user,null,null);
            Recipe savedRecipe = recipeRepository.save(recipe);
            user.setPassword(null);
            savedRecipe.setUser(user);
            resMap.put("body", savedRecipe);
        }else{
            resMap.put("message", "User Id doesn't exists");
        }
        return resMap;
    }


    // getAllRecipe
    public Map<Object, Object> getAllRecipe(int userId) throws Exception{
        Map<Object, Object> resMap = new HashMap();
        boolean existUser = userRepository.findById(userId).isPresent();
        if(existUser){
            List<Recipe> recipeList = recipeRepository.getAllRecipes(userId);
            resMap.put("body", recipeList);
        }
        else{
            resMap.put("message", "User Doesn't Exists");
        }
        return resMap;
    }


    // getRecipeById
    public Map<Object, Object> getRecipeById(int recipeId, int userId) throws Exception{
        Map<Object, Object> resMap = new HashMap();
        boolean isExists = recipeRepository.findById(recipeId).isPresent();
        if(isExists){
            Recipe recipe =  recipeRepository.findById(recipeId).get();
            if(recipe.getUser().getId() == userId){
                resMap.put("body", recipe);
            }else{
                resMap.put("message", "You can't access to this recipe");
            }
        }else{
            resMap.put("message", "Recipe doesn't exists");
        }
        return resMap;
    }

    // deleteRecipe
    public Map<Object, Object> deleteRecipe(int recipeId, int userId) throws Exception{
        Map<Object, Object> resMap = new HashMap();
        boolean isExists = recipeRepository.findById(recipeId).isPresent();
        if(isExists){
            Recipe recipe =  recipeRepository.findById(recipeId).get();
            if(recipe.getUser().getId() == userId){
                recipeRepository.deleteById(recipeId);
                resMap.put("body", recipe);
            }else{
                resMap.put("message", "You can't delete to this recipe");
            }
        }else{
            resMap.put("message", "Recipe doesn't exists");
        }
        return resMap;
    }

    // updateRecipe
    public Map<Object, Object> updateRecipe(int recipeId, RecipeRequest recipeRequest) throws Exception{
        Map<Object, Object> resMap = new HashMap();
        boolean isExists = recipeRepository.findById(recipeId).isPresent();
        if(isExists){
            Recipe recipe =  recipeRepository.findById(recipeId).get();
            if(recipe.getUser().getId() == recipeRequest.getUserId()){
                // update recipe
                recipe.setName(recipeRequest.getName());
                recipe.setIngredients(recipeRequest.getIngredients());
                recipe.setInstructions(recipeRequest.getInstructions());
                Recipe upadetdRecipe = recipeRepository.save(recipe);
                resMap.put("body", upadetdRecipe);
            }else{
                resMap.put("message", "You can't update to this recipe");
            }
        }else{
            resMap.put("message", "Recipe doesn't exists");
        }
        return resMap;
    }


}
