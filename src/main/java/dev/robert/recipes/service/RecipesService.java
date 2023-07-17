package dev.robert.recipes.service;

import dev.robert.recipes.model.Recipe;
import dev.robert.recipes.repository.RecipesRepository;
import dev.robert.recipes.utils.EntityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RecipesService {

    @Autowired
    private RecipesRepository recipeRepo;


    public Recipe addRecipe(Recipe recipe) {
        try {
            return recipeRepo.save(recipe);
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

    /*public EntityResponse addRecipe(Recipe recipe) {
        EntityResponse<Recipe> entityResponse = new EntityResponse<>();
        try {
            Recipe savedRecipe = recipeRepo.save(recipe);
            entityResponse.setMessage("Recipe added");
            entityResponse.setStatusCode(HttpStatus.CREATED.value());
            entityResponse.setPayload(savedRecipe);
            return entityResponse;
        } catch (Exception e) {
            entityResponse.setMessage(e.getMessage());
            entityResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            entityResponse.setPayload(null);
        }
        return entityResponse;
    }*/

    public List<Recipe> getAllRecipes() {
        try {
            return recipeRepo.findAll();
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }
}
