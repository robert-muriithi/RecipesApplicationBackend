package dev.robert.recipes.service;

import dev.robert.recipes.model.Recipe;
import dev.robert.recipes.repository.RecipesRepository;
import dev.robert.recipes.utils.EntityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public List<Recipe> getAllRecipes() {
        try {
            return recipeRepo.findAll();
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

    public Recipe updateRecipeName(Long recipeId, String recipeName) {
        try {
            Optional<Recipe> recipe = recipeRepo.findById(recipeId);
            if(recipe.isPresent()) {
                Recipe recipeToUpdate = recipe.get();
                recipeToUpdate.setName(recipeName);
                return recipeRepo.save(recipeToUpdate);
            }
            return null;
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }
}
