interface MealPlan {
    String getPlanDetails();

    boolean isValid();
}

class VegetarianMeal implements MealPlan {
    public String getPlanDetails() {
        return "Vegetarian Meal: Rich in veggies, legumes, and grains.";
    }

    public boolean isValid() {
        return true;
    }
}

class VeganMeal implements MealPlan {
    public String getPlanDetails() {
        return "Vegan Meal: Plant-based, no animal products.";
    }

    public boolean isValid() {
        return true;
    }
}

class KetoMeal implements MealPlan {
    private double carbGrams;

    public KetoMeal(double carbs) {
        this.carbGrams = carbs;
    }

    public String getPlanDetails() {
        return "Keto Meal: High fat, low carb (" + carbGrams + "g carbs).";
    }

    public boolean isValid() {
        return carbGrams < 20.0;
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

public class MealPlanGenerator {

    public static <T extends MealPlan> void generatePlan(Meal<T> meal) {
        T plan = meal.getMealPlan();
        if (plan.isValid()) {
            System.out.println("Generating Personalized Plan...");
            System.out.println("Plan Approved: " + plan.getPlanDetails());
        } else {
            System.out.println("Validation Failed: The provided " + plan.getClass().getSimpleName()
                    + " is not valid for the selected category.");
        }
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> veg = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoValid = new Meal<>(new KetoMeal(15.5));
        Meal<KetoMeal> ketoInvalid = new Meal<>(new KetoMeal(50.0));

        System.out.println("--- Meal Plan Generation ---");
        generatePlan(veg);
        generatePlan(vegan);
        generatePlan(ketoValid);
        generatePlan(ketoInvalid);
    }
}
