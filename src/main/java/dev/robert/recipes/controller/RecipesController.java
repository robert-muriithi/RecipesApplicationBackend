package dev.robert.recipes.controller;

import dev.robert.recipes.model.Recipe;
import dev.robert.recipes.service.RecipesService;
import dev.robert.recipes.utils.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipes/")
public class RecipesController {

    @Autowired
    private RecipesService recipeService;

    @PostMapping("add")
    public ResponseEntity<EntityResponse<Recipe>> addRecipe(@RequestBody Recipe recipe) {
        EntityResponse<Recipe> entityResponse = new EntityResponse<>();
        try {
            Recipe savedRecipe = recipeService.addRecipe(recipe);
            entityResponse.setMessage("Recipe added");
            entityResponse.setStatusCode(HttpStatus.CREATED.value());
            entityResponse.setPayload(savedRecipe);
            return new ResponseEntity<>(entityResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            entityResponse.setMessage(e.getMessage());
            entityResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            entityResponse.setPayload(null);
            return new ResponseEntity<>(entityResponse, HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("all")
    public ResponseEntity<EntityResponse<?>> getAllRecipes() {
        EntityResponse<List<Recipe>> entityResponse = new EntityResponse<>();
        try {
            List<Recipe> recipes = recipeService.getAllRecipes();
            entityResponse.setMessage("Recipes fetched");
            entityResponse.setStatusCode(HttpStatus.OK.value());
            entityResponse.setPayload(recipes);
            return new ResponseEntity<>(entityResponse, HttpStatus.OK);
        } catch (Exception e) {
            entityResponse.setMessage(e.getMessage());
            entityResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            entityResponse.setPayload(null);
            return new ResponseEntity<>(entityResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
