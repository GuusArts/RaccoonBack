package demo.DAL;


import demo.OwnRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<OwnRecipe, Long> {

}