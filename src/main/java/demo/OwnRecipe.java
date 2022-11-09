package demo;


import javax.persistence.*;

@Entity
@Table(name = "ownrecipes")
public class OwnRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String name;

    @Column(name="ingredients", nullable = false, length = 64)
    private String ingredients ;

    @Column(name = "calories", nullable = false, length = 20)
    private Integer calories;

    @Column(name = "preperation_Method", nullable = false, length = 100)
    private String preperationMethod;

    @Column(name = "spicyness", nullable = false, length = 20)
    private Double spicyness;

    @Column(name = "nut_Free", nullable = false, length = 20)
    private Boolean nutFree;

    @Column(name = "is_Vegan", nullable = false, length = 20)
    private Boolean isVegan;

    @Column(name = "portions", nullable = false, length = 20)
    private Integer portions;

    @Column(name = "preperation_Time", nullable = true, length = 20)
    private Integer preperationTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getpreperationMethod() {
        return preperationMethod;
    }

    public void setpreperationMethod(String preperationmethod) {
        this.preperationMethod = preperationmethod;
    }

    public Double getSpicyness() {
        return spicyness;
    }

    public void setSpicyness(double spicyness) {
        this.spicyness = spicyness;
    }

    public Boolean getNutFree() {
        return nutFree;
    }

    public void setNutFree(Boolean nutFree) {
        this.nutFree = nutFree;
    }

    public Boolean getIsVegan() {
        return isVegan;
    }

    public void setIsVegan(Boolean vegan) {
        isVegan = vegan;
    }

    public Integer getPortions() {
        return portions;
    }

    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    public Integer getPreperationTime() {
        return preperationTime;
    }

    public void setPreperationTime(Integer preperationTime) {
        this.preperationTime = preperationTime;
    }


}
