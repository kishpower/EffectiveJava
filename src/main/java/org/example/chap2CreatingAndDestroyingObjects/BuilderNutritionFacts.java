package org.example.chap2CreatingAndDestroyingObjects;

public class BuilderNutritionFacts {
    private final int servingSize;
    private final int servings ;

    private final int calories ;
    private final int fat ;
    private final int sodium ;
    private final int carbohydrates ;

    @Override
    public String toString() {
        return "BuilderNutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrates=" + carbohydrates +
                '}';
    }

    public BuilderNutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrates = builder.carbohydrates;
    }

    public static class Builder{
       // required parameters
       private int servingSize;
       private int servings ;

       //optional parameters - initialised to zero
       private int calories = 0;
       private int fat = 0;
       private int sodium= 0 ;
       private int carbohydrates = 0;

       public Builder(int servingSize , int servings){
           this.servings = servings;
           this.servingSize = servingSize;
       }

       public Builder calories(int val){
           this.calories = val;
           return this;
       }
       public Builder carbohydrates(int val){
           this.carbohydrates = val;
           return this;
       }
       public Builder sodium(int val){
           this.sodium = val;
           return this;
       }
       public Builder fat(int val){
           this.fat = val;
           return this;
       }

       public BuilderNutritionFacts build(){
           return new BuilderNutritionFacts(this);
       }
   }
}
