package com.geekster.hotel.controller;

import com.geekster.hotel.dto.RecipeRequest;
import com.geekster.hotel.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // createRecipe
    @PostMapping("")
    public ResponseEntity<Object> createRecipe(@Valid @RequestBody RecipeRequest recipeRequest) throws Exception {
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> errorObj = new HashMap<>();
        Map<Object, Object> serviceResponse = recipeService.createRecipe(recipeRequest);
        if(serviceResponse.containsKey("message")){
            errorObj.put("error", serviceResponse.get("message"));
            resObj.put("status", HttpStatus.BAD_REQUEST);
            resObj.put("message", "Oops Error occurred !");
            resObj.put("error", errorObj);
            return new ResponseEntity<>(resObj, HttpStatus.BAD_REQUEST);
        }else{
            resObj.put("body", serviceResponse.get("body"));
            resObj.put("status", HttpStatus.CREATED);
            resObj.put("message", "Recipe Added Successfully !");
            return new ResponseEntity<>(resObj, HttpStatus.CREATED);
        }
    }

    // getAllRecipes
    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getAllRecipes(@PathVariable(required = true) int userId) throws Exception {
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> errorObj = new HashMap<>();
        Map<Object, Object> serviceResponse = recipeService.getAllRecipe(userId);
        if(serviceResponse.containsKey("message")){
            errorObj.put("error", serviceResponse.get("message"));
            resObj.put("status", HttpStatus.BAD_REQUEST);
            resObj.put("message", "Oops Error occurred !");
            resObj.put("error", errorObj);
            return new ResponseEntity<>(resObj, HttpStatus.BAD_REQUEST);
        }else{
            resObj.put("body", serviceResponse.get("body"));
            resObj.put("status", HttpStatus.OK);
            resObj.put("message", "Recipe Fetched Successfully !");
            return new ResponseEntity<>(resObj, HttpStatus.OK);
        }
    }

    // getRecipeById
    @GetMapping("/user/{userId}/recipe/{recipeId}")
    public ResponseEntity<Object> getRecipeById(@PathVariable(required = true) int recipeId, @PathVariable(required = true) int userId) throws Exception {
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> errorObj = new HashMap<>();
        Map<Object, Object> serviceResponse = recipeService.getRecipeById(recipeId, userId);
        if(serviceResponse.containsKey("message")){
            errorObj.put("error", serviceResponse.get("message"));
            resObj.put("status", HttpStatus.BAD_REQUEST);
            resObj.put("message", "Oops Error occurred !");
            resObj.put("error", errorObj);
            return new ResponseEntity<>(resObj, HttpStatus.BAD_REQUEST);
        }else{
            resObj.put("body", serviceResponse.get("body"));
            resObj.put("status", HttpStatus.OK);
            resObj.put("message", "Recipe Fetched Successfully !");
            return new ResponseEntity<>(resObj, HttpStatus.OK);
        }
    }

    // deleteRecipe
    @DeleteMapping("/user/{userId}/recipe/{recipeId}")
    public ResponseEntity<Object> deleteRecipe(@PathVariable(required = true) int recipeId, @PathVariable(required = true) int userId) throws Exception {
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> errorObj = new HashMap<>();
        Map<Object, Object> serviceResponse = recipeService.deleteRecipe(recipeId, userId);
        if(serviceResponse.containsKey("message")){
            errorObj.put("error", serviceResponse.get("message"));
            resObj.put("status", HttpStatus.BAD_REQUEST);
            resObj.put("message", "Oops Error occurred !");
            resObj.put("error", errorObj);
            return new ResponseEntity<>(resObj, HttpStatus.BAD_REQUEST);
        }else{
            resObj.put("body", serviceResponse.get("body"));
            resObj.put("status", HttpStatus.OK);
            resObj.put("message", "Recipe Deleted Successfully !");
            return new ResponseEntity<>(resObj, HttpStatus.OK);
        }
    }

    // updateRecipe
    @PutMapping("/{recipeId}")
    public ResponseEntity<Object> updateRecipe(@PathVariable(required = true) int recipeId, @Valid @RequestBody RecipeRequest recipeRequest) throws Exception {
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> errorObj = new HashMap<>();
        Map<Object, Object> serviceResponse = recipeService.updateRecipe(recipeId, recipeRequest);
        if(serviceResponse.containsKey("message")){
            errorObj.put("error", serviceResponse.get("message"));
            resObj.put("status", HttpStatus.BAD_REQUEST);
            resObj.put("message", "Oops Error occurred !");
            resObj.put("error", errorObj);
            return new ResponseEntity<>(resObj, HttpStatus.BAD_REQUEST);
        }else{
            resObj.put("body", serviceResponse.get("body"));
            resObj.put("status", HttpStatus.OK);
            resObj.put("message", "Recipe Updated Successfully !");
            return new ResponseEntity<>(resObj, HttpStatus.OK);
        }
    }


}
