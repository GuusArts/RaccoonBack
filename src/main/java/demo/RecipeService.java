package demo;

import demo.Interface.IRecipeBLL;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService implements IRecipeBLL {

    private static  List<OwnRecipe>  RecipeList = new ArrayList<>();
    public String GetRecipes() throws IOException, InterruptedException {


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://edamam-recipe-search.p.rapidapi.com/search?q=chicken"))
                .header("X-RapidAPI-Key", "8c06667cd5msh7a2d09e4a18676ap159e79jsn593e5f48e34f")
                .header("X-RapidAPI-Host", "edamam-recipe-search.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());



        return response.body();
    }




    public String SearchRecipes(String ProductName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://edamam-recipe-search.p.rapidapi.com/search?q=" + ProductName ))
                .header("X-RapidAPI-Key", "8c06667cd5msh7a2d09e4a18676ap159e79jsn593e5f48e34f")
                .header("X-RapidAPI-Host", "edamam-recipe-search.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        return response.body();
    }


public void CreateRecipe(OwnRecipe ownRecipe){
        RecipeList.add(ownRecipe);

}




}