public class Coffee_Machine {
    private Inventory inventory;
    static int MAX_INVENTORY;
    static int	MAX_NUM_RECIPES;
    private int	numRecipes;
    private Recipe[] recipeArray;

    public Coffee_Machine() {
        MAX_NUM_RECIPES = 4;
        MAX_INVENTORY = 20;

        this.inventory = new Inventory();
        this.inventory.setCoffee(MAX_INVENTORY);
        this.inventory.setMilk(MAX_INVENTORY);
        this.inventory.setSugar(MAX_INVENTORY);
        this.recipeArray = new Recipe [MAX_NUM_RECIPES];

        for (int i = 0; i < MAX_NUM_RECIPES; i++ ){
            this.recipeArray[i] = null;
        }
    }

    public boolean addRecipe(Recipe rAdd) {
        for (int i = 0; i < MAX_NUM_RECIPES; i++ ){
            if (this.recipeArray[i] == null) {
                this.recipeArray[i] = rAdd;
                this.numRecipes++;
                return true;
            }
        }
        return false;
    }

    public boolean deleteRecipe(java.lang.String recipeName) {
        for (int i = 0; i < MAX_NUM_RECIPES; i++ ){
            if (this.recipeArray[i].getName() == recipeName) {
                this.recipeArray[i] = null;
                this.numRecipes--;
                return true;
            }

        }
        return false;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public Recipe getRecipe(java.lang.String recipeName) {

        for (int i = 0; i < MAX_NUM_RECIPES; i++ ){
            if (this.recipeArray[i].getName() == recipeName)
                return this.recipeArray[i];
        }
        return null;
    }

    public boolean makeCoffee(java.lang.String recipeName) {
        Recipe currentRecipe = this.getRecipe(recipeName);
        if (currentRecipe != null) {
            this.inventory.setCoffee(this.inventory.getCoffee() - currentRecipe.getCoffeeLevel());
            this.inventory.setMilk(this.inventory.getMilk() - currentRecipe.getMilkLevel());
            this.inventory.setSugar(this.inventory.getSugar() - currentRecipe.getSugarLevel());
            return true;
        }
        return false;
    }
}