import org.junit.Test;
import static org.junit.Assert.*;

public class Coffee_MachineTest {

    @Test
    public void addRecipe() {
        java.lang.String recipeName = "Dark Roast";
        int milkLevel = 2;
        int sugarLevel = 3;
        int coffeeLevel = 4;

        Coffee_Machine testCoffeeMaker = new Coffee_Machine();
        Recipe testRecipe = new Recipe(recipeName, milkLevel, sugarLevel, coffeeLevel);

        assertEquals(recipeName, testRecipe.getName());
        assertEquals(coffeeLevel, testRecipe.getCoffeeLevel());
        assertEquals(sugarLevel, testRecipe.getSugarLevel());
        assertEquals(milkLevel, testRecipe.getMilkLevel());

        if (!testCoffeeMaker.addRecipe(testRecipe)) {
            fail("Recipe not Added");
        }

        assertNotNull(testCoffeeMaker.getRecipe(recipeName));
    }

    @Test
    public void makeCoffee() {
        java.lang.String recipeName = "Dark Roast";
        int milkLevel = 2;
        int sugarLevel = 3;
        int coffeeLevel = 4;

        Coffee_Machine testCoffeeMaker = new Coffee_Machine();
        Recipe testRecipe = new Recipe(recipeName, milkLevel, sugarLevel, coffeeLevel);

        if (!testCoffeeMaker.addRecipe(testRecipe))
            fail("Recipe not Added");

        if(!testCoffeeMaker.makeCoffee(testRecipe.getName()))
            fail("Coffee not Made");

        // Ensures inventory is updated
        assertEquals(testCoffeeMaker.MAX_INVENTORY - coffeeLevel, testCoffeeMaker.getInventory().getCoffee());
        assertEquals(testCoffeeMaker.MAX_INVENTORY - sugarLevel, testCoffeeMaker.getInventory().getSugar());
        assertEquals(testCoffeeMaker.MAX_INVENTORY - milkLevel, testCoffeeMaker.getInventory().getMilk());
    }

    @Test
    public void deleteRecipe() {
        java.lang.String recipeName = "Dark Roast";
        int milkLevel = 2;
        int sugarLevel = 3;
        int coffeeLevel = 4;

        Coffee_Machine testCoffeeMaker = new Coffee_Machine();
        Recipe testRecipe = new Recipe(recipeName, milkLevel, sugarLevel, coffeeLevel);

        if (!testCoffeeMaker.addRecipe(testRecipe))
            fail("Recipe not Added");
        if (!testCoffeeMaker.deleteRecipe(testRecipe.getName()))
            fail("Recipe not Deleted");
    }

}



