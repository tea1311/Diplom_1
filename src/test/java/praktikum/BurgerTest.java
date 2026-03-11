package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class BurgerTest extends BurgerBaseTest {

    @Test
    public void shouldSetBunInBurger() {
        Bun bun = bunWithNameAndPrice("black bun", 100f);

        burger.setBuns(bun);

        assertSame(bun, burger.bun);
    }

    @Test
    public void shouldAddIngredientInBurger() {
        Ingredient ingredient = ingredientWithTypeNamePrice(IngredientType.SAUCE, "hot sauce", 100f);

        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertSame(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void shouldRemoveIngredientFromBurger() {
        Ingredient first = ingredientWithTypeNamePrice(IngredientType.SAUCE, "hot sauce", 100f);
        Ingredient second = ingredientWithTypeNamePrice(IngredientType.FILLING, "cutlet", 200f);
        Ingredient third = ingredientWithTypeNamePrice(IngredientType.FILLING, "sausage", 300f);

        burger.addIngredient(first);
        burger.addIngredient(second);
        burger.addIngredient(third);

        burger.removeIngredient(1);

        assertEquals(2, burger.ingredients.size());
        assertSame(first, burger.ingredients.get(0));
        assertSame(third, burger.ingredients.get(1));
    }

    @Test
    public void shouldMoveIngredientInsideBurger() {
        Ingredient first = ingredientWithTypeNamePrice(IngredientType.SAUCE, "hot sauce", 100f);
        Ingredient second = ingredientWithTypeNamePrice(IngredientType.FILLING, "cutlet", 200f);
        Ingredient third = ingredientWithTypeNamePrice(IngredientType.FILLING, "sausage", 300f);

        burger.addIngredient(first);
        burger.addIngredient(second);
        burger.addIngredient(third);

        burger.moveIngredient(0, 2);

        assertSame(second, burger.ingredients.get(0));
        assertSame(third, burger.ingredients.get(1));
        assertSame(first, burger.ingredients.get(2));
    }

    @Test
    public void shouldNotChangeOrderWhenMovingIngredientToSamePosition() {
        Ingredient first = ingredientWithTypeNamePrice(IngredientType.SAUCE, "hot sauce", 100f);
        Ingredient second = ingredientWithTypeNamePrice(IngredientType.FILLING, "cutlet", 200f);

        burger.addIngredient(first);
        burger.addIngredient(second);

        burger.moveIngredient(1, 1);

        assertSame(first, burger.ingredients.get(0));
        assertSame(second, burger.ingredients.get(1));
    }

    @Test
    public void shouldGenerateCorrectReceipt() {
        Bun bun = bunWithNameAndPrice("black bun", 100f);
        Ingredient sauce = ingredientWithTypeNamePrice(IngredientType.SAUCE, "hot sauce", 100f);
        Ingredient filling = ingredientWithTypeNamePrice(IngredientType.FILLING, "cutlet", 200f);

        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String expectedReceipt =
                String.format("(==== %s ====)%n", "black bun") +
                        String.format("= %s %s =%n", "sauce", "hot sauce") +
                        String.format("= %s %s =%n", "filling", "cutlet") +
                        String.format("(==== %s ====)%n", "black bun") +
                        String.format("%nPrice: %f%n", 500f);

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void shouldGenerateReceiptWithoutIngredients() {
        Bun bun = bunWithNameAndPrice("white bun", 200f);
        burger.setBuns(bun);

        String expectedReceipt =
                String.format("(==== %s ====)%n", "white bun") +
                        String.format("(==== %s ====)%n", "white bun") +
                        String.format("%nPrice: %f%n", 400f);

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenRemovingIngredientFromEmptyBurger() {
        burger.removeIngredient(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenMovingIngredientWithInvalidIndex() {
        burger.addIngredient(ingredientWithTypeNamePrice(IngredientType.SAUCE, "hot sauce", 100f));

        burger.moveIngredient(5, 0);
    }

    @Test
    public void shouldCalculatePriceWithOnlyBun() {
        burger.setBuns(bunWithPrice(150f));

        assertEquals(300f, burger.getPrice(), 0.0001f);
    }
}