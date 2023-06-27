package dev.robert.recipes.controller

import dev.robert.recipes.model.Recipe
import dev.robert.recipes.repository.RecipesRepository
import dev.robert.recipes.service.RecipesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("api/v1/recipes")
@CrossOrigin("*")
class RecipesController(@Autowired private val recipeService: RecipesService) {

    @PostMapping("/add")
    fun addRecipe(@RequestBody recipe: Recipe): Recipe {
        return recipeService.addRecipe(recipe)
    }

    @GetMapping("/all")
    fun getAllRecipes(): List<Recipe> {
        return recipeService.getAllRecipes()
    }

}
