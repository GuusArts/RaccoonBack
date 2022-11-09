package demo.api;


import demo.DAL.RecipeRepository;
import demo.DAL.UserRepository;
import demo.Interface.IRecipeBLL;
import demo.OwnRecipe;
import demo.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
public class RecipeController {

    private IRecipeBLL _searchBLL;
    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RecipeRepository recipeRepository;
    public RecipeController(IRecipeBLL searchBLL) {
        _searchBLL = searchBLL;
    }

    @GetMapping ("/recipes")
    public String  GetRecipe() throws IOException, InterruptedException {

        return recipeService.GetRecipes();
    }


    @PutMapping("/UpdateRecipe")
    public OwnRecipe UpdateOwnRecipe(@RequestBody OwnRecipe ownRecipe){
        recipeRepository.deleteById(ownRecipe.getId());
        recipeRepository.save(ownRecipe);
        return ownRecipe;
    }


    @GetMapping("/OwnRecipes")
    public ResponseEntity<List<OwnRecipe>> ShowOwnRecipes() {
        return ResponseEntity.ok().body(recipeRepository.findAll());
    }



    @DeleteMapping("/OwnRecipes/{id}")
    public void DeleteOwnRecipe(@PathVariable Long id){
       recipeRepository.deleteById(id);
    }

    @PostMapping("/createrecipe")
    public OwnRecipe CreateOwnRecipe(@RequestBody OwnRecipe recipe){
         recipeRepository.save(recipe);
         return recipe;
    }

    @GetMapping("/search/{ProductName}")
    public String  SearchRecipes(@PathVariable String ProductName) throws IOException, InterruptedException {

        return _searchBLL.SearchRecipes(ProductName);
    }

    @GetMapping("/recipe/{id}")
    public Optional<OwnRecipe> getrecipe(@PathVariable Long id) {
        return recipeRepository.findById(id);
    }







}







