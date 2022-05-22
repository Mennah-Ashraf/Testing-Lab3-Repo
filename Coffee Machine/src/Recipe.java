public class Recipe {
    private int	coffeeLevel;
    private int	milkLevel;
    private java.lang.String recipeName;
    private int	sugarLevel;

    public Recipe(java.lang.String recipeName, int milkLevel, int sugarLevel, int coffeeLevel) {
        this.recipeName = (recipeName == null) ? "no name" : recipeName;
        this.milkLevel = (milkLevel == 0) ? 0 : milkLevel;
        this.sugarLevel = (sugarLevel == 0) ? 0 : sugarLevel;
        this.coffeeLevel = (coffeeLevel == 0) ? 0 : coffeeLevel;
    }

    public int	getCoffeeLevel() {
        return this.coffeeLevel;
    }

    public int	getMilkLevel() {
        return this.milkLevel;
    }

    public java.lang.String	getName() {
        return this.recipeName;
    }

    public int	getSugarLevel() {
        return this.sugarLevel;
    }
}






