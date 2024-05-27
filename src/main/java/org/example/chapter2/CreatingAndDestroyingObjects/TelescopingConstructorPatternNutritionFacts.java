package org.example.chapter2.CreatingAndDestroyingObjects;

public class TelescopingConstructorPatternNutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrates;

    public TelescopingConstructorPatternNutritionFacts(int servingSize, int servings) {
        this(servingSize, servings,   0);
    }
    public TelescopingConstructorPatternNutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories ,  0);
    }
    public TelescopingConstructorPatternNutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories , fat , 0);
    }

    @Override
    public String toString() {
        return "TelescopingConstructorPatternNutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrates=" + carbohydrates +
                '}';
    }

    public TelescopingConstructorPatternNutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories , fat , sodium , 0);
    }

    public TelescopingConstructorPatternNutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrates) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrates = carbohydrates;
    }
}
