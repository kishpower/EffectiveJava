package org.example;

import org.example.chap2CreatingAndDestroyingObjects.BuilderNutritionFacts;
import org.example.chap2CreatingAndDestroyingObjects.JavaBeanNutritionFacts;
import org.example.chap2CreatingAndDestroyingObjects.TelescopingConstructorPatternNutritionFacts;

public class Main {
    public static void main(String[] args) {
//        telescopingConstructorPatternExample();
//        javaBeanExample();
//            builderExample();
    }

    private static void builderExample() {
        BuilderNutritionFacts facts = new BuilderNutritionFacts.Builder(240, 8).sodium(10).calories(10).fat(10)
                .carbohydrates(10)
                .build();
        System.out.println("facts = " + facts);
//        facts = BuilderNutritionFacts{servingSize=240, servings=8, calories=10, fat=10, sodium=10, carbohydrates=10}
    }

    private static void javaBeanExample() {
        JavaBeanNutritionFacts facts = new JavaBeanNutritionFacts();
        facts.setServingSize(240);
        facts.setCarbohydrates(10);
        facts.setCalories(10);
        facts.setFat(10);
        facts.setSodium(10);
        facts.setServings(10);

        System.out.println("facts = " + facts);
//        facts = JavaBeanNutritionFacts{servingSize=240, servings=10, calories=10, fat=10, sodium=10, carbohydrates=10}
    }


    public static void telescopingConstructorPatternExample(){
        TelescopingConstructorPatternNutritionFacts nutritionalFacts = new TelescopingConstructorPatternNutritionFacts(240, 8, 100, 0, 25, 27);
        System.out.println(nutritionalFacts);
//        TelescopingConstructorPatternNutritionFacts{servingSize=240, servings=8, calories=100, fat=0, sodium=25, carbohydrates=27}
        nutritionalFacts = new TelescopingConstructorPatternNutritionFacts(100, 100);
        System.out.println(nutritionalFacts);
//        TelescopingConstructorPatternNutritionFacts{servingSize=100, servings=100, calories=0, fat=0, sodium=0, carbohydrates=0}
    }
}