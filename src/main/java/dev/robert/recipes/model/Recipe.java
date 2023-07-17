package dev.robert.recipes.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String servings;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Ingredients.class)
    private List<Ingredients> ingredients;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Steps.class)
    private List<Steps> steps;
    @Lob
    private Byte[] image;
}
